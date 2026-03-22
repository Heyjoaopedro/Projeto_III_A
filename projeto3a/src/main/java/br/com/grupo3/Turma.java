package br.com.grupo3;

public class Turma {
    private String codigo;
    private String etapaEnsino;
    private int ano;
    private int limiteVagas;
    private int numeroMatriculados;
    private ListaDeAlunos alunosDaTurma;

    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.numeroMatriculados = 0;
        this.alunosDaTurma = new ListaDeAlunos(limiteVagas);
    }

    public boolean matricular(Aluno aluno) {
        if (numeroMatriculados < limiteVagas) {
            alunosDaTurma.incluirNoFim(aluno);
            numeroMatriculados++;
            return true;
        }
        return false;
    }

    public int contarAlunosForaDaIdade() {
        int contador = 0;
        for (int i = 0; i < alunosDaTurma.tamanho(); i++) {
            Aluno a = alunosDaTurma.get(i);
            int idade = a.getIdade();
            String etapa = this.etapaEnsino.toLowerCase().trim();

            boolean fora = false;
            if (etapa.equals("infantil") && idade >= 6) fora = true;
            else if (etapa.equals("fundamental anos iniciais") && (idade < 6 || idade > 11)) fora = true;
            else if (etapa.equals("fundamental anos finais") && (idade < 11 || idade > 15)) fora = true;
            else if (etapa.equals("médio") || etapa.equals("medio")) {
                if (idade < 15 || idade > 18) fora = true;
            }

            if (fora) contador++;
        }
        return contador;
    }

    public String getCodigo() { return codigo; }
    public String getEtapa() { return etapaEnsino; }
    public int getNumeroMatriculados() { return numeroMatriculados; }
    public ListaDeAlunos getAlunosDaTurma() { return alunosDaTurma; }

    @Override
    public String toString() {
        return String.format("Cód: %-5s | Etapa: %-25s | Ano: %d | Vagas: %d/%d",
            codigo, etapaEnsino, ano, numeroMatriculados, limiteVagas);
    }
}
