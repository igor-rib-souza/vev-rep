package functionalTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.example.DTOs.FaturaDTO;
import org.example.controller.NotaFiscalController;
import org.example.enums.Servico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
public class TabelaDeDecisao {

    @Nested
    @DisplayName("Testes Nota Fiscal")
    class NotaFiscalControllerTests {
        private final NotaFiscalController notaFiscalController = new NotaFiscalController();
        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private final FaturaDTO fatura1 = new FaturaDTO( "Gustavo Bilert", "SP", 100, Servico.CONSULTORIA);
        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }
        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }
        @Test
        @DisplayName("Teste de criação de nota fiscal")
        //Cenário: Uma nota fiscal válida gerada.
        //Verificar se a nota fiscal é corretamente persistida no banco de dados após a geração.
        public void teste1() {
            notaFiscalController.createNotaFiscal(fatura1);
            assertEquals("""
                   salvando no banco
                   enviando pro sap
                   enviando por email""", outputStreamCaptor.toString()
                    .trim());
        }

        @Test
        @DisplayName("Teste de criação de nota fiscal com nome nulo")
        //Cenário: Uma nota fiscal inválida gerada.
        //Verificar se um erro é lancado ao usar nome nulo.
        public void teste2() {

            try {
                FaturaDTO faturaInv = new FaturaDTO(null, "SP", 100, Servico.CONSULTORIA);
                notaFiscalController.createNotaFiscal(faturaInv);
            }catch(IllegalArgumentException i) {
                assertEquals("Dado de entrada inválido.", i.getMessage());
            }

        }

        @Test
        @DisplayName("Teste de criação de nota fiscal com nome vazio")
        //Cenário: Uma nota fiscal inválida gerada.
        //Verificar se um erro é lancado ao usar nome nulo.
        public void teste3() {

            try {
                FaturaDTO faturaInv = new FaturaDTO("", "SP", 100, Servico.CONSULTORIA);
                notaFiscalController.createNotaFiscal(faturaInv);
            }catch(IllegalArgumentException i) {
                assertEquals("Dado de entrada inválido.", i.getMessage());
            }
        }

        @Test
        @DisplayName("Teste de criação de nota fiscal com valor de fatura invalido")
        //Cenário: Uma nota fiscal inválida gerada.
        //Verificar se um erro é lancado ao usar valor de fatura 0.
        public void teste4() {
            try {
                FaturaDTO faturaInv = new FaturaDTO("Felipe Nogueira", "SP", 0, Servico.CONSULTORIA);
                notaFiscalController.createNotaFiscal(faturaInv);
            }catch(IllegalArgumentException i) {
                assertEquals("Dado de entrada inválido.", i.getMessage());
            }
        }

        @Test
        @DisplayName("Teste de criação de nota fiscal com serviço nulo")
        //Cenário: Uma nota fiscal inválida gerada.
        //Verificar se um erro é lancado ao usar serviço nulo
        public void teste5() {

            try {
                FaturaDTO faturaInv = new FaturaDTO("Felipe Nogueira", "SP", 0, null);
                notaFiscalController.createNotaFiscal(faturaInv);
            }catch(IllegalArgumentException i) {
                assertEquals("Dado de entrada inválido.", i.getMessage());
            }
        }
    }
}
