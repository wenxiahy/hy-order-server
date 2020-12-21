package com.wenxiahy.hy.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-21
 */
@SpringBootApplication(scanBasePackages = {"com.wenxiahy.hy"})
@EnableDiscoveryClient
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }
}
