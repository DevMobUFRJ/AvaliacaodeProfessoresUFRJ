package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.DisciplinaController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends Activity{

    private ListView tela;
    Tag teste = new Tag();
    int click = 0;

    //itens que ficarão na tela
    private static String Itens[]={"Aguarde"};

    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tela = (ListView) findViewById(R.id.LV_tela);

         adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                Itens);

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

        DisciplinaController.listarDisciplinas().enqueue(new Callback<List<Disciplina>>() {
            @Override
            public void onResponse(Call<List<Disciplina>> call, Response<List<Disciplina>> response) {
                Toast.makeText(HomeActivity.this, "Response", Toast.LENGTH_LONG).show();
                final List<Disciplina> lista = response.body();
                Itens = new String[lista.size()];
                for(int i = 0; i < lista.size(); i++) {
                    Itens[i] = lista.get(i).getcodigo() + " - " + lista.get(i).getNome();
                }
                ((BaseAdapter)tela.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Disciplina>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });

    }

    }