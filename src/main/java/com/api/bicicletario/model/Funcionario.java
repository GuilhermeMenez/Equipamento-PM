package com.api.bicicletario.model;

public class Funcionario {
    private String matricula;
    private String senha;
    private String confirmacaoSenha;
    private String email;
    private String nome;
    private int idade;
    private String funcao;
    private String cpf;

    // Construtores, getters e setters

    public Funcionario(String matricula, String senha, String confirmacaoSenha, String email, String nome, int idade, String funcao, String cpf) {
        this.matricula = matricula;
        this.senha = senha;
        this.confirmacaoSenha = confirmacaoSenha;
        this.email = email;
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
        this.cpf = cpf;
    }

    // Getters e setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}