package ru.bigmaestrov.workbeans.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanC implements Bean{
    String string;


    public void setString(String string) {
        this.string = string;
    }


}