package com.design.machineManagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * (Maintain)实体类
 *
 * @author makejava
 * @since 2022-07-26 14:49:38
 */
public class Maintain implements Serializable {
    private static final long serialVersionUID = -60836201235484000L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 维修工单
     */
    private String orderId;
    /**
     * 工单问题
     */
    private String problem;
    /**
     * 电脑编号
     */
    private String computerNo;
    /**
     * 机房号
     */
    private String roomNo;
    /**
     * 维修时间
     */
    private Timestamp maintainTime;
    /**
     * 报修时间
     */
    private Timestamp createdAt;
    /**
     * 报修人姓名
     */
    private String userName;
    /**
     * 报修人电话
     */
    private String userPhone;
    /**
     * 1 为修好 0 为报废
     */
    private Integer status;
    /**
     * 维修人
     */
    private String worker;
    /**
     * 维修人电话
     */
    private String maintainPhone;
    /**
     * 额外字段 角色
     */
    private String role;
    /**
     * 额外字段  维修单处理之后就不给删除操作了
     */
    private boolean disabled;
    /**
     * 额外字段  维修状态
     */
    private String maintenanceState;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 条数
     */
    private Integer count;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(String maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getComputerNo() {
        return computerNo;
    }

    public void setComputerNo(String computerNo) {
        this.computerNo = computerNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Timestamp getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Timestamp maintainTime) {
        this.maintainTime = maintainTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMaintainPhone() {
        return maintainPhone;
    }

    public void setMaintainPhone(String maintainPhone) {
        this.maintainPhone = maintainPhone;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }
}
