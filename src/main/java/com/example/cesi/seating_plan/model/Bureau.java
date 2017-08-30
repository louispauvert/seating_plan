package com.example.cesi.seating_plan.model;

import java.awt.*;

public class Bureau {
    private long id;

    private long id_collab;

    private List listMateriel;

    private int num_interne;

    private int num_externe;


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

    public List getListMateriel() {
        return listMateriel;
    }

    public void setListMateriel(List listMateriel) {
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


    public Bureau() {

    }

    public Bureau(long id, long id_collab, int num_interne, int num_externe) {
        this.id = id;
        this.id_collab = id_collab;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
    }

    public Bureau(List listMateriel, int num_interne, int num_externe) {
        this.listMateriel = listMateriel;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
    }

    public Bureau(long id, long id_collab, List listMateriel, int num_interne, int num_externe) {
        this.id = id;
        this.id_collab = id_collab;
        this.listMateriel = listMateriel;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
    }

    public Bureau(long id_collab, List listMateriel, int num_interne, int num_externe) {

        this.id_collab = id_collab;
        this.listMateriel = listMateriel;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
    }

    public Bureau(List listMateriel) {
        this.listMateriel = listMateriel;
    }


    @Override
    public String toString() {
        return "Bureau{" +
                "id=" + id +
                ", id_collab=" + id_collab +
                ", listMateriel=" + listMateriel +
                ", num_interne=" + num_interne +
                ", num_externe=" + num_externe +
                '}';
    }
}
