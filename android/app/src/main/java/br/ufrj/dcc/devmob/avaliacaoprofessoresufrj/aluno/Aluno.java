package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno;

/**
 * Created by devmob on 02/06/17.
 */

public class Aluno {

    private String dre;
    private String nome;
    private int curso_id;

    public Aluno() {
        dre = "";
        nome = "";
        curso_id = 0;
    }

    public Aluno(String dre, String nome, int curso_id) {
        this.dre = dre;
        this.nome = nome;
        this.curso_id = curso_id;
    }

    public String getDre() {
        return dre;
    }

    public String getNome() {
        return nome;
    }

    public int getCursoId() {
        return curso_id;
    }
}
