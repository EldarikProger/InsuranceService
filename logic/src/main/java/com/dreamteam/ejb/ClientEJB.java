package com.dreamteam.ejb;

import com.dreamteam.domain.Client;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
@LocalBean
public class ClientEJB {
    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    public List getAllClients(){
        Query query = entityManager.createQuery("select en from Client en");
        return query.getResultList();
    }

    public void createAdmin(Client client){
        entityManager.persist(client);
    }

    public List readClient(String fname, String sname, String mname){
        Query query = entityManager.createQuery("select client from Client client where client.fName = :fname and " +
                "client.sName = :sname and client.mName = :mname");
        query.setParameter("fname", StringUtils.lowerCase(fname));
        query.setParameter("sname", StringUtils.lowerCase(sname));
        query.setParameter("mname", StringUtils.lowerCase(mname));
        return query.getResultList();
    }


}
