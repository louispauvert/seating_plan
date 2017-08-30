package com.example.cesi.seating_plan.model;

public class Materiel {
    private long id;

    private String libelle;

    private int nombre;

    private long id_type;


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

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public long getId_type() {
        return id_type;
    }

    public void setId_type(long id_type) {
        this.id_type = id_type;
    }


    public Materiel() {

    }

    public Materiel(String libelle, int nombre, long id_type) {
        this.libelle = libelle;
        this.nombre = nombre;
        this.id_type = id_type;
    }

    public Materiel(long id, String libelle, int nombre, long id_type) {

        this.id = id;
        this.libelle = libelle;
        this.nombre = nombre;
        this.id_type = id_type;
    }


    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", nombre=" + nombre +
                ", id_type=" + id_type +
                '}';
    }
}
