package com.design.machineManagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Machine)实体类
 *
 * @author makejava
 * @since 2022-07-25 09:09:10
 */
public class Machine implements Serializable {
    private static final long serialVersionUID = -81273058065960076L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 机房号
     */
    private String roomNo;
    /**
     * 容纳人数
     */
    private Integer num;
    /**
     * 机房介绍
     */
    private String describ;
    /**
     * 机房照片
     */
    private String image;
    /**
     * 照片路劲
     */
    private String imageUrl;
    /**
     * 创建时间
     */
    private Timestamp createdAt;
    /**
     * 创建时间
     */
    private String createdBy;
    /**
     * 修改时间
     */
    private Timestamp updatedAt;
    /**
     * 修改人
     */
    private String updatedBy;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
