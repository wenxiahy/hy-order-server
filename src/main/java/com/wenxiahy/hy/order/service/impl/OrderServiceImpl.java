package com.wenxiahy.hy.order.service.impl;

import com.wenxiahy.hy.order.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Object getOrderByOrderNo(long userId, long orderNo) {
        LOGGER.info("getOrderByOrderNo(user_id: {}, order_no: {})", userId, orderNo);
        return new Object();
    }
}
