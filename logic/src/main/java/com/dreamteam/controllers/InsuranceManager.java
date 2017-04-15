package com.dreamteam.controllers;

import com.dreamteam.domain.Client;
import com.dreamteam.models.OrderData;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InsuranceManager {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    public void addOrder(OrderData data){
        Query query = entityManager.createQuery("select client from Client client where client.fName = :fname and " +
                "client.sName = :sname and client.mName = :mname");
        query.setParameter("fname", StringUtils.lowerCase(data.getFname()));
        query.setParameter("sname", StringUtils.lowerCase(data.getSname()));
        query.setParameter("mname", StringUtils.lowerCase(data.getMname()));
        if(query.getResultList().size() == 0){
            Client client = new Client(data.getFname(),data.getSname(),data.getMname(),data.getbDay());
            entityManager.persist(client);
            query.executeUpdate();
        }
        Client client = (Client) query.getResultList().get(0);


    }

}
