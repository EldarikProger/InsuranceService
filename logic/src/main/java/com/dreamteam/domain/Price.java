package com.dreamteam.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Price by all insurance
 */
@Entity
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double price;
    private double priceRatio;
    private double money;
    @OneToOne(mappedBy = "price")
    private Insurance insurance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceRatio() {
        return priceRatio;
    }

    public void setPriceRatio(double priceRatio) {
        this.priceRatio = priceRatio;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Price() {
    }

    public Price(double price, double priceRatio, double money) {
        this.price = price;
        this.priceRatio = priceRatio;
        this.money = money;
    }
}
