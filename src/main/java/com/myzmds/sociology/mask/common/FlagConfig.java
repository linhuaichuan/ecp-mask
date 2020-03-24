package com.myzmds.sociology.mask.common;

import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import com.myzmds.sociology.mask.entity.Dot;
import com.myzmds.sociology.mask.entity.People;
import com.myzmds.sociology.mask.entity.RegConfig;

/**
 * @类名称 FlagConfig.java
 * @类描述 <pre>异步配置类</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午10:23:14
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
public class FlagConfig {
    /**
     * 网点列表
     */
    public static Vector<Dot> dots = new Vector<>();
    
    /**
     * 黑名单列表
     */
    public static ConcurrentHashMap<String, List<String>> blacklist = new ConcurrentHashMap<>();
    
    /**
     * 黑名单天数
     */
    public static int blackDays = -5;
    
    /**
     * 限购个数
     */
    public static int limitNum = 10;
    
    /**
     * 当天的限购配置
     */
    public static volatile RegConfig curConfig = null;
    
    /**
     * 配置线程同步标识
     */
    public static CountDownLatch configCountDownLatch = null;
    
    /**
     * 等待入库的预约人列表
     */
    public static Vector<People> curPeople = new Vector<>();
    
    /**
     * 当天剩余可约人数
     */
    public static AtomicInteger surplusNum = new AtomicInteger(0);
    
    /**
     * @方法名称 validate
     * @功能描述 <pre>黑名单校验</pre>
     * @param tel 手机号
     * @param idCard 身份证
     * @param nextDate 下一个可约日
     * @return 是否通过
     */
    public static boolean validate(String tel, String idCard, StringBuffer nextDate) {
        for (Entry<String, List<String>> item : blacklist.entrySet()) {
            if (item.getValue().contains(tel) || item.getValue().contains(idCard)) {
                nextDate.append(LocalDate.parse(item.getKey()).plusDays(Math.abs(blackDays)));
                return true;
            }
        }
        return false;
    }
}
