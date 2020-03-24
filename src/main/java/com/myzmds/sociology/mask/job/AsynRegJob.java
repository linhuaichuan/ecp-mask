package com.myzmds.sociology.mask.job;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.myzmds.sociology.mask.common.FlagConfig;
import com.myzmds.sociology.mask.entity.People;
import com.myzmds.sociology.mask.service.ConfigService;
import com.myzmds.sociology.mask.service.PeopleRegService;

/**
 * @类名称 AsynRegJob.java
 * @类描述 <pre>异步登记批</pre>
 * @作者  庄梦蝶殇 linhuaichuan@veredholdings.com
 * @创建时间 2020年2月29日 下午4:16:06
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
@Component
@EnableScheduling
public class AsynRegJob implements InitializingBean, DisposableBean {
    @Autowired
    ConfigService configService;
    
    @Autowired
    PeopleRegService peopleRegService;
    
    /**
     * @方法名称 dots
     * @功能描述 <pre>每隔5秒更新一次 网点</pre>
     */
    @Scheduled(fixedDelay = 5000)
    public void dots() {
        FlagConfig.dots = new Vector<>(configService.getDots());
    }
    
    /**
     * @方法名称 blacklist
     * @功能描述 <pre>每天更新一次黑名单(5天内购买人员)</pre>
     */
    @Scheduled(cron = "50 59 23 * * ?")
    public void blacklist() {
        if (FlagConfig.blacklist.size() == 0) {
            // 启动加载
            FlagConfig.blacklist.putAll(peopleRegService.getHistory(FlagConfig.blackDays));
        } else {
            // 23:59:50 预加载次日黑名单
            LocalDate nextDay = LocalDate.now().plusDays(1);
            FlagConfig.blacklist.put(nextDay.toString(), new Vector<String>(10000));
            FlagConfig.blacklist.remove(nextDay.plusDays(FlagConfig.blackDays).toString());
        }
    }
    
    /**
     * @方法名称 limit
     * @功能描述 <pre>限购配置更新(每秒)</pre>
     */
    @Scheduled(fixedDelay = 5000)
    public void limit() {
        if (FlagConfig.curPeople.size() == 0) {
            // 等待配置
            if (null != FlagConfig.configCountDownLatch) {
                try {
                    FlagConfig.configCountDownLatch.await();
                } catch (InterruptedException e) {
                    return;
                }
            }
            // 锁定配置
            FlagConfig.configCountDownLatch = new CountDownLatch(1);
            FlagConfig.curConfig = configService.getNowCofig();
            FlagConfig.surplusNum = new AtomicInteger(null == FlagConfig.curConfig ? 0 : (int)Math.ceil(FlagConfig.curConfig.surplus / 5));
            FlagConfig.configCountDownLatch.countDown();
        }
    }
    
    /**
     * @方法名称 reg
     * @功能描述 <pre>异步预约登记(每秒)</pre>
     */
    @Scheduled(fixedDelay = 1000)
    public void reg() {
        if (FlagConfig.curPeople.size() > 0) {
            // 等待配置
            if (null != FlagConfig.configCountDownLatch) {
                try {
                    FlagConfig.configCountDownLatch.await();
                } catch (InterruptedException e) {
                    return;
                }
            }
            // 锁定配置
            FlagConfig.configCountDownLatch = new CountDownLatch(1);
            List<People> peoples = new ArrayList<>();
            peoples.addAll(FlagConfig.curPeople);
            FlagConfig.curPeople.removeAll(peoples);
            peopleRegService.reg(peoples);
            FlagConfig.configCountDownLatch.countDown();
        }
    }
    
    @Override
    public void afterPropertiesSet()
        throws Exception {
        limit();
        dots();
        blacklist();
    }
    
    @Override
    public void destroy()
        throws Exception {
        // 优雅停机，清空 登记人列表
        reg();
    }
}
