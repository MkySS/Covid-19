package com.example.covid_19;

public class Local {
    private long id = -1;
    private String nome;
    private String rua;
    private long id_regiao = -1;
    private long id_tipo = -1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getId_regiao() {
        return id_regiao;
    }

    public void setId_regiao(long id_regiao) {
        this.id_regiao = id_regiao;
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }
}
