package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.DisciplinaController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends Activity{

    ProgressBar loadingPanel;
    private ListView tela;
    Tag teste = new Tag();
    int click = 0;

    //itens que ficarão na tela
    private ArrayList<String> itens = new ArrayList<>();
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        itens.add("");
        tela = (ListView) findViewById(R.id.LV_tela);
        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
         adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, itens);

        tela.setAdapter(adaptador);
        tela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int codigotela = position;
                String valorclicado = tela.getItemAtPosition(codigotela).toString();
                //Toast.makeText(getApplicationContext(),valorclicado,Toast.LENGTH_SHORT).show();

                    switch (position) {
                        default:
                            Intent a = new Intent(HomeActivity.this, FormActivity.class);
                            a.putExtra("Nome_Mat", valorclicado);
                            startActivity(a);
                            break;
                    }


            }
        });
        update();

    }

    public void update(){
        DisciplinaController.listarDisciplinas().enqueue(new Callback<List<Disciplina>>() {
            @Override
            public void onResponse(Call<List<Disciplina>> call, Response<List<Disciplina>> response) {
                //Toast.makeText(HomeActivity.this, "Response", Toast.LENGTH_SHORT).show();
                final List<Disciplina> lista = response.body();
                itens = new ArrayList<>();
                for(int i = 0; i < lista.size(); i++) {
                    itens.add(lista.get(i).getcodigo() + " - " + lista.get(i).getNome());
                }
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                adaptador.clear();
                adaptador.addAll(itens);
            }

            @Override
            public void onFailure(Call<List<Disciplina>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}