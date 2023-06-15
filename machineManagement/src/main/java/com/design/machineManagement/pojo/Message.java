package com.design.machineManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2022-09-01 14:59:31
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -73984008532197660L;
    /**
     * 主键id 自增id
     */
    private Integer id;
    /**
     * 通告
     */
    private String message;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 是否显示 1 为显示 0 为关闭
     */
    private Integer showIn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getShowIn() {
        return showIn;
    }

    public void setShowIn(Integer showIn) {
        this.showIn = showIn;
    }

}
