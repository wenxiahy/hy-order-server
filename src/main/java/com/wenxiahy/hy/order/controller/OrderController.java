package com.wenxiahy.hy.order.controller;

import com.wenxiahy.hy.common.bean.auth.AuthenticationUser;
import com.wenxiahy.hy.common.support.BaseController;
import com.wenxiahy.hy.common.support.HyResponse;
import com.wenxiahy.hy.order.dto.OrderDto;
import com.wenxiahy.hy.order.dto.request.GetOrderRequest;
import com.wenxiahy.hy.order.service.IOrderService;
import com.wenxiahy.hy.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;

    @Resource(name = "orderRedisService")
    private RedisService orderRedisService;

    @PostMapping("/get")
    public HyResponse<OrderDto> getOrder(@RequestAttribute("auth_user") AuthenticationUser authUser,
                                         @Valid @RequestBody GetOrderRequest request, BindingResult bindingResult) {
        long userId = authUser.getUserId();
        long orderNo = request.getOrderNo();

        String key = "order_no:" + orderNo;
        OrderDto dto = (OrderDto) orderRedisService.get(key);
        if (dto == null) {
            LOGGER.info("Redis中没有OrderDto，查询数据库，order_no：{}", orderNo);

            Object order = orderService.getOrderByOrderNo(userId, orderNo);
            if (order == null) {
                LOGGER.info("订单不存在，order_no：{}", orderNo);
                return noData();
            }

            dto = new OrderDto();
            dto.setOrderNo(orderNo);
            dto.setOrderType(1);
            dto.setOrderStatus(11);
            dto.setStoreCode("WH019");
            dto.setStoreName("武汉街道口019店");
            dto.setOrderTime(new Date());

            boolean redisRst = orderRedisService.set(key, dto);
            if (!redisRst) {
                LOGGER.error("订单缓存失败，order_no：{}", orderNo);
            }
        }

        return ok(dto);
    }

    @GetMapping("/count/{db}")
    public long count(@PathVariable("db") String db) {
        return orderService.count(db);
    }
}
