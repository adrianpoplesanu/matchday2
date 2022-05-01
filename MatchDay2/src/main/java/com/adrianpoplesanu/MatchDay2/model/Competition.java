package com.adrianpoplesanu.MatchDay2.model;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition {
    @Id
    @Column(name = "competitionsid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "externalid")
    private String externalId;

    @Column(name = "code")
    private String code;

    @Column(name = "active")
    private String active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
