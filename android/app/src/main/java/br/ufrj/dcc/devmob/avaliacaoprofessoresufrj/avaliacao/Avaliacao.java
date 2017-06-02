package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Utils;

/**
 * Created by devmob on 24/03/17.
 */

public class Avaliacao{

    @SerializedName(value = "_id")
    private String id;
    private String dreAluno;
    private String matProf;
    private String comentario;
    private float nota;
    private Date data;
    private boolean visivel;
    /**
     * Conferir Utils.tags_nomes
     */
    private int[] tags = new int[Utils.tags_count];
    private int dit_valor;

    

    public Avaliacao(){
        dreAluno = "";
        matProf = "";
        comentario = "";
        nota = -1;
        data = new Date();
        data.setTime(System.currentTimeMillis());
        visivel = true;
    }

    /**
     * Construtor padrao ideal para uso na hora de salvar uma avaliacao nova no servidor.
     * @param dreAluno DRE do br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Aluno.Aluno avaliador
     * @param matProf Matricula do Docente avaliado
     * @param comentario Comentario redigido pelo br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Aluno.Aluno avaliador
     * @param nota nota de 0 a 5 dada pelo br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Aluno.Aluno
     */
    public Avaliacao(String dreAluno, String matProf, String comentario, float nota, int[] tags){
        this.id = "";
        this.dreAluno = dreAluno;
        this.matProf = matProf;
        this.comentario = comentario;
        this.nota = nota;
        this.visivel = true;
        this.tags = tags;
    }

    public Avaliacao(String id, String dreAluno, String matProf, String comentario, float nota, Date data, boolean visivel, int[] tags){
        this.id = id;
        this.dreAluno = dreAluno;
        this.matProf = matProf;
        this.comentario = comentario;
        this.nota = nota;
        this.data = data;
        this.visivel = visivel;
        this.tags = tags;
    }

    public float setNota(float fNota){
        nota = fNota;
        return nota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isVisivel() {
        return visivel;
    }

    public int[] getTags() {
        return tags;
    }

    /**
     * Define o valor para cada tag específicada.
     * @param tag tag cujo valor deve ser alterado
     * @param valor 1, 0 ou -1, avaliacao da tag especificada.
     * @return {@code true} se atualizar o valor corretamente. {@code false} se o Valor for inválido.
     */
    public boolean setTag(Utils.tag_docente tag, int valor){
        if(valor > 1 || valor < -1)
            return false;
        tags[tag.getValue()] = valor;
        return true;
    }

    public void setTags(int[] valor){
        int i = 0;
        while (i<5){
            tags[i] = valor[i];
        }

    }


    public String getMatProf() {
        return matProf;
    }

    public void setMatProf(String matProf) {
        this.matProf = matProf;
    }

    public int getDid() {return dit_valor;}

    public void setDidatica (int didatica) { this.dit_valor = didatica;  }


    public String toString(){
        return "DRE: " + this.dreAluno + ". Docente: " + this.matProf + ". Nota: " + this.nota + ". Comentario: " + this.comentario + ". ";
    }

}
