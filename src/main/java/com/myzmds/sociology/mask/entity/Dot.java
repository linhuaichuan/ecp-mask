package com.myzmds.sociology.mask.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @类名称 Dot.java
 * @类描述 <pre>网点类</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午12:07:07
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
@Table(name = "gydian")
public class Dot implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    Integer id;
    
    /**
     * 供销社业务主键
     */
    @Column(name = "gydid")
    String bizId;
    
    /**
     * 供销社名字
     */
    @Column(name = "gydmz")
    String name;
    
    /**
     * 排序
     */
    @Column(name = "paixu")
    Integer sort;
    
    @Override
    public String toString() {
        return new StringBuffer().append("[name=").append(this.name).append(",sort=").append(sort).append("]").toString();
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getBizId() {
        return bizId;
    }
    
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
