# Banco Digital

Projeto de estudo em Java e Spring Boot para construir, passo a passo, um sistema bancário.

## Como está o projeto

A aplicação Spring Boot está configurada. A classe `Conta` representa uma conta com número, titular e saldo inicial de zero. O saldo é guardado em centavos para evitar problemas de arredondamento com números decimais.

**O projeto ainda está no início:** depósito, saque, transferência e histórico ainda serão implementados.

## Tecnologias

- Java 21
- Spring Boot
- Maven
- H2
- Spring Data JPA
- Spring Web MVC

## Como executar

No terminal, entre na pasta `demo` e execute:

```powershell
.\mvnw.cmd spring-boot:run
