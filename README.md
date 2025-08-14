🏦 Sistema Bancário POO
Descrição do Projeto
Este projeto é uma simulação de um sistema bancário básico, desenvolvido em Java, com foco em Programação Orientada a Objetos (POO). O sistema permite criar contas, realizar depósitos, saques, transferências via PIX, criar investimentos e acompanhar o histórico de transações.

O objetivo é aplicar conceitos fundamentais de POO, como herança, encapsulamento, polimorfismo, abstração e reuso de código, além de boas práticas de organização de projeto e documentação.

Funcionalidades
Criar contas: Conta Corrente ou Conta Poupança

Depositar valores

Sacar valores

Transferir valores entre contas via PIX

Criar investimentos vinculados à conta

Consultar histórico de transações

Estrutura do Projeto
bash
Copiar
Editar
src/
 ├── app/           # Classe Main com menu interativo
 ├── model/         # Entidades do sistema: Conta, ContaCorrente, ContaPoupanca, Transacao, Investimento
 ├── repository/    # Armazenamento em memória (ContaRepository)
 └── service/       # Regras de negócio (BancoService)
images/             # Capturas de tela do console
README.md
Conceitos de POO Aplicados
Abstração: Classe abstrata Conta define atributos e métodos comuns.

Herança: ContaCorrente e ContaPoupanca herdam de Conta.

Encapsulamento: Atributos privados com getters/setters.

Polimorfismo: Operações como transferir funcionam para qualquer tipo de conta.

Composição: Conta possui lista de Transacao e investimentos.

Tecnologias Utilizadas
Java 17

VS Code (com extensão Java Extension Pack)

GitHub (para versionamento e documentação)

Como Executar
Clone este repositório:

bash
Copiar
Editar
git clone <link-do-repositorio>
Abra a pasta no VS Code.

Certifique-se de que a pasta src está marcada como Source Folder.

Abra src/app/Main.java e execute o programa (Run ou F5).

Interaja com o menu no console.
