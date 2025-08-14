package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static int SEQUENCIAL = 1;

    private int numero;
    private String titular;
    private BigDecimal saldo;
    private List<Transacao> historico;

    public Conta(String titular) {
        this.numero = SEQUENCIAL++;
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
        this.historico = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<Transacao> getHistorico() {
        return historico;
    }

    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
        historico.add(new Transacao("Depósito", valor));
    }

    public boolean sacar(BigDecimal valor) {
        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            historico.add(new Transacao("Saque", valor.negate()));
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, BigDecimal valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            historico.add(new Transacao("Transferência para conta " + destino.getNumero(), valor.negate()));
            return true;
        }
        return false;
    }
}