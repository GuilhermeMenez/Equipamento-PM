package com.api.bicicletario.model;

import com.api.bicicletario.enumerator.TrancaStatus;

import java.util.Objects;

// Model: Tranca.java
public class Tranca {
    private int id;
    private Bicicleta bicicleta;
    private int numero;
    private String localizacao;
    private String anoDeFabricacao;
    private String modelo;
    private TrancaStatus status;
    private int funcionarioId;

    public Tranca(int id, Bicicleta bicicleta, int numero, String localizacao, String anoDeFabricacao, String modelo, TrancaStatus status) {
        this.id = id;
        this.bicicleta = bicicleta;
        this.numero = numero;
        this.localizacao = localizacao;
        this.anoDeFabricacao = anoDeFabricacao;
        this.modelo = modelo;
        this.status = status;
    }

    public Tranca() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(String anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TrancaStatus getStatus() {
        return status;
    }

    public void setStatus(TrancaStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tranca otherTranca = (Tranca) obj;
        return id == otherTranca.id &&
                Objects.equals(bicicleta, otherTranca.bicicleta) &&
                numero == otherTranca.numero &&
                Objects.equals(localizacao, otherTranca.localizacao) &&
                Objects.equals(anoDeFabricacao, otherTranca.anoDeFabricacao) &&
                Objects.equals(modelo, otherTranca.modelo) &&
                status == otherTranca.status;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (bicicleta != null ? bicicleta.hashCode() : 0);
        result = 31 * result + numero;
        result = 31 * result + (localizacao != null ? localizacao.hashCode() : 0);
        result = 31 * result + (anoDeFabricacao != null ? anoDeFabricacao.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }


}
