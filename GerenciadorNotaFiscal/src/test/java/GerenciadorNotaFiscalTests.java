import org.example.DTOs.FaturaDTO;
import org.example.DTOs.NotaFiscalDTO;
import org.example.controller.NotaFiscalController;
import org.example.enums.Servico;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GerenciadorNotaFiscalTests {

    @Test
    public void verificarJUnit() {
        assertTrue(true);
    }


    @Nested
    @DisplayName("Testes Nota Fiscal")
    class NotaFiscalControllerTests {

        private final NotaFiscalController notaFiscalController = new NotaFiscalController();
        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        private final FaturaDTO fatura1 = new FaturaDTO( "Gustavo Bilert", "SP", 100, Servico.CONSULTORIA);
        private final FaturaDTO fatura2 = new FaturaDTO( "Tatiane Marreiro", "SP", 200, Servico.TREINAMENTO);
        private final FaturaDTO fatura3 = new FaturaDTO( "Gilson Calafange", "PB", 500, Servico.OUTRO);

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de Consultoria:")
        // Cenário: Uma fatura com serviço de consultoria no valor de R$ 100,00.
        // Verificar se o valor do imposto calculado é de 25% do valor da fatura.
        public void testCreateNotaFiscalConsultoria() {
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura1);
            assertEquals(Servico.CONSULTORIA, nota.getTipoServico());
            assertEquals(25, nota.getImposto());
        }
        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço de Treinamento")
        // Cenário: Uma fatura com serviço de treinamento no valor de R$ 200,00.
        // Verificar se o valor do imposto calculado é de 15% do valor da fatura.
        public void testCreateNotaFiscalTreinamento() {
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura2);
            assertEquals(Servico.TREINAMENTO, nota.getTipoServico());
            assertEquals(30, nota.getImposto());
        }

        @Test
        @DisplayName("Teste de Cálculo de Imposto para Serviço Diferente de Consultoria e Treinamento")
        //Cenário: Uma fatura com serviço de desenvolvimento no valor de R$ 500,00.
        //Verificar se o valor do imposto calculado é de 6% do valor da fatura.
        public void testCreateNotaFiscalOutro() {
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura3);
            assertEquals(Servico.OUTRO, nota.getTipoServico());
            assertEquals(30, nota.getImposto());
        }

        @Test
        @DisplayName("Teste de Geração de Nota Fiscal")
        //Cenário: Uma fatura válida com cliente, tipo de serviço e valor especificados.
        //Verificar se a nota fiscal gerada contém o nome do cliente, valor da nota e valor do imposto corretamente.
        public void testGetNotaFiscal() {
            NotaFiscalDTO nota = notaFiscalController.createNotaFiscal(fatura1);
//            "Gustavo Bilert", "SP", 100, Servico.CONSULTORIA);
            assertEquals(fatura1.getNome(), nota.getNome());
            assertEquals(fatura1.getFatura(), nota.getValor());
            assertEquals(fatura1.getTipoServico(), nota.getTipoServico());
            assertEquals(fatura1.getFatura() * 0.25, nota.getImposto());

        }

        @Test
        @DisplayName("Teste de Persistência no Banco de Dados")
        //Cenário: Uma nota fiscal válida gerada.
        //Verificar se a nota fiscal é corretamente persistida no banco de dados após a geração.
        public void testPersistNotaFiscal() {
            notaFiscalController.createNotaFiscal(fatura1);
            assertEquals("""
                    salvando no banco
                    enviando pro sap
                    enviando por email""", outputStreamCaptor.toString()
                    .trim());
        }
    }


}
