package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {
    String nome;
    String cpf;
    LocalDate[] datasDeVacinacao = new LocalDate[4];

    //Construtores
    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate[] getDatasDeVacinacao() {
        return datasDeVacinacao;
    }

    public void setDatasDeVacinacao(LocalDate[] datasDeVacinacao) {
        this.datasDeVacinacao = datasDeVacinacao;
    }
}
