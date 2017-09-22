package com.example.cesi.seating_plan.model;

public class Materiel {
    private long id;

    private String libelle;

    private long id_type;

    private Type type_materiel;



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

    public long getId_type() {
        return id_type;
    }

    public void setId_type(long id_type) {
        this.id_type = id_type;
    }

    public Type getType_materiel() {
        return type_materiel;
    }

    public void setType_materiel(Type type_materiel) {
        this.type_materiel = type_materiel;
    }



    public Materiel() {

    }



    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", libelle='" + libelle +
                ", id_type=" + id_type +
                '}';
    }
}
