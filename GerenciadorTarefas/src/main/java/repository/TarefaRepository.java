package repository;

import DTOs.TarefaDTO;

import java.util.HashMap;
import java.util.Map;

public class TarefaRepository {

    private Map<Long, TarefaDTO> tarefas;

    public TarefaRepository() {
        this.tarefas = new HashMap<>();
    }

    public void createTarefa(TarefaDTO tarefa) {
        tarefas.put(tarefa.getId(), tarefa);
    }

    public TarefaDTO getTarefa(Long id) {
        return tarefas.get(id);
    }

    public void deleteTarefa(Long id) {
        tarefas.remove(id);
    }

    public void updateTarefa(Long id, TarefaDTO tarefa) {
        tarefas.put(id, tarefa);
    }

    public int getTarefasSize() {
        return tarefas.size();
    }

    public Map<Long, TarefaDTO> getTarefas() {
        return tarefas;
    }

}
