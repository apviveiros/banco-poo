package model;

import java.math.BigDecimal;

public class Investimento {
    private String nome;
    private BigDecimal valor;

    public Investimento(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}