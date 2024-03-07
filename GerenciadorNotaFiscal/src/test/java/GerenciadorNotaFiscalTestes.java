import org.example.DTOs.FaturaDTO;
import org.example.controller.NotaFiscalController;
import org.example.enums.Servico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GerenciadorNotaFiscalTestes {

    @Test
    public void verificarJUnit() {
        assertTrue(true);
    }


    @Nested
    @DisplayName("Testes Nota Fiscal")
    class NotaFiscalControllerTests {

        private NotaFiscalController notaFiscalController = new NotaFiscalController();

        private FaturaDTO fatura1 = new FaturaDTO( "Gustavo Bilert", "SP", 100, Servico.CONSULTORIA);
        private FaturaDTO fatura2 = new FaturaDTO( "Tatiane Marreiro", "SP", 200, Servico.TREINAMENTO);
        private FaturaDTO fatura3 = new FaturaDTO( "Gilson Calafange", "PB", 500, Servico.OUTRO);

        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de Consultoria:")
        // Cenário: Uma fatura com serviço de consultoria no valor de R$ 100,00.
        // Verificar se o valor do imposto calculado é de 25% do valor da fatura.
        public void testCreateNotaFiscalConsultoria() {}
        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de Treinamento")
        // Cenário: Uma fatura com serviço de treinamento no valor de R$ 200,00.
        // Verificar se o valor do imposto calculado é de 15% do valor da fatura.
        public void testCreateNotaFiscalTreinamento() {}

        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço Diferente de Consultoria e Treinamento")
        //Cenário: Uma fatura com serviço de desenvolvimento no valor de R$ 500,00.
        //Verificar se o valor do imposto calculado é de 6% do valor da fatura.
        public void testCreateNotaFiscalOutro() {}

        @Test
        @DisplayName("Teste de Geração de Nota Fiscal")
        //Cenário: Uma fatura válida com cliente, tipo de serviço e valor especificados.
        //Verificar se a nota fiscal gerada contém o nome do cliente, valor da nota e valor do imposto corretamente.
        public void testGetNotaFiscal() {}

        @Test
        @DisplayName("Teste de Persistência no Banco de Dados")
        //Cenário: Uma nota fiscal válida gerada.
        //Verificar se a nota fiscal é corretamente persistida no banco de dados após a geração.
        public void testPersistNotaFiscal() {}

    }


}
