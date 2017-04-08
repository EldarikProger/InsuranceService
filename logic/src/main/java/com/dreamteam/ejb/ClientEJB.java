package com.dreamteam.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class ClientEJB {
    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    public List getAllClients(){
        Query query = entityManager.createQuery("select en from Client en");
        return query.getResultList();
    }
}
