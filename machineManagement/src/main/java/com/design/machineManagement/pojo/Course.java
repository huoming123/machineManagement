package com.design.machineManagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2022-07-21 17:21:20
 */
public class Course implements Serializable {
    private static final long serialVersionUID = -60851252680518599L;
    /**
     * 主键id 自增id
     */
    private Integer id;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 创建时间
     */
    private Timestamp createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 课时
     */
    private Integer  hours;

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
