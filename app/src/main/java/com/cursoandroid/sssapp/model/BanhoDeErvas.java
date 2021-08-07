package com.cursoandroid.sssapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BanhoDeErvas implements Serializable {

    private String nome;
    private String ingredientes;
    private String modo_preparo;
    private String oracoes;
    private String defumacao;
    private String descricao;

    public BanhoDeErvas() {
    }

    public BanhoDeErvas(String nome, String ingredientes, String modo_preparo, String oracoes, String defumacao, String descricao) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.modo_preparo = modo_preparo;
        this.oracoes = oracoes;
        this.defumacao = defumacao;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModo_preparo() {
        return modo_preparo;
    }

    public void setModo_preparo(String modo_preparo) {
        this.modo_preparo = modo_preparo;
    }

    public String getOracoes() {
        return oracoes;
    }

    public void setOracoes(String oracoes) {
        this.oracoes = oracoes;
    }

    public String getDefumacao() {
        return defumacao;
    }

    public void setDefumacao(String defumacao) {
        this.defumacao = defumacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
