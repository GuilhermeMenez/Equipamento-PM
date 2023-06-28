package com.api.bicicletario.model;

public class Reparo {
    Bicicleta bicicleta;
    Tranca tranca;
    String statusAcaoReparador;

    int idFuncionario;

    public Reparo(Bicicleta bicicleta, Tranca tranca, String statusAcaoReparador) {
        this.bicicleta = bicicleta;
        this.tranca = tranca;
        this.statusAcaoReparador = statusAcaoReparador;
        this.idFuncionario = tranca.getFuncionarioId();
    }

    public void setStatusAcaoReparador(String statusAcaoReparador) {
        this.statusAcaoReparador = statusAcaoReparador;
    }
}
