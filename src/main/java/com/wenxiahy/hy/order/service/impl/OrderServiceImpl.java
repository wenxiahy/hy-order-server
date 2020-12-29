package com.wenxiahy.hy.order.service.impl;

import com.wenxiahy.hy.data.order.Order;
import com.wenxiahy.hy.order.mapper.main.MainMapper;
import com.wenxiahy.hy.order.mapper.order.OrderMapper;
import com.wenxiahy.hy.order.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private MainMapper mainMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderByOrderNo(long userId, long orderNo) {
        return orderMapper.getOne(userId, orderNo);
    }

    @Override
    public long count(String db) {
        if ("main".equals(db)) {
            return mainMapper.count();
        } else if ("order".equals(db)) {
            return orderMapper.count();
        }

        throw new IllegalArgumentException("error db with " + db);
    }
}
