# Banco Digital

Projeto em Java e Spring Boot para construir, passo a passo, um sistema bancário.

## Como está o projeto

A classe `Conta` representa uma conta com número, titular e saldo inicial de zero. O saldo é guardado em centavos para evitar erros comuns de arredondamento. A conta já tem operações de depósito e saque, e os testes cobrem essas regras, incluindo a recusa de saques acima do saldo.

Agora a aplicação também oferece um menu no terminal para consultar o saldo, depositar, sacar e encerrar a sessão. Os valores aceitam vírgula ou ponto e são limitados a duas casas decimais.

Transferências e histórico ainda serão implementados.

## Executar

No terminal, entre na pasta `demo` e execute:

```powershell
cd demo
.\mvnw.cmd spring-boot:run
```

A aplicação cria uma conta de exemplo para Eduardo. Você pode digitar as opções do menu e testar operações com valores como `25,90`.
