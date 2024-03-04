package controller;

import java.util.List;

import DTOs.TarefaDTO;
import service.TarefaService;

public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController() {
        this.tarefaService = new TarefaService();
    }

    public void createTarefa(String titulo, String descricao, java.util.Date dataValidade, enums.Prioridade prioridade) {
        tarefaService.createTarefa(titulo, descricao, dataValidade, prioridade);
    }

    public TarefaDTO getTarefa(Long id) {
        return tarefaService.getTarefa(id);
    }

    public void deleteTarefa(Long id) {
        tarefaService.deleteTarefa(id);
    }

    public TarefaService getTarefaService() {
        return tarefaService;
    }

    public void updateTarefa(Long id, String titulo, String descricao, java.util.Date dataValidade, enums.Prioridade prioridade) {
        tarefaService.updateTarefa(id, titulo, descricao, dataValidade, prioridade);
    }

    public int getTarefasSize() {
        return tarefaService.getTarefasSize();
    }

    public List<TarefaDTO> getTarefasbyDate() {
        return tarefaService.getTarefasbyDate();
    }

}
