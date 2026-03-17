package br.com.grupo3;

public class Turma {
    private String codigo;
    private String etapaEnsino; // infantil, fundamental, médio
    private int ano;
    private int limiteVagas;
    private int numeroMatriculados;

    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.numeroMatriculados = 0; // Começa vazia
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