package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.curso;

/**
 * Created by georgerappel on 17/10/17.
 */

public class Curso {

    int id;
    String nome;
    int departamento_id;

    public Curso(){
        this.id = 0;
        this.nome = "";
        this.departamento_id = 0;
    }

    public Curso( int id, String nome, int departamento_id ){
        this.id = id;
        this.nome = nome;
        this.departamento_id = departamento_id;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }
}
