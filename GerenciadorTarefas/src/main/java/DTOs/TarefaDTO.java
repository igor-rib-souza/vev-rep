package DTOs;

import enums.Prioridade;

import java.util.Date;

public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Date dataValidade;
    private Prioridade prioridade;

    public TarefaDTO(Long id, String titulo, String descricao, Date dataValidade, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

}
