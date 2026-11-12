package br.com.eduardo.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContaTest {
    @Test
void depositarAumentaOSaldo() {
    Conta conta = new Conta("001", "Eduardo");

    conta.depositar(3000);

    assertEquals(3000, conta.getSaldoEmCentavos());
}
@Test
void sacarDiminuiOSaldo() {
    Conta conta = new Conta("001", "Eduardo");

    conta.depositar(3000);
    conta.sacar(1000);

    assertEquals(2000, conta.getSaldoEmCentavos());
}
@Test
void naoPermiteSaqueMaiorQueOSaldo() {
    Conta conta = new Conta("001", "Eduardo");

    assertFalse(conta.sacar(1000));
    assertEquals(0, conta.getSaldoEmCentavos());
}
@Test
void depositoZeroNaoAlteraOSaldo() {
    Conta conta = new Conta("001", "Eduardo");

    conta.depositar(0);

    assertEquals(0, conta.getSaldoEmCentavos());
}
}
