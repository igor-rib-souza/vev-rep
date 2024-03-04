import DTOs.TarefaDTO;
import controller.TarefaController;
import enums.Prioridade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GerenciadorTarefasTests {


    @Nested
    @DisplayName("Testes TarefaController")
    class TarefaControllerTests {

        private TarefaController tarefaController = new TarefaController();

        @Test
        @DisplayName("Teste createTarefa")
        public void testCreateTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());
            
        }

        @Test
        @DisplayName("Teste createTarefa sem algum atributo")
        public void testCreateTarefaSemPrioridade() {
            assertEquals(0, tarefaController.getTarefasSize());

            //Sem Prioridade
            tarefaController.createTarefa("titulo", "descricao", new Date(), null);
            assertEquals(0, tarefaController.getTarefasSize());

            //Sem Data
            tarefaController.createTarefa("titulo", "descricao", null, Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());

            //Sem Descrição
            tarefaController.createTarefa("titulo", null, new Date(), Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());

            //Sem Titulo
            tarefaController.createTarefa(null, "descricao", new Date(), Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("Teste deleteTarefa")
        public void testDeleteTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.deleteTarefa(0L);

            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("Teste getTarefa")
        public void testGetTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);

            assertEquals(tarefa.getTitulo(), "titulo");
            assertEquals(tarefa.getDescricao(), "descricao");
            assertEquals(tarefa.getPrioridade(), Prioridade.ALTA);
        }

        @Test
        @DisplayName("Teste getTarefasbyDate")
        public void testGetTarefasbyDate() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.BAIXA);
            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);
            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.MEDIA);

            List<TarefaDTO> tarefas = tarefaController.getTarefasbyDate();

            assertTrue(tarefas.get(0).getPrioridade() == Prioridade.ALTA && 
                        tarefas.get(1).getPrioridade() == Prioridade.MEDIA && 
                        tarefas.get(2).getPrioridade() == Prioridade.BAIXA
                        );

        }

        @Test
        @DisplayName("Teste updateTarefa")
        public void testUpdateTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.updateTarefa(0L, "titulo2", "descricao2", new Date(), Prioridade.BAIXA);

            TarefaDTO tarefa = tarefaController.getTarefa(0L);

            assertEquals(tarefa.getTitulo(), "titulo2");
            assertEquals(tarefa.getDescricao(), "descricao2");
            assertEquals(tarefa.getPrioridade(), Prioridade.BAIXA);
        }

    }


}


