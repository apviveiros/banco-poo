package app;

import service.BancoService;
import model.Conta;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BancoService bancoService = new BancoService();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("=== MENU BANCO ===");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Consultar conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Tipo de conta (corrente/poupanca): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nome do titular: ");
                    String titular = scanner.nextLine();
                    Conta conta = bancoService.criarConta(tipo, titular);
                    System.out.println("Conta criada com sucesso! Número: " + conta.getNumero());
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    int numDep = scanner.nextInt();
                    System.out.print("Valor do depósito: ");
                    BigDecimal valorDep = scanner.nextBigDecimal();
                    if (bancoService.depositar(numDep, valorDep)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int numSaq = scanner.nextInt();
                    System.out.print("Valor do saque: ");
                    BigDecimal valorSaq = scanner.nextBigDecimal();
                    if (bancoService.sacar(numSaq, valorSaq)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada ou saldo insuficiente.");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta de origem: ");
                    int numOrigem = scanner.nextInt();
                    System.out.print("Número da conta de destino: ");
                    int numDestino = scanner.nextInt();
                    System.out.print("Valor da transferência: ");
                    BigDecimal valorTransf = scanner.nextBigDecimal();
                    if (bancoService.transferir(numOrigem, numDestino, valorTransf)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Conta(s) não encontrada(s) ou saldo insuficiente.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta: ");
                    int numCons = scanner.nextInt();
                    Conta contaConsulta = bancoService.buscarConta(numCons);
                    if (contaConsulta != null) {
                        System.out.println(contaConsulta);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }
}
