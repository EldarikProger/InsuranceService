package com.dreamteam.auth;

import com.dreamteam.domain.Admin;
import com.dreamteam.domain.Insurer;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class AuthorizeBean implements Serializable{

    private String login;
    private String password;
    private boolean auth;
    private Insurer insurer;
    private Admin admin;

    @EJB
    private AuthorizeEJB authorizeManager;

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

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void doAuthorize(){
        if(StringUtils.isEmpty(login) || StringUtils.isEmpty(password)){
            return;
        }
        insurer = authorizeManager.authorizeInsurer(login,password);
        if(insurer != null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/view/user/profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        admin = authorizeManager.authorizeAdmin(login,password);
        if (admin != null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/view/user/profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
