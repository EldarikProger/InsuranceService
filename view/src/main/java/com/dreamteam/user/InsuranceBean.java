package com.dreamteam.user;

import com.dreamteam.auth.AuthorizeBean;
import com.dreamteam.controllers.InsuranceManager;
import com.dreamteam.models.OrderData;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;


@Named
@SessionScoped
public class InsuranceBean implements Serializable {

    @Inject
    private AuthorizeBean authorizeBean;
    @EJB
    private InsuranceManager insuranceManager;
    private OrderData data;

    private String fname, sname, mname;
    private String fn, sn, mn;
    private int bDayy, bDaym, bDayd;
    private String carfName, carsName;
    private String carVin;
    private String carNumber;
    private String ptsSeries;
    private String ptsNumber;
    private int power;
    private int carbDay;
    private int typeInsurance;
    private String person1Name;
    private String getPerson1Prava;
    private String person2Name;
    private String getPerson2Prava;
    private String person3Name;
    private String getPerson3Prava;
    private int beginDatey, beginDatem, beginDated;
    private int endDatey, endDatem, endDated;
    private boolean flag;
    private String type;


    public void doNewInsurance() {
        int ttt = 1;
        if (Objects.equals(type, "1"))
            ttt = 1;
        if (Objects.equals(type, "2"))
            ttt = 2;
        person1Name = fname + " " + sname + " " + mname;
        OrderData orderData = new OrderData(fname, sname, mname, carfName, carsName, carVin, carNumber, ptsSeries, ptsNumber, power, ttt,
                person1Name, getPerson1Prava, person2Name, getPerson2Prava, person3Name, getPerson3Prava);
        orderData.setFn(fn);
        orderData.setMn(mn);
        orderData.setSn(sn);
        insuranceManager.addOrder(orderData);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/user/finalize.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doOldInsurance() {
        data = new OrderData(fname, sname, mname);
        data = insuranceManager.getUnformedInsurance(data);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/user/newinsurance.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public OrderData getData() {
        return data;
    }

    public void setData(OrderData data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getbDayy() {
        return bDayy;
    }

    public void setbDayy(int bDayy) {
        this.bDayy = bDayy;
    }

    public int getbDaym() {
        return bDaym;
    }

    public void setbDaym(int bDaym) {
        this.bDaym = bDaym;
    }

    public int getbDayd() {
        return bDayd;
    }

    public void setbDayd(int bDayd) {
        this.bDayd = bDayd;
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

    public int getCarbDay() {
        return carbDay;
    }

    public void setCarbDay(int carbDay) {
        this.carbDay = carbDay;
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

    public int getBeginDatey() {
        return beginDatey;
    }

    public void setBeginDatey(int beginDatey) {
        this.beginDatey = beginDatey;
    }

    public int getBeginDatem() {
        return beginDatem;
    }

    public void setBeginDatem(int beginDatem) {
        this.beginDatem = beginDatem;
    }

    public int getBeginDated() {
        return beginDated;
    }

    public void setBeginDated(int beginDated) {
        this.beginDated = beginDated;
    }

    public int getEndDatey() {
        return endDatey;
    }

    public void setEndDatey(int endDatey) {
        this.endDatey = endDatey;
    }

    public int getEndDatem() {
        return endDatem;
    }

    public void setEndDatem(int endDatem) {
        this.endDatem = endDatem;
    }

    public int getEndDated() {
        return endDated;
    }

    public void setEndDated(int endDated) {
        this.endDated = endDated;
    }
}
