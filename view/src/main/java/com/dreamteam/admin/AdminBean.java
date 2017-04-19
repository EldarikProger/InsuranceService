package com.dreamteam.admin;

import com.dreamteam.auth.AuthorizeBean;
import com.dreamteam.controllers.AdminManager;
import com.dreamteam.models.OrderData;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AdminBean implements Serializable {

    @Inject
    private AuthorizeBean authorizeBean;

    @EJB
    private AdminManager adminManager;

    private List<OrderData> list;

    private int sizeList;

    public int getSizeList() {
        return sizeList;
    }

    public void setSizeList(int sizeList) {
        this.sizeList = sizeList;
    }

    public List<OrderData> getList() {
        return list;
    }

    public void setList(List<OrderData> list) {
        this.list = list;
    }

    private String value, str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setAuthorizeBean(AuthorizeBean authorizeBean) {
        this.authorizeBean = authorizeBean;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AuthorizeBean getAuthorizeBean() {
        return authorizeBean;
    }

    public void getStatistics() {
        switch (value) {
            case "1":
                list = adminManager.findByInsurer(str);
                break;
            case "2":
                list = adminManager.findByClient(str);
                break;
            case "3":
                list = adminManager.findAll();
                break;
            case "4":
                list = adminManager.findByKASKO();
                break;
            case "5":
                list = adminManager.findByOSAGO();
                break;
            default:
                return;
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/statistics.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
