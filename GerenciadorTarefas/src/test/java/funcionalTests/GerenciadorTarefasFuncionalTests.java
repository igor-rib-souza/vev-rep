package funcionalTests;

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

public class GerenciadorTarefasFuncionalTests {

    @Nested
    @DisplayName("Testes funcionais TarefaController")
    class TarefaControllerFuncionalTests{

        private TarefaController tarefaController = new TarefaController();

        //! TESTES PARTIÇÃO DE EQUIVALÊNCIA

        @Test
        @DisplayName("CT01")
        public void testCreateTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());
            
        }

        @Test
        @DisplayName("CT02")
        public void testCreateTarefaSemTitulo() {
            assertEquals(0, tarefaController.getTarefasSize());
        
            // Sem Título
            tarefaController.createTarefa(null, "descricao", new Date(), Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT03")
        public void testCreateTarefaSemPrioridade() {
            assertEquals(0, tarefaController.getTarefasSize());
        
            // Sem Prioridade
            tarefaController.createTarefa("titulo", "descricao", new Date(), null);
            assertEquals(0, tarefaController.getTarefasSize());
        }
        
        @Test
        @DisplayName("CT04")
        public void testCreateTarefaSemData() {
            assertEquals(0, tarefaController.getTarefasSize());
        
            // Sem Data
            tarefaController.createTarefa("titulo", "descricao", null, Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }
        
        @Test
        @DisplayName("CT05")
        public void testCreateTarefaSemDescricao() {
            assertEquals(0, tarefaController.getTarefasSize());
        
            // Sem Descrição
            tarefaController.createTarefa("titulo", null, new Date(), Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT06")
        public void testUpdateTarefaSemAtributos() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);

            tarefaController.updateTarefa(tarefa.getId(), null, null, null, null);

            TarefaDTO tarefa2 = tarefaController.getTarefa(0L);

            assertEquals(tarefa.getTitulo(), tarefa2.getTitulo());
            assertEquals(tarefa.getDescricao(), tarefa2.getDescricao());
            assertEquals(tarefa.getPrioridade(), tarefa2.getPrioridade());

            assertEquals("titulo", tarefa2.getTitulo());
            assertEquals("descricao", tarefa2.getDescricao());
            assertEquals(Prioridade.ALTA, tarefa2.getPrioridade());
        }

        @Test
        @DisplayName("CT07")
        public void testUpdateTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);

            tarefaController.updateTarefa(tarefa.getId(), "titulo2", "descricao2", new Date(), Prioridade.BAIXA);

            tarefa = tarefaController.getTarefa(0L);

            assertEquals("titulo2", tarefa.getTitulo());
            assertEquals("descricao2", tarefa.getDescricao());
            assertEquals(Prioridade.BAIXA, tarefa.getPrioridade());
        }

        @Test
        @DisplayName("CT08")
        public void testDeleteTarefa() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.deleteTarefa(0L);

            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT09")
        public void testDeleteTarefaSemTarefas() {

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.deleteTarefa(1L);

            assertEquals(1, tarefaController.getTarefasSize());
        }


        //! TESTES TABELA DE DECISÃO

        
    }
    
}
