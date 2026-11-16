package br.com.eduardo.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final NumberFormat FORMATO_MOEDA =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Conta conta = new Conta("001", "Eduardo");
        System.out.println("\nConta criada para " + conta.getTitular() + ".");
        executarMenu(conta);
    }

    private static void executarMenu(Conta conta) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Banco Digital ===");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("0 - Encerrar");
                System.out.print("Escolha uma opção: ");

                if (!scanner.hasNextLine()) {
                    return;
                }

                String opcao = scanner.nextLine().trim();
                switch (opcao) {
                    case "1" -> System.out.println("Saldo: " + formatar(conta.getSaldoEmCentavos()));
                    case "2" -> depositar(scanner, conta);
                    case "3" -> sacar(scanner, conta);
                    case "0" -> {
                        System.out.println("Sessão encerrada.");
                        return;
                    }
                    default -> System.out.println("Opção inválida. Escolha 0, 1, 2 ou 3.");
                }
            }
        }
    }

    private static void depositar(Scanner scanner, Conta conta) {
        Long valor = lerValor(scanner);
        if (valor == null) {
            return;
        }
        if (valor <= 0) {
            System.out.println("O depósito precisa ser maior que zero.");
            return;
        }

        conta.depositar(valor);
        System.out.println("Depósito realizado. Saldo: " + formatar(conta.getSaldoEmCentavos()));
    }

    private static void sacar(Scanner scanner, Conta conta) {
        Long valor = lerValor(scanner);
        if (valor == null) {
            return;
        }
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado. Saldo: " + formatar(conta.getSaldoEmCentavos()));
        } else {
            System.out.println("Saque não realizado. Confira o valor e o saldo disponível.");
        }
    }

    private static Long lerValor(Scanner scanner) {
        System.out.print("Valor (ex.: 25,90): ");
        if (!scanner.hasNextLine()) {
            return null;
        }

        try {
            BigDecimal valor = new BigDecimal(scanner.nextLine().trim().replace(',', '.'));
            return valor.setScale(2, RoundingMode.UNNECESSARY)
                    .movePointRight(2)
                    .longValueExact();
        } catch (NumberFormatException | ArithmeticException erro) {
            System.out.println("Valor inválido. Digite um valor com até duas casas decimais.");
            return null;
        }
    }

    private static String formatar(long valorEmCentavos) {
        return FORMATO_MOEDA.format(BigDecimal.valueOf(valorEmCentavos, 2));
    }
}
