package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service;

import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao.Avaliacao;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by devmob on 06/04/17.
 */

public interface HttpService {

    public static String baseURL = "https://stormy-lake-48687.herokuapp.com/";

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
            @Field("dreAluno")String dreAluno,
            @Field("matProf")String matProf,
            @Field("comentario")String comentario,
            @Field("nota")float nota,
            @Field("tags")int[] tags );


    @Headers({"Accept:application/json", "Cache-Control: max-age=640000"})
    @GET("disciplina")
    Call<List<Disciplina>> listarDisciplinas();
}
