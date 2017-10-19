package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service.HttpService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by georgerappel on 17/10/17.
 */

public class AlunoController {

    public static Call<Aluno> cadastrarAluno(Aluno aluno) throws java.io.IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);

        return service.cadastrarAluno(aluno.getDre(), aluno.getNome(),
                aluno.getCursoId());
    }

    public static Call<Aluno> getAluno(String dre) throws java.io.IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);

        return service.getAluno(dre);
    }
}
