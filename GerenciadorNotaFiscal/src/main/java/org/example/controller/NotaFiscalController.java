package org.example.controller;

import org.example.DTOs.FaturaDTO;
import org.example.DTOs.NotaFiscalDTO;
import org.example.service.NotaFiscalService;

public class NotaFiscalController {
    private final NotaFiscalService notaFiscalService;

    public NotaFiscalController() {
        this.notaFiscalService = new NotaFiscalService();
    }

    public NotaFiscalDTO createNotaFiscal(FaturaDTO fatura) {
        return notaFiscalService.createNotaFiscal(fatura);
    }

}
