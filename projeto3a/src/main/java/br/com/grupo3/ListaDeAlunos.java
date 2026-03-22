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

    // Os dois métodos a seguir não são utilizados no projeto, mas estão aqui para mostrar que sabemos implementá-los.  
    public void incluirNoInicio(Aluno aluno) {
        if (tamanho < elementos.length) {
            // Empurra todo mundo uma casa para a direita
            for (int i = tamanho; i > 0; i--) {
                elementos[i] = elementos[i - 1];
            }
            // indice 0 livre
            elementos[0] = aluno;
            tamanho++;
        } else {
            System.out.println("Lista cheia!");
        }
    }   
    public Aluno removerDoFim() {
        if (tamanho > 0) {
            // Guarda o aluno para retornar no final
            Aluno removido = elementos[tamanho - 1];
            // Limpa a posição
            elementos[tamanho - 1] = null;
            tamanho--;
            return removido;
        }
        return null; // Lista já estava vazia
    }
    //fim dos métodos não utilizados, mas implementados para mostrar conhecimento.

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
}