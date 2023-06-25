package com.api.bicicletario.model;

import java.util.ArrayList;
import java.util.List;

public class Totem {
    private int id;
    private String localizacao;
    private String descricao;
    private List<Tranca> trancas;


    public Totem(int id, String localizacao, String descricao) {
        this.id = id;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.trancas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Tranca> getTrancas() {
        return trancas;
    }

    public void setTrancas(List<Tranca> trancas) {
        this.trancas = trancas;
    }
}
