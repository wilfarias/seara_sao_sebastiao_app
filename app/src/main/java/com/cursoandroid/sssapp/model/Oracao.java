package com.cursoandroid.sssapp.model;

import java.io.Serializable;

public class Oracao implements Serializable {

    private String nomeOracao;
    private String texto;

    public Oracao() {
    }

    public Oracao(String nome, String texto) {
        this.nomeOracao = nome;
        this.texto = texto;
    }

    public String getNome() {
        return nomeOracao;
    }

    public void setNome(String nome) {
        this.nomeOracao = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
