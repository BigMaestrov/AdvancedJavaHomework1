package ru.bigmaestrov.restapi.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanD {

    public static BeanD createBean() {
        System.out.println("beanD constructor");
        return new BeanD();
    }

    public void doMyInit(){
        System.out.println("do beanD initialization");
    }

    public void doMyDestroy(){
        System.out.println("do beanD destruction");
    }
}