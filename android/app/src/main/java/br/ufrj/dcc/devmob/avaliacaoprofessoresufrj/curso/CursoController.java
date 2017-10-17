package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.curso;

import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service.HttpService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by georgerappel on 17/10/17.
 */

public class CursoController {

    public static Call<List<Curso>> listarCursos(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        return service.listarCursos();
    }

}
