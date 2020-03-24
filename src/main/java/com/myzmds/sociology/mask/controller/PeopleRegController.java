package com.myzmds.sociology.mask.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.myzmds.sociology.mask.common.FlagConfig;
import com.myzmds.sociology.mask.entity.People;

/**
 * @类名称 PeopleRegController.java
 * @类描述 <pre>个人口罩预约登记控制类</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午5:52:37
 * @版本 1.0.0
 *
 * @修改记录
 * <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.00 	庄梦蝶殇 	2020年2月29日             
 *     ----------------------------------------------
 * </pre>
 */
@Controller
@RequestMapping("/")
public class PeopleRegController {
    
    /**
     * @方法名称 subscribe
     * @功能描述 <pre>预约页面</pre>
     * @return 
     */
    @RequestMapping("/")
    public String subscribe(Model model) {
        int total = 0;
        if (null != FlagConfig.curConfig) {
            total = FlagConfig.curConfig.total;
        }
        model.addAttribute("total", total);
        
        // 等待配置
        if (null != FlagConfig.configCountDownLatch) {
            try {
                FlagConfig.configCountDownLatch.await();
            } catch (InterruptedException e) {
            }
        }
        model.addAttribute("surplus", FlagConfig.curConfig.surplus - FlagConfig.curPeople.size() * FlagConfig.limitNum);
        model.addAttribute("dots", FlagConfig.dots);
        return "index";
    }
    
    @ResponseBody
    @RequestMapping("/reg")
    public String reg(People people) {
        if (null == people || people.validate()) {
            out("数据不规范！");
            return null;
        }
        if (null == FlagConfig.curConfig || 0 != FlagConfig.curConfig.state) {
            out("预约尚未开放，请等待通知！");
            return null;
            
        }
        // 该手机或身份证已预约过了
        StringBuffer nextDate = new StringBuffer("");
        if (FlagConfig.validate(people.getTel(), people.getIdCard(), nextDate)) {
            out("该手机或身份证已预约过了,下次可预约时间为“" + nextDate + "”");
            return null;
        }
        // 等待配置
        if (null != FlagConfig.configCountDownLatch) {
            try {
                FlagConfig.configCountDownLatch.await();
            } catch (InterruptedException e) {
                // 释放预占
                FlagConfig.surplusNum.getAndIncrement();
                out("系统繁忙，请重试！");
                return null;
            }
        }
        // 预约
        if (FlagConfig.surplusNum.getAndDecrement() > 0) {
            // 预约成功
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime now = LocalDateTime.now();
            Instant instant = now.atZone(zone).toInstant();
            people.setDate(Date.from(instant));
            
            // 加入预约列表
            FlagConfig.curPeople.add(people);
            // 加入黑名单
            String nowDate = now.toLocalDate().toString();
            FlagConfig.blacklist.get(nowDate).add(people.getTel());
            FlagConfig.blacklist.get(nowDate).add(people.getIdCard());
            // 预约已满
            out("预约成功！");
            return null;
        } else {
            // 预约已满
            out("对不起，今日预约名额已满！");
            return null;
        }
    }
    
    public static void out(String result) {
        HttpServletResponse resp = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getResponse();
        // 是否支持cookie跨域
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        // 解决跨域访问报错--req.getHeader("Origin")
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        // 设置过期时间
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
        // 支持HTTP1.1.
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        // 支持HTTP 1.0.
        resp.setHeader("Pragma", "no-cache");
        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            out.println(result);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.close();
            }
        }
    }
}
