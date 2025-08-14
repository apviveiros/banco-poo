package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime data;

    public Transacao(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return descricao + " | " + valor + " | " + data;
    }
}