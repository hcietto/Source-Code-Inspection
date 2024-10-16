package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

public class TicketMachine {

    private int valorDoBilhete;
    private int saldo;
    private final int[] papeisMoedaValidos = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valorDoBilhete) {
        this.valorDoBilhete = valorDoBilhete;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        if (!isQuantiaValida(quantia)) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    private boolean isQuantiaValida(int quantia) {
        for (int valor : papeisMoedaValidos) {
            if (valor == quantia) {
                return true;
            }
        }
        return false;
    }

    public int getSaldo() {
        return saldo;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valorDoBilhete) {
            throw new SaldoInsuficienteException();
        }
        saldo -= valorDoBilhete;  // Desconta o valor do saldo
        return gerarTicket();
    }

    private String gerarTicket() {
        return "*****************\n" +
               "*** R$ " + valorDoBilhete + ",00 ****\n" +
               "*****************\n";
    }

    public Troco calcularTroco() {
        return new CalculadoraDeTroco().calcularTroco(saldo);
    }
}
