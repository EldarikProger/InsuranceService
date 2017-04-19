package com.dreamteam.controllers;

import com.dreamteam.domain.*;
import com.dreamteam.models.OrderData;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class InsuranceManager {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    /**
     * Добавление страховок
     * @param data
     */
    public void addOrder(OrderData data){
        Query query = entityManager.createQuery("select client from Client client where client.fName = :fname and " +
                "client.sName = :sname and client.mName = :mname");
        query.setParameter("fname", StringUtils.lowerCase(data.getFname()));
        query.setParameter("sname", StringUtils.lowerCase(data.getSname()));
        query.setParameter("mname", StringUtils.lowerCase(data.getMname()));
        if(query.getResultList().size() == 0) {
            Client client = new Client(data.getFname(), data.getSname(), data.getMname(), data.getbDay());
            entityManager.persist(client);
        }
        Client client = (Client) query.getSingleResult();
        Query query1 = entityManager.createQuery("select a from InsuranceType a where a.id = :aaa");
        query1.setParameter("aaa", data.getTypeInsurance());
        InsuranceType type = (InsuranceType) query1.getSingleResult();
        Query query2 = entityManager.createQuery("select a from Insurer a where a.fName = :f and a.sName = :s");
        query2.setParameter("f", data.getFn());
        query2.setParameter("s", data.getSn());
        Insurer insurer = (Insurer) query2.getSingleResult();
        Query query3 = entityManager.createQuery("select a from Auto a where a.carVin = :vin");
        query3.setParameter("vin", data.getCarVin());
        if(query3.getResultList().size()==0){
            Auto auto = new Auto(data.getCarfName(),data.getCarsName(),data.getCarVin(),data.getCarNumber(),data.getPtsSeries(),
                    data.getPtsNumber(),data.getPower(),data.getCarbDay());
            entityManager.persist(auto);
        }
        Auto auto = (Auto) query3.getSingleResult();
        Insurance insurance = new Insurance();
        insurance.setAuto(auto);
        insurance.setBeginDate(data.getBeginDate());
        insurance.setClient(client);
        insurance.setEndDate(data.getEndDate());
        insurance.setFlagg(data.isFlagg());
        insurance.setGetPerson1Prava(data.getGetPerson1Prava());
        insurance.setGetPerson2Prava(data.getGetPerson2Prava());
        insurance.setGetPerson3Prava(data.getGetPerson3Prava());
        insurance.setPerson1Name(data.getPerson1Name());
        insurance.setPerson2Name(data.getPerson2Name());
        insurance.setPerson3Name(data.getPerson3Name());
        insurance.setInsurer(insurer);
        insurance.setType(type);

        Query query4 = entityManager.createQuery("select a from Insurance a where a.client = :a");
        query4.setParameter("a", client);
        int q = query4.getResultList().size();
        int k1=30;
        double k=1;
        if(q>=7)
            k = 0.5;
        if(q>=3 && q<7)
            k = 0.8;
        Date date = new Date();
        int y = date.getYear() - data.getCarbDay().getYear();
        if(y<=5)
            k1=10;
        if(y>5 && y<=10)
            k1 = 20;
        double pr = data.getPower() * k + k1 * 100;
        double money = pr + (1-k)*1000;
        Price price = new Price(pr,k,money);

        insurance.setPrice(price);
        entityManager.persist(insurance);
        price.setInsurance(insurance);
        entityManager.persist(price);
    }

    /**
     * Получение не дооформленных страховок
     * @param data
     * @return
     */
    public OrderData getUnformedInsurance(OrderData data){
        Query query = entityManager.createQuery("select ins from Insurance ins where ins.client.fName = :fname and " +
                "ins.client.sName = :sname and ins.client.mName = :mname and ins.flagg = false ");
        query.setParameter("fname", StringUtils.lowerCase(data.getFname()));
        query.setParameter("sname", StringUtils.lowerCase(data.getSname()));
        query.setParameter("mname", StringUtils.lowerCase(data.getMname()));
        Insurance insurance = (Insurance) query.getSingleResult();
        if(insurance == null)
            return new OrderData();
        OrderData orderData = new OrderData();
        orderData.setFlagg(insurance.isFlagg());
        orderData.setPtsNumber(insurance.getAuto().getPtsNumber());
        orderData.setPtsSeries(insurance.getAuto().getPtsSeries());
        orderData.setMname(insurance.getClient().getmName());
        orderData.setSname(insurance.getClient().getsName());
        orderData.setFname(insurance.getClient().getfName());
        orderData.setCarfName(insurance.getAuto().getfName());
        orderData.setCarsName(insurance.getAuto().getsName());
        orderData.setPower(insurance.getAuto().getPower());
        return orderData;
    }

}
