package service;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import repository.ContaRepository;
import java.math.BigDecimal;

public class BancoService {
    private ContaRepository contaRepository = new ContaRepository();

    public Conta criarConta(String tipo, String titular) {
        Conta conta;
        if ("corrente".equalsIgnoreCase(tipo)) {
            conta = new ContaCorrente(titular);
        } else {
            conta = new ContaPoupanca(titular);
        }
        contaRepository.salvar(conta);
        return conta;
    }

    public boolean depositar(int numeroConta, BigDecimal valor) {
        Conta conta = contaRepository.buscar(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean sacar(int numeroConta, BigDecimal valor) {
        Conta conta = contaRepository.buscar(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false;
    }

    public boolean transferir(int origem, int destino, BigDecimal valor) {
        Conta contaOrigem = contaRepository.buscar(origem);
        Conta contaDestino = contaRepository.buscar(destino);
        if (contaOrigem != null && contaDestino != null) {
            return contaOrigem.transferir(contaDestino, valor);
        }
        return false;
    }

    public Conta buscarConta(int numero) {
        return contaRepository.buscar(numero);
    }
}