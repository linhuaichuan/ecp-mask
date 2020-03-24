package com.myzmds.sociology.mask.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

/**
 * @类名称 People.java
 * @类描述 <pre>个人预约登记信息</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2020年2月29日 下午12:31:24
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
@Table(name = "yuyue")
public class People implements Serializable {
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
     * 姓名
     */
    @Column(name = "xingming")
    String name;
    
    /**
     * 手机
     */
    @Column(name = "shouji")
    String tel;
    
    /**
     * 地址
     */
    @Column(name = "zhuzhi")
    String address;
    
    /**
     * 身份证
     */
    @Column(name = "shenfenzheng")
    String idCard;
    
    /**
     * 网点id
     */
    @Column(name = "pqid")
    Integer dotId;
    
    /**
     * 日期
     */
    @Column(name = "riqi")
    Date date;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    public Integer getDotId() {
        return dotId;
    }
    
    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public boolean validate() {
        return StringUtils.isEmpty(name) || StringUtils.isEmpty(tel) || StringUtils.isEmpty(address) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(dotId) || tel.length() > 11 || idCard.length() > 18 || address.length() > 50;
    }
}
