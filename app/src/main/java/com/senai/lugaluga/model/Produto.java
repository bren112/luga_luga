package com.senai.lugaluga.model;

public class Produto {
    private String nome;
    private String desc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private double preco;
    private int qtd;
    private String status;

    public Produto(String nome, String desc, double preco, int qtd, String status) {
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.qtd = qtd;
        this.status = status;
    }
}


