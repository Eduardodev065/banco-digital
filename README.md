# Banco Digital

Projeto em Java e Spring Boot para construir, passo a passo, um sistema bancário.

## Como está o projeto

A classe `Conta` representa uma conta com número, titular e saldo inicial de zero. O saldo é armazenado em centavos. A conta já possui operações de depósito e saque, e os testes cobrem essas regras, incluindo a recusa de saques acima do saldo.

A aplicação agora apresenta um menu no terminal para consultar o saldo, depositar, sacar e encerrar a sessão. Os valores aceitam vírgula ou ponto e até duas casas decimais.

Transferências e histórico ainda serão implementados.

## Executar

No terminal, entre na pasta `demo` e execute:

```powershell
cd demo
.\mvnw.cmd spring-boot:run
```

A aplicação cria uma conta demonstrativa para Eduardo. Escolha uma opção no menu e, para depósitos ou saques, informe um valor como `25,90`.
