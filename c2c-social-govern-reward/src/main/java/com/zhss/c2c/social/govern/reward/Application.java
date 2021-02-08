package com.zhss.c2c.social.govern.reward;

import com.zhss.c2c.social.govern.reward.db.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class Application {

    // 启动奖励服务
    // 扫描注解 根据配置扫描 扫描包下有@Service 发布这些服务 监听20880端口 找到注册中心 注册进去
    public static void main(String[] args) {
        SpringApplication.run(com.zhss.c2c.social.govern.reward.Application.class, args);
    }

}
