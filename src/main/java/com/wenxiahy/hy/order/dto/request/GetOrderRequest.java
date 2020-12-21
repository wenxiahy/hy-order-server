package com.wenxiahy.hy.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wenxiahy.hy.common.support.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
public class GetOrderRequest extends BaseRequest {

    @NotNull
    @JsonProperty("order_no")
    private Long orderNo;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }
}
