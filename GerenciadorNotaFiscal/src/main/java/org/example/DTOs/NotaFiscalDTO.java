package org.example.DTOs;

import org.example.enums.Servico;

public class NotaFiscalDTO {

    private final String nome;
    private final double valor;
    private final double imposto;
    private final Servico tipoServico;

    public NotaFiscalDTO(String nome, double valorFatura, Servico tipoServico) {
        this.nome = nome;
        this.valor = valorFatura;
        this.tipoServico = tipoServico;
        this.imposto = calculaImposto();
    }

    private double calculaImposto() {
        double porcentagem = switch (this.tipoServico) {
            case CONSULTORIA -> 0.25;
            case TREINAMENTO -> 0.15;
            default -> 0.06;
        };

        return this.valor * porcentagem;
    }


    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public double getImposto() {
        return imposto;
    }

    public Servico getTipoServico() { return tipoServico; }
}
