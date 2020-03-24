package com.myzmds.sociology.mask.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myzmds.sociology.mask.common.FlagConfig;
import com.myzmds.sociology.mask.entity.People;
import com.myzmds.sociology.mask.mapper.PeopleMapper;
import com.myzmds.sociology.mask.mapper.RegConfigMapper;

/**
 * @类名称 PeopleRegService.java
 * @类描述 <pre>个人口罩预约服务类</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午10:25:03
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
public class PeopleRegService {
    @Autowired
    PeopleMapper peopleMapper;
    
    @Autowired
    RegConfigMapper configMapper;
    
    /**
     * @方法名称 reg
     * @功能描述 <pre>预约</pre>
     * @param list 预约人列表
     */
    public void reg(List<People> list) {
        if (list.size() > 0) {
            int cycle = (int)Math.ceil(list.size() / 600);
            for (int i = 0; i < cycle;) {
                int start = cycle * i;
                int last = cycle * (++i);
                if (last > list.size()) {
                    last = list.size();
                }
                peopleMapper.insertList(list.subList(start, last));
            }
            FlagConfig.curConfig.surplus = FlagConfig.curConfig.surplus - list.size() * FlagConfig.limitNum;
            peopleMapper.insertList(list);
            configMapper.updateByPrimaryKey(FlagConfig.curConfig);
        }
    }
    
    /**
     * @方法名称 getHistory
     * @功能描述 <pre>获取指定天数的历史预约人</pre>
     * @param days 指定天数
     * @return 黑名单列表
     */
    public Map<String, Vector<String>> getHistory(int days) {
        Map<String, Vector<String>> result = new HashMap<>(Math.abs(days));
        LocalDate now = LocalDate.now();
        result.put(now.toString(), new Vector<String>(10000));
        for (int i = 1; i < Math.abs(days); i++) {
            now = now.plusDays(-1);
            result.put(now.toString(), new Vector<String>(10000));
        }
        List<Map<String, String>> histroy = peopleMapper.getHistory(now.toString());
        histroy.stream().parallel().forEach(item -> {
            String date = item.get("riqi");
            result.get(date).add(item.get("shouji"));
            result.get(date).add(item.get("shenfenzheng"));
        });
        return result;
    }
}
