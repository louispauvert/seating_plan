package com.example.cesi.seating_plan.model;

import java.awt.*;

public class Bureau {
    private long id;

    private long id_collab;

    private List listMateriel;

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

    public Bureau(long id, long id_collab) {
        this.id = id;
        this.id_collab = id_collab;
    }
}
