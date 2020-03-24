package com.myzmds.sociology.mask.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myzmds.sociology.mask.entity.Dot;
import com.myzmds.sociology.mask.entity.RegConfig;
import com.myzmds.sociology.mask.mapper.DotMapper;
import com.myzmds.sociology.mask.mapper.RegConfigMapper;

/**
 * @类名称 ConfigService.java
 * @类描述 <pre>配置查询类</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午12:50:05
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
public class ConfigService {
    @Autowired
    DotMapper dotMapper;
    
    @Autowired
    RegConfigMapper configMapper;
    
    /**
     * @方法名称 getNowCofig
     * @功能描述 <pre>获取当天配置</pre>
     * @return 当前配置
     */
    public RegConfig getNowCofig() {
        RegConfig config = new RegConfig();
        config.date = LocalDate.now().toString();
        List<RegConfig> list = configMapper.selectLike(config);
        return null == list || list.size() == 0 ? null : list.get(0);
    }
    
    /**
     * @方法名称 surplus
     * @功能描述 <pre>网点查询</pre>
     * @return 网点列表
     */
    public List<Dot> getDots() {
        return dotMapper.selectAll();
    }
}
