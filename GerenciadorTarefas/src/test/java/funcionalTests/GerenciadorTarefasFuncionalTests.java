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

        @Test
        @DisplayName("CT10")
        public void testCreateTarefaTodosDadosValidos() {
            assertEquals(0, tarefaController.getTarefasSize());
            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);
            assertEquals(1, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT11")
        public void testCreateTarefaSemTituloDecisao() {
            assertEquals(0, tarefaController.getTarefasSize());
            tarefaController.createTarefa(null, "descricao", new Date(), Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT12")
        public void testCreateTarefaSemDescricaoDecisao() {
            assertEquals(0, tarefaController.getTarefasSize());
            tarefaController.createTarefa("titulo", null, new Date(), Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT13")
        public void testCreateTarefaSemDataDecisao() {
            assertEquals(0, tarefaController.getTarefasSize());
            tarefaController.createTarefa("titulo", "descricao", null, Prioridade.ALTA);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT14")
        public void testCreateTarefaSemPrioridadeDecisao() {
            assertEquals(0, tarefaController.getTarefasSize());
            tarefaController.createTarefa("titulo", "descricao", new Date(), null);
            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT15")
        public void testUpdateTarefaTodosDadosValidos() {
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
        @DisplayName("CT16")
        public void testUpdateTarefaTarefaInexistente() {
            assertEquals(0, tarefaController.getTarefasSize());
            
            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);
            assertEquals(1, tarefaController.getTarefasSize());
            
            TarefaDTO tarefa = tarefaController.getTarefa(0L);
        
            tarefaController.updateTarefa(999L, "novoTitulo", "novaDescricao", new Date(), Prioridade.BAIXA);
            
            TarefaDTO tarefaAtualizada = tarefaController.getTarefa(0L);

            assertEquals(tarefa.getTitulo(), tarefaAtualizada.getTitulo());
            assertEquals(tarefa.getDescricao(), tarefaAtualizada.getDescricao());
            assertEquals(tarefa.getDataValidade(), tarefaAtualizada.getDataValidade());
            assertEquals(tarefa.getPrioridade(), tarefaAtualizada.getPrioridade());
        }

        @Test
        @DisplayName("CT17")
        public void testUpdateTarefaSemTitulo() {
            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);
            tarefaController.updateTarefa(tarefa.getId(), null, "descricao2", new Date(), Prioridade.BAIXA);
            tarefa = tarefaController.getTarefa(0L);

            assertEquals("titulo", tarefa.getTitulo());
            assertEquals("descricao2", tarefa.getDescricao());
            assertEquals(Prioridade.BAIXA, tarefa.getPrioridade());
        }

        @Test
        @DisplayName("CT18")
        public void testUpdateTarefaSemDescricao() {

            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);
            tarefaController.updateTarefa(tarefa.getId(), "titulo2", null, new Date(), Prioridade.BAIXA);
            tarefa = tarefaController.getTarefa(0L);

            assertEquals("descricao", tarefa.getDescricao());
            assertEquals("titulo2", tarefa.getTitulo());
            assertEquals(Prioridade.BAIXA, tarefa.getPrioridade());
        }

        @Test
        @DisplayName("CT19")
        public void testUpdateTarefaSemData() {
            Date data = new Date();

            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", data, Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);
            tarefaController.updateTarefa(tarefa.getId(), "titulo2", "descricao2", null, Prioridade.BAIXA);
            tarefa = tarefaController.getTarefa(0L);

            assertEquals(data, tarefa.getDataValidade());
            assertEquals("titulo2", tarefa.getTitulo());
            assertEquals("descricao2", tarefa.getDescricao());
        }

        @Test
        @DisplayName("CT20")
        public void testUpdateTarefaSemPrioridade() {

            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);
            tarefaController.updateTarefa(tarefa.getId(), "titulo2", "descricao2", new Date(), null);
            tarefa = tarefaController.getTarefa(0L);

            assertEquals(Prioridade.ALTA, tarefa.getPrioridade());
            assertEquals("titulo2", tarefa.getTitulo());
            assertEquals("descricao2", tarefa.getDescricao());
        }

        @Test
        @DisplayName("CT21")
        public void testDeleteTarefaComTarefaExistente() {

            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            TarefaDTO tarefa = tarefaController.getTarefa(0L);
            tarefaController.deleteTarefa(tarefa.getId());

            assertEquals(0, tarefaController.getTarefasSize());
        }

        @Test
        @DisplayName("CT22")
        public void testDeleteTarefaSemTarefaExistente() {

            assertEquals(0, tarefaController.getTarefasSize());

            tarefaController.createTarefa("titulo", "descricao", new Date(), Prioridade.ALTA);

            assertEquals(1, tarefaController.getTarefasSize());

            tarefaController.deleteTarefa(1L);
            
            assertEquals(1, tarefaController.getTarefasSize());
        }

        
    }
    
}
