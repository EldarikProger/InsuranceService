package com.dreamteam.auth;

import com.dreamteam.controllers.InsurerDataManager;
import com.dreamteam.domain.Admin;
import com.dreamteam.domain.Insurer;
import com.dreamteam.models.UserData;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class AuthorizeBean implements Serializable{

    private String login;
    private String password;
    private boolean auth;
    private Insurer insurer;
    private Admin admin;

    private UserData userData;
    @EJB
    private InsurerDataManager dataManager;

    public AuthorizeBean() {
    }

    @EJB
    private AuthorizeManager authorizeManager;

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

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void updateData(){
        userData = dataManager.getInsurerData(insurer);
    }

    public void exit(){
        auth = false;
        admin = null;
        insurer = null;
        login = null;
        password = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doAuthorize(){
        if(StringUtils.isEmpty(login) || StringUtils.isEmpty(password)){
            return;
        }
        insurer = authorizeManager.authorizeInsurer(login,password);
        if(insurer != null){
            auth = true;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/view/user/profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        admin = authorizeManager.authorizeAdmin(login,password);
        if (admin != null){
            auth = true;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/view/admin/profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
