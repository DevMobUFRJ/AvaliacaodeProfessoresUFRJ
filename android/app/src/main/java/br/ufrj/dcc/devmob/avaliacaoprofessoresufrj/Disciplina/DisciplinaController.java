package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina;

import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service.HttpService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by devmob on 01/08/17.
 */

public class DisciplinaController {

    public static Call<List<Disciplina>> listarDisciplinas(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        return service.listarDisciplinas();
    }
}
