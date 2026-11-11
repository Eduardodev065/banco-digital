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
}
