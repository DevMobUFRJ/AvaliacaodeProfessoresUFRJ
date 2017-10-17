package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina;

/**
 * Created by devmob on 02/06/17.
 */

public class Disciplina {

    private String codigo;
    private String nome;
    private int curso_id;

    public Disciplina() {
        codigo = "";
        nome = "";
        curso_id = 0;
    }

    public Disciplina(String id, String nome, int curso_id) {
        this.codigo = id;
        this.nome = nome;
        this.curso_id = curso_id;
    }

    public String getcodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}


