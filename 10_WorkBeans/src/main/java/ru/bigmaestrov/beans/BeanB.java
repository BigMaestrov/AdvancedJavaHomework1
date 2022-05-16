package ru.bigmaestrov.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements Bean{
    Bean bean;

    //task 2
    //public BeanB() {
    //    this.bean = new BeanA();
    //}

    //task 3
    public BeanB() {
        this.bean = new BeanC();
    }

    @Lookup
    public Bean getBean() {
        return bean;
    }
}