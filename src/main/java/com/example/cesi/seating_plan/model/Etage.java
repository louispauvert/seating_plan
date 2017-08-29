package com.example.cesi.seating_plan.model;

public class Etage {
    private long id;

    private String libelle;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Etage{" +
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

    public Etage(String libelle) {

        this.libelle = libelle;
    }

    public Etage(long id, String libelle) {

        this.id = id;
        this.libelle = libelle;
    }
}
