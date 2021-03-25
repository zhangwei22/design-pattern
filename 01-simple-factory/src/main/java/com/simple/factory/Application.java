package com.simple.factory;

import com.simple.factory.modul.Operation;
import com.simple.factory.web.OperationFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 设计模式：简单工厂模式
 */
@SpringBootApplication
public class Application implements InitializingBean {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 通过工厂类获取乘法操作对象
        Operation operation = OperationFactory.createOperate("*");
        // 做乘法操作，获取计算结果
        Double result = operation.getResult(12.5, 89.6);
        System.out.println("计算结果: " + result);
    }
}
