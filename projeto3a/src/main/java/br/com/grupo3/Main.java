package br.com.grupo3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        TurmaService turmaService = new TurmaService();
        ListaDeAlunos todosAlunos = new ListaDeAlunos(100);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- SISTEMA ESCOLAR ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Turma");
            System.out.println("3. Matricular Aluno em Turma");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Listar Turmas");
            System.out.println("6. Alunos Fora da Idade por Etapa");
            System.out.println("7. Listar Alunos de uma Turma");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                    String data = sc.nextLine();
                    try {
                        LocalDate dataNasc = LocalDate.parse(data, dtf);
                        todosAlunos.incluirNoFim(new Aluno(nome, cpf, endereco, dataNasc));
                        System.out.println("Aluno cadastrado com sucesso!");
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida. Use o formato dd/mm/aaaa.");
                    }
                    break;

                case 2:
                    System.out.print("Código da Turma: ");
                    String cod = sc.nextLine();
                    System.out.println("Etapas disponíveis: Infantil | Fundamental Anos Iniciais | Fundamental Anos Finais | Médio");
                    System.out.print("Etapa: ");
                    String etapa = sc.nextLine();
                    System.out.print("Ano: ");
                    try {
                        int ano = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Limite de Vagas: ");
                        int vagas = Integer.parseInt(sc.nextLine().trim());
                        turmaService.adicionarTurma(new Turma(cod, etapa, ano, vagas));
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido para ano ou vagas.");
                    }
                    break;

                case 3:
                    System.out.print("Nome do Aluno: ");
                    String buscaNome = sc.nextLine();
                    System.out.print("Código da Turma: ");
                    String buscaTurma = sc.nextLine();

                    Aluno alunoEncontrado = null;
                    for (int i = 0; i < todosAlunos.tamanho(); i++) {
                        if (todosAlunos.get(i).getNome().equalsIgnoreCase(buscaNome)) {
                            alunoEncontrado = todosAlunos.get(i);
                            break;
                        }
                    }

                    Turma t = turmaService.buscarPorCodigo(buscaTurma);
                    if (alunoEncontrado != null && t != null) {
                        if (t.matricular(alunoEncontrado)) System.out.println("Aluno matriculado com sucesso!");
                        else System.out.println("Turma sem vagas disponíveis!");
                    } else {
                        System.out.println("Aluno ou Turma não encontrados.");
                    }
                    break;

                case 4:
                    if (todosAlunos.tamanho() == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        todosAlunos.ordenar();
                        System.out.println("\n===== ALUNOS (ORDEM ALFABÉTICA) =====");
                        for (int i = 0; i < todosAlunos.tamanho(); i++) {
                            System.out.println(todosAlunos.get(i));
                        }
                        System.out.println("=====================================\n");
                    }
                    break;

                case 5:
                    turmaService.listarTodasAsTurmas();
                    break;

                case 6:
                    System.out.println("Etapas: Infantil | Fundamental Anos Iniciais | Fundamental Anos Finais | Médio");
                    System.out.print("Digite a etapa: ");
                    String e = sc.nextLine();
                    turmaService.contarAlunosForaDaIdadePorEtapa(e);
                    break;

                case 7:
                    System.out.print("Código da Turma: ");
                    String codTurma = sc.nextLine();
                    turmaService.listarAlunosDaTurma(codTurma);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
