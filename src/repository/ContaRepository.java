package repository;

import java.util.HashMap;
import java.util.Map;
import model.Conta;

public class ContaRepository {
    private Map<Integer, Conta> contas = new HashMap<>();

    public void salvar(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public Conta buscar(int numero) {
        return contas.get(numero);
    }

    public Map<Integer, Conta> listar() {
        return contas;
    }
}