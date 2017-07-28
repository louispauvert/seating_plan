package com.example.cesi.seating_plan.model;

import java.util.Date;

public class Collaborateur {
    private long id;

    private String nom;

    private String prenom;

    private Date date_arrive;

    private Date date_depart;

    private String email;

    private String mdp;

    public Collaborateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Collaborateur(long id, String nom, String prenom, Date date_arrive, Date date_depart, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_arrive = date_arrive;
        this.date_depart = date_depart;
        this.email = email;
        this.mdp = mdp;
    }

    public Collaborateur(String nom, String prenom, Date date_arrive, Date date_depart, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_arrive = date_arrive;
        this.date_depart = date_depart;
        this.email = email;
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Collaborateur{" +
                "id=" + String.valueOf(id) +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_arrive=" + date_arrive +
                ", date_depart=" + date_depart +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

    protected Collaborateur(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(Date date_arrive) {
        this.date_arrive = date_arrive;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
