package com.wenxiahy.hy.order.mapper.order;

import com.wenxiahy.hy.data.order.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-27
 */
public interface OrderMapper {

    /**
     * count
     *
     * @return
     */
    @Select("SELECT COUNT(1) FROM ch_user")
    Long count();

    /**
     * getOne
     *
     * @param userId
     * @param orderNo
     * @return
     */
    @Select("SELECT * FROM order WHERE user_id = #{userId} AND order_no = #{orderNo}")
    @Results({
            @Result(property = "orderNo", column = "order_no"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "orderType", column = "order_type"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "storeCode", column = "store_code"),
            @Result(property = "storeName", column = "store_name"),
            @Result(property = "orderTime", column = "order_time"),
    })
    Order getOne(Long userId, Long orderNo);
}
