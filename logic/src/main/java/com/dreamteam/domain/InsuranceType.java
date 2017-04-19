package com.dreamteam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Insurance type
 */
@Entity
public class InsuranceType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Insurance> insuranceList;

    public InsuranceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public InsuranceType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
