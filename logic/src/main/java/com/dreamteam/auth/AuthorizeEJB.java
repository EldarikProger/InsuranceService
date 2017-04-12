package com.dreamteam.auth;


import com.dreamteam.domain.Admin;
import com.dreamteam.domain.Insurer;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@LocalBean
public class AuthorizeEJB {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    public Insurer authorizeInsurer(String login, String password) {
/*        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Insurer> cq = cb.createQuery(Insurer.class);
        Root<Insurer> insurer = cq.from(Insurer.class);
        cq.select(insurer);
        cq.where();*/


        Query query = entityManager.createQuery("select a from Insurer a where a.login = :log and a.password = :pas");
        query.setParameter("log", StringUtils.lowerCase(login));
        query.setParameter("pas", StringUtils.lowerCase(password));
        Insurer insurer;
        try {
            insurer = (Insurer) query.getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return insurer;
    }

    public Admin authorizeAdmin(String login, String password) {
        Query query = entityManager.createQuery("select a from Admin a where a.login = :log and a.password = :pas");
        query.setParameter("log", StringUtils.lowerCase(login));
        query.setParameter("pas", StringUtils.lowerCase(password));
        Admin admin;
        try {
            admin = (Admin) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return  admin;
    }
}
