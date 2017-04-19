package com.dreamteam.models;

import java.io.Serializable;

/**
 * Данные страховщика
 */
public class InsurerData implements Serializable{

    private String fname;
    private String mname;
    private String sname;
    private String login;
    private String password;

    public InsurerData(String fname, String mname, String sname, String login, String password) {
        this.fname = fname;
        this.mname = mname;
        this.sname = sname;
        this.login = login;
        this.password = password;
    }

    public InsurerData(){

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
