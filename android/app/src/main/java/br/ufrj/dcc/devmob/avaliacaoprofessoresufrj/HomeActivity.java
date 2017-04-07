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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class HomeActivity extends Activity{

    private ListView tela;
    Tag teste = new Tag();
    int click = 0;

    //itens que ficarão na tela
    private String Itens[]={"Joao - Computacao","Mario Ricardo - Geo. Analitica", "Geovana - História da Arte","Joao - Computacao","Mario Ricardo - Geo. Analitica", "Geovana - História da Arte", "Joao - Computacao","Mario Ricardo - Geo. Analitica", "Geovana - História da Arte" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tela = (ListView) findViewById(R.id.LV_tela);

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
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

                //DESATIVADO ENQUANTO NÃO É FEITA A TELA DE VISUALIZAÇÃO DE AVALIAÇÕES//
                if (click == 1) {
                    switch (position) {
                        default:
                            Intent a = new Intent(HomeActivity.this, avaliacao_feitas.class);
                            a.putExtra("Nome_mat", valorclicado);
                            startActivity(a);
                            break;
                    }

                } else {
                    switch (position) {
                        default:
                            Intent a = new Intent(HomeActivity.this, FormActivity.class);
                            a.putExtra("Nome_Mat", valorclicado);
                            startActivity(a);
                            break;
                    }
                }

            }
        });


    }

    }