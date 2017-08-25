package com.simple.factory;

import com.simple.factory.modul.Operation;
import com.simple.factory.modul.OperationFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements InitializingBean {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Operation operation = OperationFactory.createOperate("*");
        Double result = operation.getResult(12.5, 89.6);
        System.out.println("result: " + result);
    }
}
