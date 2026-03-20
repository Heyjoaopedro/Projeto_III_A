package br.com.grupo3;

public class ListaDeAlunos {
    private Aluno[] elementos;
    private int tamanho;

    public ListaDeAlunos(int capacidade) {
        this.elementos = new Aluno[capacidade];
        this.tamanho = 0;
    }

    public void incluirNoFim(Aluno aluno) {
        if (tamanho < elementos.length) {
            elementos[tamanho] = aluno;
            tamanho++;
        }
    }

    public int tamanho() { return tamanho; }

    public Aluno get(int indice) {
        if (indice >= 0 && indice < tamanho) return elementos[indice];
        return null;
    }

    public void ordenar() {
        // Bubble Sort 
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (elementos[j].getNome().compareToIgnoreCase(elementos[j+1].getNome()) > 0) {
                    Aluno temp = elementos[j];
                    elementos[j] = elementos[j+1];
                    elementos[j+1] = temp;
                }
            }
        }
    }
    // Fazer o incluirNoInicio e removerDoFim se sobrar tempo, 
    // mas o 'incluirNoFim' e 'ordenar' são os motores do projeto.
}