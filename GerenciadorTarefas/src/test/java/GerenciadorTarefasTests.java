
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
            
        }

        @Test
        @DisplayName("Teste deleteTarefa")
        public void testDeleteTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa(1L, "titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.deleteTarefa(1L);

            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("Teste getTarefa")
        public void testGetTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa(1L, "titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(1L);

            assertEquals(tarefa.getTitulo(), "titulo");
            assertEquals(tarefa.getDescricao(), "descricao");
            assertEquals(tarefa.getPrioridade(), Prioridade.ALTA);
        }

        @Test
        @DisplayName("Teste updateTarefa")
        public void testUpdateTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa(1L, "titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.updateTarefa(1L, "titulo2", "descricao2", new Date(), Prioridade.BAIXA);

            TarefaDTO tarefa = tarefaController.getTarefa(1L);

            assertEquals(tarefa.getTitulo(), "titulo2");
            assertEquals(tarefa.getDescricao(), "descricao2");
            assertEquals(tarefa.getPrioridade(), Prioridade.BAIXA);
        }

    }


}


