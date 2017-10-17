package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Cursa;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno.Aluno;

/**
 * Created by devmob on 02/06/17.
 */

public class Cursa {

    private Aluno aluno;
    private String idDiscPeriodo;

    public Cursa() {
        idDiscPeriodo = "";
    }

    public Cursa(Aluno aluno, String idDiscPeriodo) {
        this.aluno = aluno;
        this.idDiscPeriodo = idDiscPeriodo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getIdDiscPeriodo() {
        return idDiscPeriodo;
    }


}
