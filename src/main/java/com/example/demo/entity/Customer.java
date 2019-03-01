package com.example.demo.entity;

import org.joda.time.DateTime;

import javax.persistence.Entity;

@Entity
public class Customer implements Comparable<Customer> {

    private long id;

    private String name;

    private DateTime duetime;

    private String jointime;

    public Customer() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(DateTime duetime) {
        this.duetime = duetime;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    @Override
    public int compareTo(Customer o) {
        return getDuetime().compareTo(o.getDuetime());
    }

}
