package br.com.grupo3;

public class Main {
    public static void main(String[] args) {
        // Instancia do TurmaService
        TurmaService turmaService = new TurmaService();

        // Dados Mockados
        turmaService.adicionarTurma(new Turma("T01", "Infantil", 2026, 15));
        turmaService.adicionarTurma(new Turma("T02", "Médio", 2026, 30));

        // CHAMADA  da listagem de turmas
        turmaService.listarTodasAsTurmas();
    }
}