package com.dreamteam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Auto. Client car.
 */
@Entity
public class Auto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fName;
    private String sName;
    private String carVin;
    private String carNumber;
    private String ptsSeries;
    private String ptsNumber;
    private int power;
    private Date bDay;
    @OneToMany(mappedBy = "auto")
    private List<Insurance> insuranceList;

    public Auto(String fName, String sName,
                String carVin, String carNumber, String ptsSeries, String ptsNumber, int power, Date bDay) {
        this.fName = fName;
        this.sName = sName;
        this.carVin = carVin;
        this.carNumber = carNumber;
        this.ptsSeries = ptsSeries;
        this.ptsNumber = ptsNumber;
        this.power = power;
        this.bDay = bDay;
    }

    public Auto() {

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

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPtsSeries() {
        return ptsSeries;
    }

    public void setPtsSeries(String ptsSeries) {
        this.ptsSeries = ptsSeries;
    }

    public String getPtsNumber() {
        return ptsNumber;
    }

    public void setPtsNumber(String ptsNumber) {
        this.ptsNumber = ptsNumber;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }
}
