package com.dreamteam.admin;

import com.dreamteam.auth.AuthorizeBean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AdminBean implements Serializable {

    @Inject
    private AuthorizeBean authorizeBean;

    private String value;

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
}
