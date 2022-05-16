package ru.bigmaestrov.restapi.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanA implements Bean {
    String string;

    public void setString(String string) {
        this.string = string;
    }

    public BeanA() {
        this.string = "defaultString";
    }

    public String getString() {
        return string;
    }
}