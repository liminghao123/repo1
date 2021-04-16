package com.lmh.o3;

import java.sql.Date;

public class Emp {
    private  Integer id;
    private  String name;
    private  Double salary;
    private  Date birthday;
    private  Integer age;

    public Emp() {
    }

    public Emp(Integer id, String name, Double salary, Date birthday, Integer age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
        this.age = age;
    }

    public Emp(String name,  Integer age, Double salary) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
