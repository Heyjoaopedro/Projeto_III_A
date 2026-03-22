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
        } else {
            System.out.println("Lista cheia! Não foi possível adicionar o aluno.");
        }
    }

    public void incluirNoInicio(Aluno aluno) {
        if (tamanho < elementos.length) {
            for (int i = tamanho; i > 0; i--) {
                elementos[i] = elementos[i - 1];
            }
            elementos[0] = aluno;
            tamanho++;
        } else {
            System.out.println("Lista cheia!");
        }
    }

    public Aluno removerDoFim() {
        if (tamanho > 0) {
            Aluno removido = elementos[tamanho - 1];
            elementos[tamanho - 1] = null;
            tamanho--;
            return removido;
        }
        return null;
    }

    public int tamanho() { return tamanho; }

    public Aluno get(int indice) {
        if (indice >= 0 && indice < tamanho) return elementos[indice];
        return null;
    }

    public void ordenar() {
        // Bubble Sort por nome
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
}
