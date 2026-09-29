package br.edu.aesa.service;

import br.edu.aesa.model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas;
    private int geradorId;

    public TarefaService() {
        this.tarefas = new ArrayList<>();
        this.geradorId = 1;
    }


    private Tarefa buscarTarefaPorIdInterno(int id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }


    public void cadastrar(String titulo, String prioridade, String status) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Erro: O título da tarefa não pode ser vazio.");
            return;
        }
        Tarefa novaTarefa = new Tarefa(geradorId, titulo, prioridade, status);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa cadastrada com sucesso! ID gerado: " + geradorId);
        geradorId++;
    }


    public void listarTodos() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada no momento.");
            return;
        }
        System.out.println("\n--- Lista de Tarefas ---");
        for (Tarefa t : tarefas) {
            System.out.println(t.toString());
        }
        System.out.println("--------------------------");
    }

    public void buscarPorId(int id) {
        Tarefa tarefa = buscarTarefaPorIdInterno(id);
        if (tarefa != null) {
            System.out.println("Tarefa encontrada: " + tarefa.toString());
        } else {
            System.out.println("Erro: Nenhum registro encontrado com o ID " + id + ".");
        }
    }

    public void atualizar(int id, String novoTitulo, String novaPrioridade, String novoStatus) {
        Tarefa tarefa = buscarTarefaPorIdInterno(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setPrioridade(novaPrioridade);
            tarefa.setStatus(novoStatus);
            System.out.println("Registro atualizado com sucesso!");
        } else {
            System.out.println("Erro: Não é possível atualizar. ID " + id + " não existe.");
        }
    }


    public void remover(int id) {
        Tarefa tarefa = buscarTarefaPorIdInterno(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            System.out.println("Tarefa '" + tarefa.getTitulo() + "' removida com sucesso!");
        } else {
            System.out.println("Erro: Falha ao remover. Nenhum registro com o ID " + id + ".");
        }
    }
}