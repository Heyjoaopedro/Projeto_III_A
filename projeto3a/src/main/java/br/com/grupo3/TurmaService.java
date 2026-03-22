package br.com.grupo3;

import java.util.ArrayList;
import java.util.List;

public class TurmaService {
    private List<Turma> turmas = new ArrayList<>();

    public void adicionarTurma(Turma t) {
        turmas.add(t);
        System.out.println("Turma " + t.getCodigo() + " cadastrada com sucesso!");
    }

    public Turma buscarPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                return t;
            }
        }
        return null;
    }

    public void listarTodasAsTurmas() {
        System.out.println("\n========== RELAÇÃO DE TURMAS ==========");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma t : turmas) {
                System.out.println(t.toString());
            }
        }
        System.out.println("========================================\n");
    }

    public void listarAlunosDaTurma(String codigoTurma) {
        Turma t = buscarPorCodigo(codigoTurma);
        if (t == null) {
            System.out.println("Turma não encontrada.");
            return;
        }
        System.out.println("\n===== ALUNOS DA TURMA " + t.getCodigo() + " =====");
        ListaDeAlunos alunos = t.getAlunosDaTurma();
        if (alunos.tamanho() == 0) {
            System.out.println("Nenhum aluno matriculado nesta turma.");
        } else {
            for (int i = 0; i < alunos.tamanho(); i++) {
                System.out.println(alunos.get(i));
            }
        }
        System.out.println("=====================================\n");
    }

    public void contarAlunosForaDaIdadePorEtapa(String etapaBusca) {
        int totalFora = 0;
        boolean encontrou = false;
        for (Turma t : turmas) {
            if (t.getEtapa().equalsIgnoreCase(etapaBusca.trim())) {
                totalFora += t.contarAlunosForaDaIdade();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma turma encontrada para a etapa: " + etapaBusca);
        } else {
            System.out.println("Total de alunos fora da idade na etapa [" + etapaBusca + "]: " + totalFora);
        }
    }
}
