package org.example.service;

import org.example.DTOs.FaturaDTO;
import org.example.DTOs.NotaFiscalDTO;
import org.example.repository.*;

public class NotaFiscalService {

    private final NotaFiscalDao notaFiscalDao;
    private final SAP sap;
    private final Smtp smtp;

    public NotaFiscalService() {
        this.notaFiscalDao = new NotaFiscalDao();
        this.sap = new SAP();
        this.smtp = new Smtp();
    }

    public NotaFiscalDTO createNotaFiscal(FaturaDTO fatura) {
        NotaFiscalDTO nf = new NotaFiscalDTO(fatura.getNome(), fatura.getFatura(), fatura.getTipoServico());

        // Simula salvamento no banco, envio para o sap e para o email.
        getNotaFiscalDao().salva(nf);
        getSap().envia(nf);
        getSmtp().envia(nf);

        return nf;
    }

    public NotaFiscalDao getNotaFiscalDao() { return notaFiscalDao; }

    public SAP getSap() {
        return sap;
    }

    public Smtp getSmtp() {
        return smtp;
    }
}
