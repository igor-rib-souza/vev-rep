package functionalTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.DTOs.FaturaDTO;
import org.example.DTOs.NotaFiscalDTO;
import org.example.controller.NotaFiscalController;
import org.example.enums.Servico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
public class ParticoesDeEquivalencia {
    @Nested
    @DisplayName("Testes Nota Fiscal - Partições de equivalência")
    class NotaFiscalControllerPETests {
        private final NotaFiscalController notaFiscalController = new NotaFiscalController();
        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de Consultoria:")
        // Cenário: Uma fatura com serviço de consultoria no valor de R$ 500.00;
        // Verificar se o valor do imposto calculado é de 25% do valor da fatura.
        public void teste1() {
            FaturaDTO fatura = new FaturaDTO( "Felipe Nogueira", "CG", 500, Servico.CONSULTORIA);
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura);
            assertEquals(Servico.CONSULTORIA, nota.getTipoServico());
            assertEquals(125, nota.getImposto());
        }

        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de Treinamento")
        // Cenário: Uma fatura com serviço de treinamento no valor de R$ 500.00.
        // Verificar se o valor do imposto calculado é de 15% do valor da fatura.
        public void teste2() {
            FaturaDTO fatura = new FaturaDTO( "Felipe Nogueira", "CG", 500, Servico.TREINAMENTO);
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura);
            assertEquals(Servico.TREINAMENTO, nota.getTipoServico());
            assertEquals(75, nota.getImposto());
        }
        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de outro tipo")
        //Cenário: Uma fatura com serviço de outro tipo no valor de R$ 500.00.
        //Verificar se o valor do imposto calculado é de 6% do valor da fatura.
        public void teste3() {
            FaturaDTO fatura = new FaturaDTO( "Felipe Nogueira", "CG", 500, Servico.OUTRO);
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura);
            assertEquals(Servico.OUTRO, nota.getTipoServico());
            assertEquals(30, nota.getImposto());
        }
    }
}
