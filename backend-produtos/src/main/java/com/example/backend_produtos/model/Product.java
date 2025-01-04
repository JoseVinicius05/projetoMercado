package com.example.mercado.model;

public class Product {
    private int idProduto;
    private String nomeProduto;
    private int quantidadeEstoque;
    private double precoProduto;
    private double valorEstoque;

    // Getter e Setter para idProduto
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    // Getter e Setter para nomeProduto
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    // Getter e Setter para quantidadeEstoque
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getter e Setter para precoProduto
    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    // Getter e Setter para valorEstoque
    public double getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(double valorEstoque) {
        this.valorEstoque = valorEstoque;
    }
}