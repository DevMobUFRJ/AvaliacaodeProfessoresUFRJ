package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Tags;

/**
 * Created by devmob on 02/06/17.
 */

public class Tags {

    private String id;
    private String nome;

    public Tags(){
        id = "";
        nome = "";
    }

    public Tags(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getNome(){return nome;}

    public void setNome9(String nome){this.nome = nome;}

}
