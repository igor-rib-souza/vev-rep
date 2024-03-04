import DTOs.TarefaDTO;
import controller.TarefaController;
import enums.Prioridade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class GerenciadorTarefasTests {


    @Nested
    @DisplayName("Testes TarefaController")
    class TarefaControllerTests {

        private TarefaController tarefaController = new TarefaController();

        @Test
        @DisplayName("Teste createTarefa")
        public void testCreateTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa(1L, "titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());
            
            assertEquals(tarefaController.getTarefa(1L).getTitulo(),"titulo" );
            assertEquals(tarefaController.getTarefa(1L).getDescricao(),"descricao" );
            assertEquals(tarefaController.getTarefa(1L).getPrioridade(),Prioridade.ALTA );
        }
    }


}


