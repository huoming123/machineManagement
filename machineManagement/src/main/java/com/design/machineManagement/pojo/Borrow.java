package com.design.machineManagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Borrow)实体类
 *
 * @author makejava
 * @since 2022-07-25 16:13:04
 */
public class Borrow implements Serializable {
    private static final long serialVersionUID = 652033078744873137L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 机房id  用这个跟机房表关联
     */
    private Integer machineId;
    /**
     * 用户id  用这个跟users表关联 根据这个可以查出是谁借的机房
     */
    private Integer userId;
    /**
     * 上课时间
     */
    private Timestamp classTime;
    /**
     * 申请时间
     */
    private Timestamp borrowTime;
    /**
     * 审核 1为通过 0 为作废
     */
    private Integer checked;
    /**
     * 审核人
     */
    private String checkMan;

    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 理由
     */
    private String reason;
    /**
     *   额外字段  机房号  不是这个表的字段 这里只是为了给个字段 把数据在前端显示出来
     */
    private String roomNo;
    /**
     * 额外字段 教师名字
     */
    private String userName;
    /**
     * 额外字段 编辑状态 如果审核为未审核的话为可编辑
     */
    private Boolean disabled;

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getClassTime() {
        return classTime;
    }

    public void setClassTime(Timestamp classTime) {
        this.classTime = classTime;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
