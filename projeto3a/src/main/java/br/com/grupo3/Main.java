package br.com.grupo3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Turma> turmas = new ArrayList<>();
        ListaDeAlunos todosAlunos = new ListaDeAlunos(100);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU ESCOLA ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Turma");
            System.out.println("3. Listar Alunos (Ordem Alfabética)");
            System.out.println("4. Listar Turmas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: "); String nome = scanner.nextLine();
                    System.out.print("CPF: "); String cpf = scanner.nextLine();
                    
                    todosAlunos.incluirNoFim(new Aluno(nome, cpf, "Rua X", LocalDate.of(2010, 5, 20)));
                    System.out.println("Aluno cadastrado!");
                    break;
                case 3:
                    todosAlunos.ordenar();
                    for(int i=0; i<todosAlunos.tamanho(); i++) System.out.println(todosAlunos.get(i));
                    break;
                case 4:
                    if (turmas.isEmpty()) System.out.println("Vazio.");
                    else for (Turma t : turmas) System.out.println(t);
                    break;
            }
        }
    }
}