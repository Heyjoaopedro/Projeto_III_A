package br.com.grupo3;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    private String nome;
    private String cpf;
    private String endereco;
    private LocalDate dataNascimento;

    public Aluno(String nome, String cpf, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
    public LocalDate getDataNascimento() { return dataNascimento; }

    @Override
    public String toString() {
        return String.format("Nome: %-15s | CPF: %-12s | Idade: %d", nome, cpf, getIdade());
    }
}