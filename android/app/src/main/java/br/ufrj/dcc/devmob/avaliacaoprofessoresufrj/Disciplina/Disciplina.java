package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina;

/**
 * Created by devmob on 02/06/17.
 */

public class Disciplina {

    private String id;
    private String nome;

    public Disciplina(){
        id = "";
        nome = "";
    }

    public Disciplina(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome = nome;}


}


