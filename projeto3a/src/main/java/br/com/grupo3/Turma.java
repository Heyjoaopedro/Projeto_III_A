package br.com.grupo3;

public class Turma {
    private String codigo;
    private String etapaEnsino; // infantil, fundamental, médio
    private int ano;
    private int limiteVagas;
    private int numeroMatriculados;

    // Lista de alunos para cada turma
    private ListaDeAlunos alunosDaTurma;

    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.numeroMatriculados = 0; 
        this.alunosDaTurma = new ListaDeAlunos(limiteVagas); // iniciliza a lista de alunos com o limite de vagas
    }

    //Método para matricular 
    public boolean matricular(Aluno aluno) {
        if (numeroMatriculados < limiteVagas) {
            alunosDaTurma.incluirNoFim(aluno);
            numeroMatriculados++;
            return true;
        }
        return false; // Turma cheia
    }
    

    // Getters básicos
    public String getCodigo() { return codigo; }
    public String getEtapa() { return etapaEnsino; }

    @Override
    public String toString() {
        return String.format("Cód: %s | Etapa: %s | Ano: %d | Vagas: %d/%d", 
            codigo, etapaEnsino, ano, numeroMatriculados, limiteVagas);
    }
}