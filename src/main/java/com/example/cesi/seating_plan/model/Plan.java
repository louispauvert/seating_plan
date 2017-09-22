package com.example.cesi.seating_plan.model;

import java.util.List;

public class Plan {
    private long id;

    private String libelle;

    private int version;

    private List<Bureau> bureauList;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() { return version; }

    public List<Bureau> getBureauList() {
        return bureauList;
    }

    public void setBureauList(List<Bureau> bureauList) {
        this.bureauList = bureauList;
    }



    public Plan() {

    }



    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", version=" + version +
                ", bureauList=" + bureauList +
                '}';
    }
}
