package com.dreamteam.user;


import com.dreamteam.auth.AuthorizeBean;
import com.dreamteam.controllers.InsurerDataManager;
import com.dreamteam.models.UserData;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserDataBean implements Serializable{

    private UserData userData;
    @EJB
    private InsurerDataManager dataManager;
    @Inject
    private AuthorizeBean authorizeBean;

    public AuthorizeBean getAuthorizeBean() {
        return authorizeBean;
    }

    public void setAuthorizeBean(AuthorizeBean authorizeBean) {
        this.authorizeBean = authorizeBean;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void updateData(){
        dataManager.getInsurerData(authorizeBean.getInsurer());
    }
}
