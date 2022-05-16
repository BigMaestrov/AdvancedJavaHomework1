package ru.bigmaestrov.restapi.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanE {

    public static BeanE createBean() {
        System.out.println("beanE constructor");
        return new BeanE();
    }

    public void doMyInit() {
        System.out.println("do beanE initialization");
    }

    public void doMyDestroy() {
        System.out.println("do beanE destruction");
    }
}