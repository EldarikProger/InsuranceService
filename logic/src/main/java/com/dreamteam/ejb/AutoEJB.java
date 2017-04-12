package com.dreamteam.ejb;


import com.dreamteam.domain.Auto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AutoEJB {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    public List getAllAuto(){
        Query query = entityManager.createQuery("select en from Auto en");
        return query.getResultList();
    }

    public void createAdmin(Auto auto){
        entityManager.persist(auto);
    }
}
