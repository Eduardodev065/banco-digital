package br.com.eduardo.demo;

public class Conta {
    private String titular;
    private long saldoEmCentavos;
    private String numero;
    
    public Conta(String numero, String titular) {
    this.numero = numero;
    this.titular = titular;
    this.saldoEmCentavos = 0;
}

    public String getNumero() {
        return numero;
    }

    public long getSaldoEmCentavos() {
        return saldoEmCentavos;
    }
    public String getTitular() {
    return titular;
}

public void depositar(long valorEmCentavos) {
    if (valorEmCentavos <= 0) {
        return;
    }

    saldoEmCentavos = saldoEmCentavos + valorEmCentavos;
}

public boolean sacar(long valorEmCentavos) {
    if (valorEmCentavos <= 0 || valorEmCentavos > saldoEmCentavos) {
        return false;
    }

    saldoEmCentavos = saldoEmCentavos - valorEmCentavos;
    return true;
}
}
