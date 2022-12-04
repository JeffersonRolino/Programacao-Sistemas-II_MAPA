package entities;

import utils.Utils;

import java.text.ParseException;
import java.time.LocalDate;

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

    @Override
    public String toString() {
        String concatenacao;
        String datas = "Vacinações: \n";
        for (int i = 0; i < this.datasDeVacinacao.length; i++){
            try {
                datas += "\t" + (i + 1) + "ª" + "Dose: " + Utils.formatarData(this.datasDeVacinacao[i]) + "\n";
            } catch (ParseException e) {
                System.out.println("Data não foi formatada com sucesso...");
                throw new RuntimeException(e);
            }
        }
        concatenacao = "Nome: " + this.nome + "\n" + "CPF: " + this.cpf + "\n" + datas;
        return concatenacao;
    }
}
