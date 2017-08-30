package com.example.cesi.seating_plan.model;

public class Batiment {
    private long id;

    private String libelle;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;

    }


    public Batiment(String libelle) {

        this.libelle = libelle;
    }

    public Batiment(long id, String libelle) {

        this.id = id;
        this.libelle = libelle;
    }
}
