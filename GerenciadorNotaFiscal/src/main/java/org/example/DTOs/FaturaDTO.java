package org.example.DTOs;

import org.example.enums.Servico;

import java.util.Date;

public class FaturaDTO {
    private String nome;
    private String endereco;
    private double fatura;
    private Servico tipoServico;

    public FaturaDTO(String nome, String endereco, double fatura, Servico tipoServico) {
        this.nome = nome;
        this.endereco = endereco;
        this.fatura = fatura;
        this.tipoServico = tipoServico;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getFatura() {
        return fatura;
    }

    public Servico getTipoServico() {
        return tipoServico;
    }
}
