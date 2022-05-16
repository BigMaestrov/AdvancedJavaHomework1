package ru.bigmaestrov.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //task1
        //System.out.println(context.getBean("beanA", BeanA.class).getString());
        //context.getBean("beanA", BeanA.class).setString("newString");
        //System.out.println(context.getBean("beanA", BeanA.class).getString());

        //task2
        //System.out.println(context.getBean("beanB", BeanB.class).getBean().getClass());

        //task3
        //System.out.println(context.getBean("beanB", BeanB.class).getBean().getClass());

        //task4
        //context.getBean("beanD", BeanD.class);

        //task5
        //context.getBean("beanE", BeanE.class);

        context.close();
    }
}
