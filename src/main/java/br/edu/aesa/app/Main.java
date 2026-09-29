package br.edu.aesa.app;

import br.edu.aesa.service.TarefaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaService service = new TarefaService();
        int opcao = -1;

        System.out.println("Bem-vindo(a) ao Gerenciador de Tarefas!");

        while (opcao != 0) {
            System.out.println("\n========= MENU =========");
            System.out.println("[1] Cadastrar novo registro");
            System.out.println("[2] Listar todos os registros");
            System.out.println("[3] Buscar registro por ID");
            System.out.println("[4] Atualizar registro");
            System.out.println("[5] Remover registro");
            System.out.println("[0] Sair do programa");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a prioridade (Alta/Media/Baixa): ");
                    String prioridade = scanner.nextLine();
                    System.out.print("Digite o status (Pendente/Concluida): ");
                    String status = scanner.nextLine();
                    service.cadastrar(titulo, prioridade, status);
                    break;
                case 2:
                    service.listarTodos();
                    break;
                case 3:
                    System.out.print("Digite o ID para buscar: ");
                    int idBusca = Integer.parseInt(scanner.nextLine());
                    service.buscarPorId(idBusca);
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa que deseja atualizar: ");
                    int idAtualizar = Integer.parseInt(scanner.nextLine());
                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Nova prioridade: ");
                    String novaPrioridade = scanner.nextLine();
                    System.out.print("Novo status: ");
                    String novoStatus = scanner.nextLine();
                    service.atualizar(idAtualizar, novoTitulo, novaPrioridade, novoStatus);
                    break;
                case 5:
                    System.out.print("Digite o ID da tarefa que deseja remover: ");
                    int idRemover = Integer.parseInt(scanner.nextLine());
                    service.remover(idRemover);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}