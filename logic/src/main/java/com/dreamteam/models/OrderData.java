package com.dreamteam.models;


import com.dreamteam.domain.Insurer;

import java.io.Serializable;
import java.util.Date;

/**
 * Данные по страховке
 */
public class OrderData implements Serializable{
    private String fname,sname,mname;
    private String fn,sn,mn;
    private Date bDay;
    private Insurer insurer;
    private String carfName, carsName;
    private String carVin;
    private String carNumber;
    private String ptsSeries;
    private String ptsNumber;
    private int power;
    private Date carbDay;
    private int typeInsurance;
    private String person1Name;
    private String getPerson1Prava;
    private String person2Name;
    private String getPerson2Prava;
    private String person3Name;
    private String getPerson3Prava;
    private Date beginDate;
    private Date endDate;
    private boolean flagg;

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public OrderData(String fname, String sname, String mname) {
        this.fname = fname;
        this.sname = sname;
        this.mname = mname;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public void setCarbDay(Date carbDay) {
        this.carbDay = carbDay;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isFlagg() {
        return flagg;
    }

    public void setFlagg(boolean flagg) {
        this.flagg = flagg;
    }

    public OrderData() {
    }

    public OrderData(String fname, String sname, String mname, String carfName, String carsName,
                     String carVin, String carNumber, String ptsSeries, String ptsNumber, int power, int typeInsurance,
                     String person1Name, String getPerson1Prava, String person2Name, String getPerson2Prava,
                     String person3Name, String getPerson3Prava) {
        this.fname = fname;
        this.sname = sname;
        this.mname = mname;
        this.insurer = insurer;
        this.carfName = carfName;
        this.carsName = carsName;
        this.carVin = carVin;
        this.carNumber = carNumber;
        this.ptsSeries = ptsSeries;
        this.ptsNumber = ptsNumber;
        this.power = power;
        this.typeInsurance = typeInsurance;
        this.person1Name = person1Name;
        this.getPerson1Prava = getPerson1Prava;
        this.person2Name = person2Name;
        this.getPerson2Prava = getPerson2Prava;
        this.person3Name = person3Name;
        this.getPerson3Prava = getPerson3Prava;
    }

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

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(int y,int m,int d) {
        this.bDay = new Date(y,m,d);
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public String getCarfName() {
        return carfName;
    }

    public void setCarfName(String carfName) {
        this.carfName = carfName;
    }

    public String getCarsName() {
        return carsName;
    }

    public void setCarsName(String carsName) {
        this.carsName = carsName;
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

    public Date getCarbDay() {
        return carbDay;
    }

    public void setCarbDay(int y,int m,int d) {
        this.carbDay = new Date(y,m,d);
    }

    public int getTypeInsurance() {
        return typeInsurance;
    }

    public void setTypeInsurance(int typeInsurance) {
        this.typeInsurance = typeInsurance;
    }

    public String getPerson1Name() {
        return person1Name;
    }

    public void setPerson1Name(String person1Name) {
        this.person1Name = person1Name;
    }

    public String getGetPerson1Prava() {
        return getPerson1Prava;
    }

    public void setGetPerson1Prava(String getPerson1Prava) {
        this.getPerson1Prava = getPerson1Prava;
    }

    public String getPerson2Name() {
        return person2Name;
    }

    public void setPerson2Name(String person2Name) {
        this.person2Name = person2Name;
    }

    public String getGetPerson2Prava() {
        return getPerson2Prava;
    }

    public void setGetPerson2Prava(String getPerson2Prava) {
        this.getPerson2Prava = getPerson2Prava;
    }

    public String getPerson3Name() {
        return person3Name;
    }

    public void setPerson3Name(String person3Name) {
        this.person3Name = person3Name;
    }

    public String getGetPerson3Prava() {
        return getPerson3Prava;
    }

    public void setGetPerson3Prava(String getPerson3Prava) {
        this.getPerson3Prava = getPerson3Prava;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(int y,int m,int d) {
        this.beginDate = new Date(y,m,d);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(int y,int m,int d) {
        this.endDate = new Date(y,m,d);
    }
}
