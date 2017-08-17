package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.DisciplinaController;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Docente.Docente;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Docente.DocenteController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Busca extends Activity implements View.OnClickListener {

    private ListView tela;
    ListView busca;
    Button pesquisa;
    EditText text;

    private ArrayList<String> itens = new ArrayList<>();
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);

        busca = (ListView) findViewById(R.id.LV_Busca);
        pesquisa = (Button) findViewById(R.id.btn_pesquisa);
        text = (EditText) findViewById(R.id.text);

        itens.add("");

        tela = (ListView) findViewById(R.id.LV_tela);

        adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, itens);

        busca.setAdapter(adaptador);
        pesquisa.setOnClickListener(this);

//        DisciplinaController.listarDisciplinas().enqueue(new Callback<List<Disciplina>>() {
//            @Override
//            public void onResponse(Call<List<Disciplina>> call, Response<List<Disciplina>> response) {
//                Toast.makeText(Busca.this, "Response", Toast.LENGTH_LONG).show();
//                final List<Disciplina> lista = response.body();
//                itens = new ArrayList<>();
//                for(int i = 0; i < lista.size(); i++) {
//                    itens.add(lista.get(i).getcodigo() + " - " + lista.get(i).getNome());
//                }
//                adaptador.clear();
//                adaptador.addAll(itens);
//            }
//            @Override
//            public void onFailure(Call<List<Disciplina>> call, Throwable t) {
//                Toast.makeText(Busca.this, "Failure", Toast.LENGTH_LONG).show();
//            }
//        });

    }
    public void onClick (View view) {
        switch (view.getId()){
            case R.id.btn_pesquisa:
                String texto = text.getText().toString();
                try {
                    DisciplinaController.buscarDisciplina(texto).enqueue(new Callback<List<Disciplina>>() {
                        @Override
                        public void onResponse(Call<List<Disciplina>> call, Response<List<Disciplina>> response) {
                            Toast.makeText(Busca.this, "Achou Disciplina", Toast.LENGTH_SHORT).show();
                            final List<Disciplina> lista = response.body();
                            itens = new ArrayList<>();
                            for (int i = 0; i < lista.size(); i++) {
                                itens.add(lista.get(i).getcodigo() + " - " + lista.get(i).getNome());
                            }
                            adaptador.clear();
                            adaptador.addAll(itens);
                        }

                        @Override
                        public void onFailure(Call<List<Disciplina>> call, Throwable t) {
                            Toast.makeText(Busca.this, "Não achou disciplina", Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (IOException e){

                }

                    DocenteController.buscarDocente(texto).enqueue(new Callback<List<Docente>>() {
                        @Override
                        public void onResponse(Call<List<Docente>> call, Response<List<Docente>> response) {
                            Toast.makeText(Busca.this, "Achou Docente", Toast.LENGTH_SHORT).show();
                            final List<Docente> lista = response.body();
                            itens = new ArrayList<>();
                            for (int i = 0; i < lista.size(); i++) {
                                itens.add(lista.get(i).getNome());
                            }
                            adaptador.clear();
                            adaptador.addAll(itens);
                        }

                        @Override
                        public void onFailure(Call<List<Docente>> call, Throwable t) {
                            Toast.makeText(Busca.this, "Não achou docente", Toast.LENGTH_SHORT).show();
                        }
                    });

        }

    }
}