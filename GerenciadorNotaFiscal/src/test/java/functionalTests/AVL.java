package functionalTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.DTOs.FaturaDTO;
import org.example.DTOs.NotaFiscalDTO;
import org.example.controller.NotaFiscalController;
import org.example.enums.Servico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
public class AVL {
    @Nested
    @DisplayName("Testes Nota Fiscal - AVL")
    class NotaFiscalControllerAVLTests {
        private final NotaFiscalController notaFiscalController = new NotaFiscalController();
        @Test
        @DisplayName("Teste de criação de fatura com valor inválido(menor que 0.01)")
        // Cenário: Uma fatura com serviço de consultoria no valor de R$ 0.00;
        // Erro deve ser gerado já que o valor da fatura é inválido.
        public void teste1() {
            try {
                FaturaDTO fatura = new FaturaDTO( "Gustavo Bilert", "SP", 0, Servico.CONSULTORIA);
                NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura);
            }catch(IllegalArgumentException iae) {
                assertEquals("Valor de fatura inválido.", iae.getMessage());
            }
        }

        @Test
        @DisplayName("Teste de criação de fatura com valor igual a 0.01")
        // Cenário: Uma fatura com serviço de treinamento no valor de R$ 0.01;
        // Nota fiscal criada, já que o valor é o mínimo válido.
        public void teste2() {
            try {
                FaturaDTO fatura = new FaturaDTO( "Gustavo Bilert", "SP", 0.01, Servico.CONSULTORIA);
                NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura);
                assertEquals(Servico.CONSULTORIA, nota.getTipoServico());
                assertEquals(0.0025, nota.getImposto());
            }catch(IllegalArgumentException iae) {
                assertEquals("Valor de fatura inválido.", iae.getMessage());
            }
        }
        @Test
        @DisplayName("Teste de criação de fatura com valor maior que 0.01")
        // Cenário: Uma fatura com serviço de treinamento no valor de R$ 0.02;
        // Nota fiscal criada.
        public void teste3() {
            try {
                FaturaDTO fatura = new FaturaDTO( "Gustavo Bilert", "SP", 0.02, Servico.CONSULTORIA);
                NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura);
                assertEquals(Servico.CONSULTORIA, nota.getTipoServico());
                assertEquals(0.005, nota.getImposto());
            }catch(IllegalArgumentException iae) {
                assertEquals("Valor de fatura inválido.", iae.getMessage());
            }
        }
    }
}
