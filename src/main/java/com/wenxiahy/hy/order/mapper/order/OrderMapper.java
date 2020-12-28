package com.wenxiahy.hy.order.mapper.order;

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
}
