package com.dreamteam.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Client
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fName;
    private String sName;
    private String mName;
    private Date bDay;
    @OneToMany(mappedBy = "client")
    private List<Insurance> insuranceList;

    public Client(String fName, String sName, String mName, Date bDay) {
        this.fName = fName;
        this.sName = sName;
        this.mName = mName;
        this.bDay = bDay;
    }

    public Client() {
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

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }
}
