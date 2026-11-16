# Banco Digital

Projeto em Java e Spring Boot para construir, passo a passo, um sistema bancário.

## Como está o projeto

A classe `Conta` representa uma conta com número, titular e saldo inicial de zero. O saldo é guardado em centavos para evitar erros comuns de arredondamento. Já existem operações de depósito e saque, com testes para validar essas regras e impedir saques acima do saldo.

Ao iniciar a aplicação, uma demonstração no terminal cria uma conta de exemplo e executa um depósito de R$ 50,00, um saque de R$ 15,00 e uma tentativa de saque acima do saldo. Assim, é possível acompanhar o saldo mudando e conferir que a operação inválida é recusada.

Transferências e histórico ainda serão implementados.

## Executar

No terminal, entre na pasta `demo` e execute:

```powershell
cd demo
.\mvnw.cmd spring-boot:run
```

A aplicação imprime a demonstração no terminal durante a inicialização.
