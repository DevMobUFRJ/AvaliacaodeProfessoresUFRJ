package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno;

/**
 * Created by devmob on 02/06/17.
 */

public class Aluno {

    private String dre;
    private String nome;


    public Aluno(){
        dre = "";
        nome = "";
    }

    public Aluno(String dre, String nome){
        this.dre = dre;
        this.nome = dre;
    }

    public String getDre() {return dre;}

    public void setDre(String dre) {this.dre = dre;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}



}
