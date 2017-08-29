package com.example.cesi.seating_plan.model;

public class Plan {
    private long id;

    private String libelle;

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", version=" + version +
                '}';
    }

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

    public Plan(long id, String libelle, int version) {
        this.id = id;
        this.libelle = libelle;
        this.version = version;
    }

    public Plan(String libelle, int version) {
        this.libelle = libelle;
        this.version = version;
    }

    public int getVersion() {
        return version;

    }

    public void setVersion(int version) {
        this.version = version;
    }

    private int version;
}
