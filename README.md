# Banco Digital

Projeto de estudo em Java e Spring Boot para construir, passo a passo, um sistema bancário.

## Como está o projeto

A classe `Conta` representa uma conta com número, titular e saldo inicial de zero. O saldo é guardado em centavos para evitar problemas de arredondamento. Já é possível fazer depósitos e saques; os testes conferem essas operações e impedem saques acima do saldo.

Por enquanto, a aplicação cria uma conta de exemplo e mostra o titular e o saldo no terminal. Transferências e histórico ainda serão implementados.
.\mvnw.cmd spring-boot:run
