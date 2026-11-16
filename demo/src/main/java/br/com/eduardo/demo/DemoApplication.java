package br.com.eduardo.demo;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final NumberFormat FORMATO_MOEDA =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Conta conta = new Conta("001", "Eduardo");
        System.out.println("\n=== Demonstração da conta ===");
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo inicial: " + formatar(conta.getSaldoEmCentavos()));

        long deposito = 5_000;
        conta.depositar(deposito);
        System.out.println("Depósito de " + formatar(deposito)
                + " realizado. Saldo: " + formatar(conta.getSaldoEmCentavos()));

        long saque = 1_500;
        if (conta.sacar(saque)) {
            System.out.println("Saque de " + formatar(saque)
                    + " realizado. Saldo: " + formatar(conta.getSaldoEmCentavos()));
        }

        long saqueAcimaDoSaldo = 10_000;
        if (!conta.sacar(saqueAcimaDoSaldo)) {
            System.out.println("Saque de " + formatar(saqueAcimaDoSaldo)
                    + " recusado. Saldo preservado: " + formatar(conta.getSaldoEmCentavos()));
        }
    }

    private static String formatar(long valorEmCentavos) {
        return FORMATO_MOEDA.format(BigDecimal.valueOf(valorEmCentavos, 2));
    }
}
