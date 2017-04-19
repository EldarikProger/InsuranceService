package com.dreamteam.models;


import java.io.Serializable;

/**
 * Данные пользователя и его статистика
 */
public class UserData implements Serializable {

    private String fname;
    private String sname;
    private String mname;
    private int countIssued;
    private int countunIssued;
    private int count;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getCountIssued() {
        return countIssued;
    }

    public void setCountIssued(int countIssued) {
        this.countIssued = countIssued;
    }

    public int getCountUnIssued() {
        return countunIssued;
    }

    public UserData() {
    }

    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCountUnIssued(int countunIssued) {
        this.countunIssued = countunIssued;
    }

    public UserData(String fname, String sname, String mname, int countIssued, int countunIssued, int count) {
        this.fname = fname;
        this.sname = sname;
        this.mname = mname;
        this.countIssued = countIssued;
        this.countunIssued = countunIssued;
        this.count = count;
    }
}
