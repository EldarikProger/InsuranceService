package com.dreamteam.logout;

import com.dreamteam.domain.Insurer;
import com.dreamteam.models.InsurerData;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class LogOutManager {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    /**
     * Регистрация страховщиков
     * @param data
     * @return
     */
    public boolean addInsurer(InsurerData data){
        Insurer insurer = new Insurer(data.getFname(),data.getSname(),data.getMname(),data.getLogin(),data.getPassword());
        try {
            entityManager.persist(insurer);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
