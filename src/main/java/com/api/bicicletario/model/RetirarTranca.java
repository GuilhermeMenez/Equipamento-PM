package com.api.bicicletario.model;

public class RetirarTranca {
    int idTotem;
    long idTranca;
    int idFucionario;
    String StatusacaoReparador;

    public int getIdTotem() {
        return idTotem;
    }

    public long getIdTranca() {
        return idTranca;
    }

    public int getIdFucionario() {
        return idFucionario;
    }

    public String getStatusacaoReparador() {
        return StatusacaoReparador;
    }

    public void setIdTotem(int idTotem) {
        this.idTotem = idTotem;
    }

    public void setIdTranca(long idTranca) {
        this.idTranca = idTranca;
    }

    public void setIdFucionario(int idFucionario) {
        this.idFucionario = idFucionario;
    }

    public void setStatusacaoReparador(String statusacaoReparador) {
        StatusacaoReparador = statusacaoReparador;
    }
}
