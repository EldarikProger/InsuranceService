package com.dreamteam.model;

public class AdminData {

    private long id;
    private String fName;
    private String sName;
    private String mName;
    private String login;
    private String password;

    public AdminData(long id, String fName, String sName, String mName, String login, String password) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.mName = mName;
        this.login = login;
        this.password = password;
    }

    public AdminData() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
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
