package com.myzmds.sociology.mask.extend;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * @类名称 LikeSelectMapper.java
 * @类描述 <pre>like查询通用Mapper接口</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2019年5月10日 下午2:58:10
 * @版本 1.0.0
 *
 * @修改记录
 * <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.0.0 	庄梦蝶殇 	2019年5月10日             
 *     ----------------------------------------------
 * </pre>
 */
@RegisterMapper
public interface LikeSelectMapper<T> {
    
    /**
     * @方法名称 selectLike
     * @功能描述 <pre>根据实体中的属性值进行查询，查询条件使用like</pre>
     * @param record 查询条件
     * @return 查询结果
     */
    @SelectProvider(type = LikeSelectProvider.class, method = "dynamicSQL")
    List<T> selectLike(T record);
}
