package com.example.cesi.seating_plan.model;

public class Batiment {
    private long id;

    private String libelle;



    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }



    public Batiment() {
    }



    @Override
    public String toString() {
        return "Batiment{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}