package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import java.util.Date;

/**
 * Created by devmob on 24/03/17.
 */

public class Avaliacao{

    private int id;
    private String dreAluno;
    private String matProf;
    private String comentario;
    private float nota;
    private Date data;
    private boolean visivel;
    private int[] tags;

    public Avaliacao(){
        dreAluno = "";
        matProf = "";
        comentario = "";
        nota = -1;
        data = new Date();
        data.setTime(System.currentTimeMillis());
        visivel = true;
    }


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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isStatus() {
        return visivel;
    }

    public void setStatus(boolean visivel) {
        this.visivel = visivel;
    }

    public int[] getTags() {
        return tags;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }

    public void addTag(int tagId){
        int[] aux = tags.clone();
        tags = new int[aux.length + 1];
        for(int i = 0; i < aux.length; i++)
            tags[i] = aux[i];
        tags[aux.length + 1] = tagId;
    }

    public String getMatProf() {
        return matProf;
    }

    public void setMatProf(String matProf) {
        this.matProf = matProf;
    }
}
