package br.com.grupo3.service;

import br.com.grupo3.model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaService {
    private List<Turma> turmas = new ArrayList<>();

    // Método para adicionar 
    public void adicionarTurma(Turma t) {
        turmas.add(t);
    }

    //Método de listagem
    public void listarTodasAsTurmas() {
        System.out.println("\n========== RELAÇÃO DE TURMAS ==========");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma t : turmas) {
                System.out.println(t.toString());
            }
        }
        System.out.println("=======================================\n");
    }
}