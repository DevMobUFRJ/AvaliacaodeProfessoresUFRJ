package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno.Aluno;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno.AlunoController;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.curso.Curso;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.curso.CursoController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by georgerappel on 17/10/17.
 */

public class SignUpActivity extends AppCompatActivity {

    EditText dre;
    EditText nome;
    Spinner sCurso;

    List<Curso> lista;
    List<String> nomesCurso = new ArrayList<String>();

    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dre = (EditText) findViewById(R.id.signup_dre);
        nome = (EditText) findViewById(R.id.signup_nome);
        sCurso = (Spinner) findViewById(R.id.signup_curso_id);


        finish = (Button) findViewById(R.id.signup_finish);

        nome.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    switch (i){
                        case KeyEvent.KEYCODE_ENTER:
                            finish.callOnClick();
                            return true;
                            default:
                                break;
                    }
                }
                return false;
            }
        });


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = new Aluno(dre.getText().toString().trim(),
                        nome.getText().toString().trim(), lista.get(sCurso.getSelectedItemPosition()).getId());
                try {
                    AlunoController.cadastrarAluno(aluno).enqueue(new Callback<Aluno>() {
                        @Override
                        public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                            Toast.makeText(SignUpActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<Aluno> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "Erro na requisição", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (IOException e){
                    Toast.makeText(SignUpActivity.this, "Erro no cadastro, Tente novamente", Toast.LENGTH_LONG).show();
                }
            }
        });

        CursoController.listarCursos().enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                lista = response.body();
                if(lista != null)
                    for(Curso c : lista){
                        nomesCurso.add(c.getNome());
                    }
                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SignUpActivity.this, android.R.layout.simple_spinner_item, nomesCurso);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                sCurso.setAdapter(adapter);
                Toast.makeText(SignUpActivity.this, "Lista preenchida com sucesso", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Erro ao preencher a lista", Toast.LENGTH_SHORT).show();
            }
        });

        sCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.w("Item selecionado: ", "id: " + id + " | Posicao: " + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
