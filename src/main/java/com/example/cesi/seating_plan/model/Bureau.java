package com.example.cesi.seating_plan.model;


import java.util.List;

public class Bureau {
    private long id;

    private long id_collab;

    private List<Materiel> listMateriel;

    private int num_interne;

    private int num_externe;

    private int abs;

    private int ord;

    private boolean sens;

    private Collaborateur collaborateur;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_collab() {
        return id_collab;
    }

    public void setId_collab(long id_collab) {
        this.id_collab = id_collab;
    }

    public List<Materiel> getListMateriel() {
        return listMateriel;
    }

    public void setListMateriel(List<Materiel> listMateriel) {
        this.listMateriel = listMateriel;
    }

    public int getNum_interne() {
        return num_interne;
    }

    public void setNum_interne(int num_interne) {
        this.num_interne = num_interne;
    }

    public int getNum_externe() {
        return num_externe;
    }

    public void setNum_externe(int num_externe) {
        this.num_externe = num_externe;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public boolean isSens() {
        return sens;
    }

    public void setSens(boolean sens) {
        this.sens = sens;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }



    public Bureau(long id, long id_collab, List<Materiel> listMateriel, int num_interne, int num_externe, int abs, int ord, boolean sens, Collaborateur collaborateur) {
        this.id = id;
        this.id_collab = id_collab;
        this.listMateriel = listMateriel;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
        this.abs = abs;
        this.ord = ord;
        this.sens = sens;
        this.collaborateur = collaborateur;
    }

    public Bureau() {
    }

    public Bureau(long id, int num_interne, int num_externe, Collaborateur collaborateur) {
        this.id = id;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
        this.collaborateur = collaborateur;
    }

    public Bureau(int num_interne, int num_externe, Collaborateur collaborateur) {
        this.num_interne = num_interne;
        this.num_externe = num_externe;
        this.collaborateur = collaborateur;
    }


    @Override
    public String toString() {
        return "Bureau{" +
                "id=" + id +
                ", id_collab=" + id_collab +
                ", listMateriel=" + listMateriel +
                ", num_interne=" + num_interne +
                ", num_externe=" + num_externe +
                ", abs=" + abs +
                ", ord=" + ord +
                ", sens=" + sens +
                '}';
    }
}
