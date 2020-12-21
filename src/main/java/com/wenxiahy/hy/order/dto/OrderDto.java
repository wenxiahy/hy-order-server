package com.wenxiahy.hy.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
public class OrderDto implements Serializable {

    @JsonProperty("order_no")
    private long orderNo;

    @JsonProperty("order_type")
    private int orderType;

    @JsonProperty("order_status")
    private int orderStatus;

    @JsonProperty("store_code")
    private String storeCode;

    @JsonProperty("store_name")
    private String storeName;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("order_time")
    private Date orderTime;

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
