package com.senai.lugaluga.model;

public class Produto {
    private int id;
    private String nome;
    private Double preco;
    private String desc;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto(int id, String nome, Double preco, String desc, String status) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.desc = desc;
        this.status = status;
    }
}

