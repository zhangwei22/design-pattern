package com.decorate;

import com.decorate.modul.*;
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
        Person person = new Person("伟神");
        System.out.println("第一种装扮：");

        Sneakers sneakers = new Sneakers();
        BigTrouser bigTrouser = new BigTrouser();
        TShirits tShirits = new TShirits();

        sneakers.decorate(person);
        bigTrouser.decorate(sneakers);
        tShirits.decorate(bigTrouser);
        tShirits.show();

        System.out.println("第二种装饰：");

        LeatherShoes leatherShoes = new LeatherShoes();
        Tie tie = new Tie();
        Suit suit = new Suit();

        leatherShoes.decorate(person);
        tie.decorate(leatherShoes);
        suit.decorate(tie);
        suit.show();
    }
}
