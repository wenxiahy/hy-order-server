package com.wenxiahy.hy.order.service;

import com.wenxiahy.hy.data.order.Order;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
public interface IOrderService {

    /**
     * 查询Order，这个返回应该是一个OrderBean，在Common中定义
     *
     * @param userId
     * @param orderNo
     * @return
     */
    Order getOrderByOrderNo(long userId, long orderNo);

    /**
     * 测试多数据源
     *
     * @param db
     * @return
     */
    long count(String db);
}
