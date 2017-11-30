package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service;

import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Docente.Docente;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno.Aluno;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao.Avaliacao;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.curso.Curso;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by devmob on 06/04/17.
 */

public interface HttpService {

    String baseURL = "https://stormy-lake-48687.herokuapp.com/";

    @Headers({"Accept:application/json", "Cache-Control: max-age=640000"})
    @GET("avaliacao/aluno/{dre}")
    Call<List<Avaliacao>> listarAvaliacoes(@Path("dre") String dreAluno);

    @Headers({
            "Accept:application/json",
            "Cache-Control: max-age=640000"
    })
    @GET("avaliacao/docente/{mat}")
    Call<List<Avaliacao>> listarAvaliacoesDocente(@Path("mat") String matProf);

    @FormUrlEncoded
    @POST("avaliacao")
    Call<Avaliacao> salvarAvaliacao(
            @Field("aluno_dre")String aluno_dre,
            @Field("disciplina_periodo_id")String disciplina_periodo_id,
            @Field("comentario")String comentario,
            @Field("status")Boolean status,
            @Field("nota")float nota );


    @Headers({"Accept:application/json", "Cache-Control: max-age=640000"})
    @GET("disciplina")
    Call<List<Disciplina>> listarDisciplinas();

    @Headers({"Accept:application/json", "Cache-Control: max-age=640000"})
    @GET("curso")
    Call<List<Curso>> listarCursos();

    @GET("disciplina")
    Call<List<Disciplina>> buscarDisciplina(@Query("q") String q);

    @GET("docente")
    Call<List<Docente>> buscarDocente(@Query("q") String q);

    @FormUrlEncoded
    @POST("aluno")
    Call<Aluno> cadastrarAluno(
            @Field("dre") String dre,
            @Field("nome") String nome,
            @Field("curso_id") int curso_id );

    @Headers({"Accept:application/json", "Cache-Control: max-age=640000"})
    @GET("aluno/{dre}")
    Call<Aluno> getAluno(@Path("dre")String dre);
}
