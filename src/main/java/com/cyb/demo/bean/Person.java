package com.cyb.demo.bean;

/**
 * 人的模型对象
 *
 * @author mercyblitz
 * @date 2017-10-14
 **/
public class Person {

    private Long id;

    private String name;

    public Person(){
        super();
    }

    public Person(Long id,String name){
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
