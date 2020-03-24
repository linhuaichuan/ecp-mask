package com.myzmds.sociology.mask.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myzmds.sociology.mask.extend.LikeField;

/**
 * @类名称 RegConfig.java
 * @类描述 <pre>登记配置</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午12:34:47
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
@Entity
@Table(name = "dayxg")
@LikeField(fields = {"date"})
public class RegConfig implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    public Integer id;
    
    /**
     * 总量
     */
    @Column(name = "xianshu")
    public Integer total;
    
    /**
     * 剩余量
     */
    @Column(name = "yushu")
    public Integer surplus;
    
    /**
     * 状态：0-预约中，1-暂停，2-过期
     */
    @Column(name = "chuli")
    public Integer state;
    
    /**
     * 日期
     */
    @Column(name = "riqi")
    public String date;
}
