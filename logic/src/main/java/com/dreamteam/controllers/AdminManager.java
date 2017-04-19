package com.dreamteam.controllers;

import com.dreamteam.domain.Insurance;
import com.dreamteam.domain.InsuranceType;
import com.dreamteam.models.OrderData;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class AdminManager {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager entityManager;

    /**
     * Статистика по КАСКО
     * @return
     */
    public List<OrderData> findByKASKO(){
        Query q = entityManager.createQuery("select aa from InsuranceType aa where aa.id = 2");
        InsuranceType type = (InsuranceType) q.getSingleResult();
        Query query = entityManager.createQuery("select a from Insurance a where a.type = :t");
        query.setParameter("t",type);
        List<OrderData> list = new ArrayList<>();
        List<Insurance> l =  (List<Insurance>) query.getResultList();
        if(l.size()==0)
            return list;
        OrderData data;
        for(Insurance insurance : l){
            data = new OrderData();
            data.setInsurer(insurance.getInsurer());
            data.setTypeInsurance(insurance.getType().getId());
            data.setPower(insurance.getAuto().getPower());
            data.setPerson2Name(insurance.getPerson2Name());
            data.setPerson3Name(insurance.getPerson3Name());
            data.setPerson1Name(insurance.getPerson1Name());
            data.setGetPerson1Prava(insurance.getGetPerson1Prava());
            data.setGetPerson2Prava(insurance.getGetPerson2Prava());
            data.setGetPerson3Prava(insurance.getGetPerson3Prava());
            data.setFname(insurance.getClient().getfName());
            data.setCarVin(insurance.getAuto().getCarVin());
            data.setCarsName(insurance.getAuto().getsName());
            data.setCarNumber(insurance.getAuto().getCarNumber());
            data.setCarfName(insurance.getAuto().getfName());
            data.setCarbDay(insurance.getAuto().getbDay().getYear(),insurance.getAuto().getbDay().getMonth(),insurance.getAuto().getbDay().getDay());
            data.setBeginDate(insurance.getBeginDate().getYear(),insurance.getBeginDate().getMonth(),insurance.getBeginDate().getDay());
            data.setbDay(insurance.getClient().getbDay().getYear(),insurance.getClient().getbDay().getMonth(),insurance.getClient().getbDay().getDay());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setEndDate(insurance.getEndDate().getYear(),insurance.getEndDate().getMonth(),insurance.getEndDate().getDay());
            data.setMname(insurance.getClient().getmName());
            data.setSname(insurance.getClient().getsName());
            data.setPtsSeries(insurance.getAuto().getPtsSeries());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setFlagg(insurance.isFlagg());
        }

        return list;
    }

    /**
     * Статистика по ОСАГО
     * @return
     */
    public List<OrderData> findByOSAGO(){
        Query q = entityManager.createQuery("select aa from InsuranceType aa where aa.id = 1");
        InsuranceType type = (InsuranceType) q.getSingleResult();
        Query query = entityManager.createQuery("select a from Insurance a where a.type = :t");
        query.setParameter("t",type);
        List<OrderData> list = new ArrayList<>();
        List<Insurance> l =  (List<Insurance>) query.getResultList();
        if(l.size()==0)
            return list;
        OrderData data;
        for(Insurance insurance : l){
            data = new OrderData();
            data.setInsurer(insurance.getInsurer());
            data.setTypeInsurance(insurance.getType().getId());
            data.setPower(insurance.getAuto().getPower());
            data.setPerson2Name(insurance.getPerson2Name());
            data.setPerson3Name(insurance.getPerson3Name());
            data.setPerson1Name(insurance.getPerson1Name());
            data.setGetPerson1Prava(insurance.getGetPerson1Prava());
            data.setGetPerson2Prava(insurance.getGetPerson2Prava());
            data.setGetPerson3Prava(insurance.getGetPerson3Prava());
            data.setFname(insurance.getClient().getfName());
            data.setCarVin(insurance.getAuto().getCarVin());
            data.setCarsName(insurance.getAuto().getsName());
            data.setCarNumber(insurance.getAuto().getCarNumber());
            data.setCarfName(insurance.getAuto().getfName());
            data.setCarbDay(insurance.getAuto().getbDay().getYear(),insurance.getAuto().getbDay().getMonth(),insurance.getAuto().getbDay().getDay());
            data.setBeginDate(insurance.getBeginDate().getYear(),insurance.getBeginDate().getMonth(),insurance.getBeginDate().getDay());
            data.setbDay(insurance.getClient().getbDay().getYear(),insurance.getClient().getbDay().getMonth(),insurance.getClient().getbDay().getDay());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setEndDate(insurance.getEndDate().getYear(),insurance.getEndDate().getMonth(),insurance.getEndDate().getDay());
            data.setMname(insurance.getClient().getmName());
            data.setSname(insurance.getClient().getsName());
            data.setPtsSeries(insurance.getAuto().getPtsSeries());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setFlagg(insurance.isFlagg());
        }

        return list;
    }

    /**
     * Статистика по Клиентам
     * @param fname
     * @return
     */
    public List<OrderData> findByClient(String fname){
        Query query = entityManager.createQuery("select a from Insurance a where a.client.fName = :fn");
        query.setParameter("fn",fname);
        List<OrderData> list = new ArrayList<>();
        List<Insurance> l =  (List<Insurance>) query.getResultList();
        if(l.size()==0)
            return list;
        OrderData data;
        for(Insurance insurance : l){
            data = new OrderData();
            data.setInsurer(insurance.getInsurer());
            data.setTypeInsurance(insurance.getType().getId());
            data.setPower(insurance.getAuto().getPower());
            data.setPerson2Name(insurance.getPerson2Name());
            data.setPerson3Name(insurance.getPerson3Name());
            data.setPerson1Name(insurance.getPerson1Name());
            data.setGetPerson1Prava(insurance.getGetPerson1Prava());
            data.setGetPerson2Prava(insurance.getGetPerson2Prava());
            data.setGetPerson3Prava(insurance.getGetPerson3Prava());
            data.setFname(insurance.getClient().getfName());
            data.setCarVin(insurance.getAuto().getCarVin());
            data.setCarsName(insurance.getAuto().getsName());
            data.setCarNumber(insurance.getAuto().getCarNumber());
            data.setCarfName(insurance.getAuto().getfName());
            data.setCarbDay(insurance.getAuto().getbDay().getYear(),insurance.getAuto().getbDay().getMonth(),insurance.getAuto().getbDay().getDay());
            data.setBeginDate(insurance.getBeginDate().getYear(),insurance.getBeginDate().getMonth(),insurance.getBeginDate().getDay());
            data.setbDay(insurance.getClient().getbDay().getYear(),insurance.getClient().getbDay().getMonth(),insurance.getClient().getbDay().getDay());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setEndDate(insurance.getEndDate().getYear(),insurance.getEndDate().getMonth(),insurance.getEndDate().getDay());
            data.setMname(insurance.getClient().getmName());
            data.setSname(insurance.getClient().getsName());
            data.setPtsSeries(insurance.getAuto().getPtsSeries());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setFlagg(insurance.isFlagg());
        }

        return list;
    }

    /**
     * Статистика по Страховщикам
     * @param fname
     * @return
     */
    public List<OrderData> findByInsurer(String fname){
        Query query = entityManager.createQuery("select a from Insurance a where a.insurer.fName = :fn");
        query.setParameter("fn",fname);
        List<OrderData> list = new ArrayList<>();
        List<Insurance> l =  (List<Insurance>) query.getResultList();
        if(l.size()==0)
            return list;
        OrderData data;
        for(Insurance insurance : l){
            data = new OrderData();
            data.setInsurer(insurance.getInsurer());
            data.setTypeInsurance(insurance.getType().getId());
            data.setPower(insurance.getAuto().getPower());
            data.setPerson2Name(insurance.getPerson2Name());
            data.setPerson3Name(insurance.getPerson3Name());
            data.setPerson1Name(insurance.getPerson1Name());
            data.setGetPerson1Prava(insurance.getGetPerson1Prava());
            data.setGetPerson2Prava(insurance.getGetPerson2Prava());
            data.setGetPerson3Prava(insurance.getGetPerson3Prava());
            data.setFname(insurance.getClient().getfName());
            data.setCarVin(insurance.getAuto().getCarVin());
            data.setCarsName(insurance.getAuto().getsName());
            data.setCarNumber(insurance.getAuto().getCarNumber());
            data.setCarfName(insurance.getAuto().getfName());
            data.setCarbDay(insurance.getAuto().getbDay().getYear(),insurance.getAuto().getbDay().getMonth(),insurance.getAuto().getbDay().getDay());
            data.setBeginDate(insurance.getBeginDate().getYear(),insurance.getBeginDate().getMonth(),insurance.getBeginDate().getDay());
            data.setbDay(insurance.getClient().getbDay().getYear(),insurance.getClient().getbDay().getMonth(),insurance.getClient().getbDay().getDay());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setEndDate(insurance.getEndDate().getYear(),insurance.getEndDate().getMonth(),insurance.getEndDate().getDay());
            data.setMname(insurance.getClient().getmName());
            data.setSname(insurance.getClient().getsName());
            data.setPtsSeries(insurance.getAuto().getPtsSeries());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setFlagg(insurance.isFlagg());
        }

        return list;
    }

    /**
     * Вся статистика
     * @return
     */
    public List<OrderData> findAll(){
        Query query = entityManager.createQuery("select a from Insurance a");
        List<OrderData> list = new ArrayList<>();
        List<Insurance> l =  (List<Insurance>) query.getResultList();
        if(l.size()==0)
            return list;
        OrderData data;
        for(Insurance insurance : l){
            data = new OrderData();
            data.setInsurer(insurance.getInsurer());
            data.setTypeInsurance(insurance.getType().getId());
            data.setPower(insurance.getAuto().getPower());
            data.setPerson2Name(insurance.getPerson2Name());
            data.setPerson3Name(insurance.getPerson3Name());
            data.setPerson1Name(insurance.getPerson1Name());
            data.setGetPerson1Prava(insurance.getGetPerson1Prava());
            data.setGetPerson2Prava(insurance.getGetPerson2Prava());
            data.setGetPerson3Prava(insurance.getGetPerson3Prava());
            data.setFname(insurance.getClient().getfName());
            data.setCarVin(insurance.getAuto().getCarVin());
            data.setCarsName(insurance.getAuto().getsName());
            data.setCarNumber(insurance.getAuto().getCarNumber());
            data.setCarfName(insurance.getAuto().getfName());
            data.setCarbDay(insurance.getAuto().getbDay().getYear(),insurance.getAuto().getbDay().getMonth(),insurance.getAuto().getbDay().getDay());
            data.setBeginDate(insurance.getBeginDate().getYear(),insurance.getBeginDate().getMonth(),insurance.getBeginDate().getDay());
            data.setbDay(insurance.getClient().getbDay().getYear(),insurance.getClient().getbDay().getMonth(),insurance.getClient().getbDay().getDay());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setEndDate(insurance.getEndDate().getYear(),insurance.getEndDate().getMonth(),insurance.getEndDate().getDay());
            data.setMname(insurance.getClient().getmName());
            data.setSname(insurance.getClient().getsName());
            data.setPtsSeries(insurance.getAuto().getPtsSeries());
            data.setPtsNumber(insurance.getAuto().getPtsNumber());
            data.setFlagg(insurance.isFlagg());
        }

        return list;
    }
}
