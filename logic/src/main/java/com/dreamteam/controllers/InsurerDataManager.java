package com.dreamteam.controllers;


import com.dreamteam.domain.Insurance;
import com.dreamteam.domain.Insurer;
import com.dreamteam.models.UserData;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class InsurerDataManager {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    /**
     * Получение данных о пользователе(страховщике)
     * @param insurer
     * @return
     */
    public UserData getInsurerData(Insurer insurer) {
        Query query = entityManager.createQuery("select a from Insurance a where a.insurer = :ins");
        query.setParameter("ins", insurer);
        List<Insurance> list;
        UserData userData;
        try {
            list = (List<Insurance>) query.getResultList();
            if(list.size()==0)
                return null;
            userData = new UserData();
            userData.setCount(list.size());
            int k = 0;
            for (Insurance insurance : list){
                if(insurance.isFlagg())
                    k++;
            }
            userData.setCountIssued(k);
            userData.setCountUnIssued(list.size()-k);
            userData.setFname(insurer.getfName());
            userData.setSname(insurer.getsName());
            userData.setMname(insurer.getmName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userData;
    }
}
