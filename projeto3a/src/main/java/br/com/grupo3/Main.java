package br.com.grupo3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        TurmaService turmaService = new TurmaService();
        ListaDeAlunos todosAlunos = new ListaDeAlunos(100); // Cadastro geral da escola

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- SISTEMA ESCOLAR ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Turma");
            System.out.println("3. Matricular Aluno em Turma");
            System.out.println("4. Listar Alunos (Ordem Alfabética)");
            System.out.println("5. Listar Turmas");
            System.out.println("6. Alunos Fora da Idade por Etapa");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("CPF: "); String cpf = sc.nextLine();
                    System.out.print("Data Nasc (dd/mm/aaaa): "); String data = sc.nextLine();
                    todosAlunos.incluirNoFim(new Aluno(nome, cpf, "Endereço Padrão", LocalDate.parse(data, dtf)));
                    System.out.println("Aluno cadastrado!");
                    break;

                case 2:
                    System.out.print("Código: "); String cod = sc.nextLine();
                    System.out.print("Etapa (Infantil/Iniciais/Finais/Médio): "); String etapa = sc.nextLine();
                    System.out.print("Ano: "); int ano = sc.nextInt();
                    System.out.print("Vagas: "); int vagas = sc.nextInt();
                    turmaService.adicionarTurma(new Turma(cod, etapa, ano, vagas));
                    break;

                case 3:
                    System.out.print("Nome do Aluno: "); String buscaNome = sc.nextLine();
                    System.out.print("Código da Turma: "); String buscaTurma = sc.nextLine();
                    
                    // Busca simples
                    Aluno alunoEncontrado = null;
                    for(int i=0; i<todosAlunos.tamanho(); i++) {
                        if(todosAlunos.get(i).getNome().equalsIgnoreCase(buscaNome)) {
                            alunoEncontrado = todosAlunos.get(i);
                            break;
                        }
                    }
                    
                    Turma t = turmaService.buscarPorCodigo(buscaTurma);
                    if(alunoEncontrado != null && t != null) {
                        if(t.matricular(alunoEncontrado)) System.out.println("Matriculado!");
                        else System.out.println("Sem vagas!");
                    } else System.out.println("Aluno ou Turma não encontrados.");
                    break;

                case 4:
                    todosAlunos.ordenar();
                    for(int i=0; i<todosAlunos.tamanho(); i++) System.out.println(todosAlunos.get(i));
                    break;

                case 5:
                    turmaService.listarTodasAsTurmas();
                    break;

                case 6:
                    System.out.print("Digite a etapa: "); String e = sc.nextLine();
                    turmaService.contarAlunosForaDaIdadePorEtapa(e);
                    break;
            }
        }
        sc.close();
    }
}