package com.dreamteam.ejb;

import com.dreamteam.domain.Admin;
import com.dreamteam.model.AdminData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AdminEJB {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;


    public List getAllAdmins(){
        Query query = entityManager.createQuery("select a from Admin a");
        return query.getResultList();
    }

    public void createAdmin(Admin admin){
        entityManager.persist(admin);
    }


}
