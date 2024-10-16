package br.calebe.ticketmachine.core;

public class PapelMoeda {

    private int valor;
    private int quantidade;

    public PapelMoeda(int valor, int quantidade) {
        if (valor <= 0 || quantidade < 0) {
            throw new IllegalArgumentException("Valor ou quantidade inválidos");
        }
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }

    public void removerQuantidade(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        }
    }
}
