package com.wenxiahy.hy.order.mapper.main;

import org.apache.ibatis.annotations.Select;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-27
 */
public interface MainMapper {

    /**
     * count
     *
     * @return
     */
    @Select("SELECT COUNT(1) FROM account")
    Long count();
}
