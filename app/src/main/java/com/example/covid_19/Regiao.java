package com.example.covid_19;

public class Regiao {
    private long id = -1;
    private String Distrito;

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
