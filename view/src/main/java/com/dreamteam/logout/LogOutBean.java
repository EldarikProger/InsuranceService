package com.dreamteam.logout;

import com.dreamteam.controllers.InsuranceManager;
import com.dreamteam.models.InsurerData;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

@Named
@SessionScoped
public class LogOutBean implements Serializable {

    private String fname;
    private String mname;
    private String sname;
    private String login;
    private String password1;
    private String password2;

    @EJB
    private LogOutManager logOutManager;

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

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void doLogOut() {
        if (Objects.equals(password1, password2)) {
            InsurerData data = new InsurerData(fname, sname, mname, login, password1);
            boolean check = logOutManager.addInsurer(data);
            if (check) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/view/logoutinfo.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
