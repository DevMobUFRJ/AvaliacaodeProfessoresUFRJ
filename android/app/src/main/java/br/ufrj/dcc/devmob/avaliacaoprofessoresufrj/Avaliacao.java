package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

/**
 * Created by devmob on 24/03/17.
 */

public class Avaliacao{

    private int id;
    private String dreAluno;
    private String matProf;
    private String comentario;
    private float nota;
    private String data;
    private boolean visivel;
    private int[] avaliacao;


    public float setNota(float fNota){

        nota = fNota;
        return nota;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDreAluno() {
        return dreAluno;
    }

    public void setDreAluno(String dreAluno) {
        this.dreAluno = dreAluno;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getNota() {
        return nota;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return visivel;
    }

    public void setStatus(boolean visivel) {
        this.visivel = visivel;
    }

    public int[] getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int[] avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getMatProf() {
        return matProf;
    }

    public void setMatProf(String matProf) {
        this.matProf = matProf;
    }
}
