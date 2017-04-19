package com.dreamteam.auth;


import com.dreamteam.domain.Admin;
import com.dreamteam.domain.Insurer;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class AuthorizeManager {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    /**
     * Авторизация Страховщиков
     * @param login
     * @param password
     * @return
     */
    public Insurer authorizeInsurer(String login, String password) {
        Query query = entityManager.createQuery("select a from Insurer a where a.login = :log and a.password = :pas");
        query.setParameter("log", login);
        query.setParameter("pas", password);
        Insurer insurer;
        try {
            insurer = (Insurer) query.getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return insurer;
    }

    /**
     * Авторизация Админов
     * @param login
     * @param password
     * @return
     */
    public Admin authorizeAdmin(String login, String password) {
        Query query = entityManager.createQuery("select a from Admin a where a.login = :log and a.password = :pas");
        query.setParameter("log",login);
        query.setParameter("pas", password);
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
