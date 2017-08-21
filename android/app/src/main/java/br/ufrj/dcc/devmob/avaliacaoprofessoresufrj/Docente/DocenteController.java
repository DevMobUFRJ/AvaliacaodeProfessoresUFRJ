package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Docente;

import java.util.List;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao.Avaliacao;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service.HttpService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gabriel on 17/08/2017.
 */

public class DocenteController {

    public static Call<List<Docente>> buscarDocente(String dc) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        return service.buscarDocente(dc);
    }
}
