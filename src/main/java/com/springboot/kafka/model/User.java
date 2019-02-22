package com.springboot.kafka.model;

import java.io.Serializable;

/**
 * @author liupeqing
 * @date 2019/2/21 20:28
 */
public class User implements Serializable {

    private String name;
    private String dept;
    private Long salary;

    public User(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
