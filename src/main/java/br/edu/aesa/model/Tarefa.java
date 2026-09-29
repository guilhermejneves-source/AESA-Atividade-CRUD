package br.edu.aesa.model;

public class Tarefa {
    private int id;
    private String titulo;
    private String prioridade;
    private String status;

    public Tarefa(int id, String titulo, String prioridade, String status) {
        this.id = id;
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.status = status;
    }


    public int getId() { return id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("ID: %d | Título: %s | Prioridade: %s | Status: %s ",
                id, titulo, prioridade, status);
    }
}