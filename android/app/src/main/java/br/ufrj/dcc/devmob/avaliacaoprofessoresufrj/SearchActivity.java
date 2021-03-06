package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
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

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView tela;
    Spinner dropdown;
    ListView busca;
    Button pesquisa;
    EditText text;
    private ArrayList<String> itens = new ArrayList<>();
    ArrayAdapter<String> adaptador;
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        dropdown = (Spinner) findViewById(R.id.spinner);
        busca = (ListView) findViewById(R.id.LV_Busca);
        pesquisa = (Button) findViewById(R.id.btn_pesquisa);
        text = (EditText) findViewById(R.id.text);

        String[] escolha = new String[]{"Matéria", "Professor"};
        tela = (ListView) findViewById(R.id.LV_tela);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, escolha);
        dropdown.setAdapter(adapter2);

        adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, itens);
        busca.setAdapter(adaptador);
        pesquisa.setOnClickListener(this);
    }
    public void onClick (View view) {
        switch (view.getId()){
            case R.id.btn_pesquisa:
                hideSoftKeyboard(SearchActivity.this, view);
                adaptador.clear();
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                String texto = text.getText().toString();
                if(dropdown.getSelectedItem().toString().equals("Matéria")){
                    try {
                        DisciplinaController.buscarDisciplina(texto).enqueue(new Callback<List<Disciplina>>() {
                            @Override
                            public void onResponse(Call<List<Disciplina>> call, Response<List<Disciplina>> response) {
                                final List<Disciplina> lista = response.body();
                                itens = new ArrayList<>();
                                if(lista.size() <= 0){
                                    Toast.makeText(SearchActivity.this, "SearchActivity não encontrou nada", Toast.LENGTH_SHORT).show();
                                }else{
                                     for (int i = 0; i < lista.size(); i++){
                                        itens.add(lista.get(i).getcodigo() + " - " + lista.get(i).getNome());
                                     }
                                }
                                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                                adaptador.addAll(itens);
                            }

                            @Override
                            public void onFailure(Call<List<Disciplina>> call, Throwable t) {
                                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                                Toast.makeText(SearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }catch (IOException e){}

                }else if(dropdown.getSelectedItem().toString().equals("Professor")) {
                    DocenteController.buscarDocente(texto).enqueue(new Callback<List<Docente>>() {
                        @Override
                        public void onResponse(Call<List<Docente>> call, Response<List<Docente>> response) {
                            final List<Docente> lista = response.body();
                            itens = new ArrayList<>();
                            if(lista.size() <= 0){
                                Toast.makeText(SearchActivity.this, "SearchActivity não encontrou nada", Toast.LENGTH_SHORT).show();
                            }else{
                                for (int i = 0; i < lista.size(); i++) {
                                    itens.add(lista.get(i).getNome());
                                }
                            }
                            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                            adaptador.addAll(itens);
                        }

                        @Override
                        public void onFailure(Call<List<Docente>> call, Throwable t) {
                            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                            Toast.makeText(SearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        }
    }
    public static void hideSoftKeyboard (Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
}