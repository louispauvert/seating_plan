package com.example.cesi.seating_plan.model;

public class Type {
    private long id;

    private String libelle;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return libelle; }



    public Type() {

    }



    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
