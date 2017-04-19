package com.dreamteam.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Insurance
 */
@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne()
    private InsuranceType type;
    @ManyToOne
    private Insurer insurer;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Auto auto;
    private Date beginDate;
    private Date endDate;
    private String person1Name;
    private String getPerson1Prava;
    private String person2Name;
    private String getPerson2Prava;
    private String person3Name;
    private String getPerson3Prava;
    private boolean flagg;
    @OneToOne
    private Price price;

    public boolean isFlagg() {
        return flagg;
    }

    public void setFlagg(boolean flagg) {
        this.flagg = flagg;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InsuranceType getType() {
        return type;
    }

    public void setType(InsuranceType type) {
        this.type = type;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerson1Name() {
        return person1Name;
    }

    public void setPerson1Name(String person1Name) {
        this.person1Name = person1Name;
    }

    public String getGetPerson1Prava() {
        return getPerson1Prava;
    }

    public void setGetPerson1Prava(String getPerson1Prava) {
        this.getPerson1Prava = getPerson1Prava;
    }

    public String getPerson2Name() {
        return person2Name;
    }

    public void setPerson2Name(String person2Name) {
        this.person2Name = person2Name;
    }

    public String getGetPerson2Prava() {
        return getPerson2Prava;
    }

    public void setGetPerson2Prava(String getPerson2Prava) {
        this.getPerson2Prava = getPerson2Prava;
    }

    public String getPerson3Name() {
        return person3Name;
    }

    public void setPerson3Name(String person3Name) {
        this.person3Name = person3Name;
    }

    public String getGetPerson3Prava() {
        return getPerson3Prava;
    }

    public void setGetPerson3Prava(String getPerson3Prava) {
        this.getPerson3Prava = getPerson3Prava;
    }
}
