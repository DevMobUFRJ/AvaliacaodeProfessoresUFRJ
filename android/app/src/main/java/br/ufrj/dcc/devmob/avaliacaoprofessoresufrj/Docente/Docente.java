package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Docente;

/**
 * Created by devmob on 02/06/17.
 */

public class Docente {

    private String id;
    private String nome;

    public Docente(){
        id = "";
        nome = "";
    }

    public Docente(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome = nome;}

}
