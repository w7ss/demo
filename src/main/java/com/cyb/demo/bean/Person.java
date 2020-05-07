package com.cyb.demo.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Person {
    @Max(9999)
    @Min(1000)
    private Long id;

    @NotNull
    private String name;

    private String code;

    public Person(){
        super();
    }

    public Person(Long id,String name,String code){
        this.id=id;
        this.name=name;
        this.code=code;
    }
}
