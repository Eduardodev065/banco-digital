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
    private static final String BORDA = "─".repeat(46);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Conta conta = new Conta("001", "Eduardo");
        executarMenu(conta);
    }

    private static void executarMenu(Conta conta) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                mostrarPainel(conta);
                System.out.print("  Escolha uma opção: ");

                if (!scanner.hasNextLine()) {
                    return;
                }

                String opcao = scanner.nextLine().trim();
                switch (opcao) {
                    case "1" -> System.out.println("\n  Saldo disponível: "
                            + formatar(conta.getSaldoEmCentavos()));
                    case "2" -> depositar(scanner, conta);
                    case "3" -> sacar(scanner, conta);
                    case "0" -> {
                        System.out.println("\n  Sessão encerrada. Até mais!");
                        return;
                    }
                    default -> System.out.println("\n  Opção inválida. Escolha 0, 1, 2 ou 3.");
                }

                System.out.println("\n  Pressione Enter para voltar ao menu...");
                if (!scanner.hasNextLine()) {
                    return;
                }
                scanner.nextLine();
            }
        }
    }

    private static void mostrarPainel(Conta conta) {
        System.out.println("\n╭" + BORDA + "╮");
        imprimirLinha("                 BANCO DIGITAL");
        imprimirLinha("          Operações da conta • Java");
        System.out.println("├" + BORDA + "┤");
        imprimirLinha("CONTA  " + conta.getNumero() + "   •   TITULAR  " + conta.getTitular());
        imprimirLinha("SALDO DISPONÍVEL  " + formatar(conta.getSaldoEmCentavos()));
        System.out.println("├" + BORDA + "┤");
        imprimirLinha("[1]  Consultar saldo");
        imprimirLinha("[2]  Fazer depósito");
        imprimirLinha("[3]  Fazer saque");
        imprimirLinha("[0]  Encerrar");
        System.out.println("╰" + BORDA + "╯");
    }

    private static void imprimirLinha(String texto) {
        System.out.printf("│ %-44s │%n", texto);
    }

    private static void depositar(Scanner scanner, Conta conta) {
        Long valor = lerValor(scanner);
        if (valor == null) {
            return;
        }
        if (valor <= 0) {
            System.out.println("  O depósito precisa ser maior que zero.");
            return;
        }

        conta.depositar(valor);
        System.out.println("  Depósito de " + formatar(valor) + " realizado.");
        System.out.println("  Novo saldo: " + formatar(conta.getSaldoEmCentavos()));
    }

    private static void sacar(Scanner scanner, Conta conta) {
        Long valor = lerValor(scanner);
        if (valor == null) {
            return;
        }
        if (conta.sacar(valor)) {
            System.out.println("  Saque de " + formatar(valor) + " realizado.");
            System.out.println("  Novo saldo: " + formatar(conta.getSaldoEmCentavos()));
        } else {
            System.out.println("  Saque não realizado. Confira o valor e o saldo disponível.");
        }
    }

    private static Long lerValor(Scanner scanner) {
        System.out.print("  Digite o valor (ex.: 25,90): ");
        if (!scanner.hasNextLine()) {
            return null;
        }

        try {
            BigDecimal valor = new BigDecimal(scanner.nextLine().trim().replace(',', '.'));
            return valor.setScale(2, RoundingMode.UNNECESSARY)
                    .movePointRight(2)
                    .longValueExact();
        } catch (NumberFormatException | ArithmeticException erro) {
            System.out.println("  Valor inválido. Use até duas casas decimais.");
            return null;
        }
    }

    private static String formatar(long valorEmCentavos) {
        return FORMATO_MOEDA.format(BigDecimal.valueOf(valorEmCentavos, 2));
    }
}
