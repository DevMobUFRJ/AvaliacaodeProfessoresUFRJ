package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina;

/**
 * Created by devmob on 02/06/17.
 */

public class Disciplina {

    private String codigo;
    private String nome;

    public Disciplina(){
        codigo = "";
        nome = "";
    }

    public Disciplina(String id, String nome){
        this.codigo = id;
        this.nome = nome;
    }

    public String getcodigo(){return codigo;}

    public void setCodigo(String codigo){this.codigo = codigo;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome = nome;}


}


