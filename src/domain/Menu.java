package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Task> pendingTasks = new ArrayList<>();
    ArrayList<Task> completedTasks = new ArrayList<>();

    public void menuText(){
        System.out.println("1 - Adicionar uma nova tarefa \n2 - Listar tarefas \n3 - Marcar tarefa como concluida \n4 - Remover tarefa \n5 - Editar tarefa \n0 - Encerrar o programa");
    }

    public void startMenu(){
        boolean loop = true;

        while (loop){
            menuText();
            System.out.println("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    addTask();
                    break;

                case 2:
                    listTasks();
                    break;

                case 3:
                    markTaskAsCompleted();
                    break;

                case 4:
                    removeTask();
                    break;

                case 5:
                    editTask();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    loop = false;
            }
        }
    }

    public void addTask(){
        scanner.nextLine();

        System.out.println("Digite o nome da tarefa: ");
        String name = scanner.nextLine();

        System.out.println("Digite uma descrição para essa tarefa: ");
        String description = scanner.nextLine();

        System.out.println("Digite a prioridade dessa tarefa (baixa, média, alta): ");
        String priority = scanner.nextLine();

        System.out.println("Tarefa adicionada a lista!");

        Task task = new Task(name, description, priority);
        pendingTasks.add(task);
    }

    public void listTasks(){
        System.out.println("1 - Tarefas pendentes \n2 - Tarefas concluídas");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                for (Task task : pendingTasks){
                    System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getPriority());
                }
                break;

            case 2:
                for (Task task : completedTasks){
                    System.out.println(task.getTitle());
                }
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void markTaskAsCompleted(){
        for (Task task : pendingTasks){
            System.out.println(task.getTaskId() + " " + task.getTitle());
        }

        System.out.println("Digite o ID da tarefa que deseja marcar como concluída: ");
        int id = scanner.nextInt();
        boolean found = false;

        Iterator<Task> iterator = pendingTasks.iterator();
        while (iterator.hasNext()){
            Task task = iterator.next();

            if (task.getTaskId() == id){
                task.setStatus(true);
                completedTasks.add(task);
                iterator.remove();
                System.out.println("Tarefa marcada como concluída.");
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void removeTask(){
        for (Task task : pendingTasks){
            System.out.println(task.getTaskId() + " " + task.getTitle());
        }

        System.out.println("Digite o ID da tarefa que deseja remover: ");
        int id = scanner.nextInt();
        boolean found = false;

        Iterator<Task> iterator = pendingTasks.iterator();
        while (iterator.hasNext()){
            Task task = iterator.next();

            if (task.getTaskId() == id){
                iterator.remove();
                System.out.println("Tarefa removida.");
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void editTask(){
        System.out.println("1 - Editar o nome da tarefa \n2 - Editar prioridade da tarefa");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                for (Task task : pendingTasks){
                    System.out.println(task.getTaskId() + " " + task.getTitle());
                }

                System.out.println("Digite o ID da tarefa que deseja alterar o nome: ");
                int id = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Digite o novo nome: ");
                String name = scanner.nextLine();

                boolean found = false;

                Iterator<Task> iterator = pendingTasks.iterator();
                while (iterator.hasNext()){
                    Task task = iterator.next();

                    if (task.getTaskId() == id){
                        task.setTitle(name);
                        System.out.println("Tarefa renomeada.");
                        found = true;
                        break;
                    }
                }

                if (!found){
                    System.out.println("Tarefa não encontrada.");
                }
                break;

            case 2:
                for (Task task : pendingTasks){
                    System.out.println(task.getTaskId() + " " + task.getTitle());
                }

                System.out.println("Digite o ID da tarefa que deseja alterar o nome: ");
                int ID = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Digite a nova prioridade: ");
                String priority = scanner.nextLine();

                boolean isFound = false;

                Iterator<Task> iterator1 = pendingTasks.iterator();
                while (iterator1.hasNext()){
                    Task task = iterator1.next();

                    if (task.getTaskId() == ID){
                        task.setPriority(priority);
                        System.out.println("Alteração de prioridade com sucesso.");
                        isFound = true;
                        break;
                    }
                }

                if (!isFound){
                    System.out.println("Tarefa não encontrada.");
                }

                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
