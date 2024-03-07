package service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import DTOs.TarefaDTO;
import repository.TarefaRepository;

public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService() {
        this.tarefaRepository = new TarefaRepository();
    }

    public void createTarefa(String titulo, String descricao, java.util.Date dataValidade, enums.Prioridade prioridade) {
        Long id = Long.valueOf(tarefaRepository.getTarefasSize());
        TarefaDTO tarefa = new TarefaDTO(id, titulo, descricao, dataValidade, prioridade);
        if (tarefa.getTitulo() == null || tarefa.getDescricao() == null || tarefa.getDataValidade() == null || tarefa.getPrioridade() == null) {
            return;
        }
        tarefaRepository.createTarefa(tarefa);
    }

    public TarefaDTO getTarefa(Long id) {
        TarefaDTO tarefa = tarefaRepository.getTarefa(id);
        return new TarefaDTO(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataValidade(), tarefa.getPrioridade());
    }

    public void deleteTarefa(Long id) {
        tarefaRepository.deleteTarefa(id);
    }

    public void updateTarefa(Long id, String titulo, String descricao, java.util.Date dataValidade, enums.Prioridade prioridade) {
        TarefaDTO tarefaAtual = this.getTarefa(id);
    
        if (tarefaAtual != null) {
            if (titulo != null) {
                tarefaAtual.setTitulo(titulo);
            }
            if (descricao != null) {
                tarefaAtual.setDescricao(descricao);
            }
            if (dataValidade != null) {
                tarefaAtual.setDataValidade(dataValidade);
            }
            if (prioridade != null) {
                tarefaAtual.setPrioridade(prioridade);
            }
            
            tarefaRepository.updateTarefa(tarefaAtual.getId(), tarefaAtual);
        }
    }
    

    public TarefaRepository getTarefaRepository() {
        return tarefaRepository;
    }

    public int getTarefasSize() {
        return tarefaRepository.getTarefasSize();
    }

    public List<TarefaDTO> getTarefasbyDate() {
        Map<Long, TarefaDTO> tarefasMap = tarefaRepository.getTarefas();

        // Ordenar as tarefas por data e prioridade
        List<TarefaDTO> tarefasOrdenadas = tarefasMap.values().stream()
                .sorted(Comparator.comparing(TarefaDTO::getDataValidade)
                        .thenComparing(TarefaDTO::getPrioridade))
                .collect(Collectors.toList());

        return tarefasOrdenadas;
    }
}
