package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno.Aluno;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.aluno.AlunoController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by georgerappel on 03/10/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    Button autorizar;
    Button signup;
    EditText dreField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autorizar = (Button) findViewById(R.id.autorizarSiga);
        autorizar.setOnClickListener(this);

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);

        dreField = (EditText) findViewById(R.id.login_dre);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.autorizarSiga:
                if( isLoginFormActive() ){
                    userLogin();
                } else {
                    toggleLoginForm();
                }
                break;
            case R.id.signup:
                Intent iSignup = new Intent(this, SignUpActivity.class);
                startActivity(iSignup);
            default:
                break;
        }
    }

    /**
     * Habilita o campo de DRE pra fazer o login e
     * desabilita o botão de cadastro.
     */
    private void toggleLoginForm(){
        if( !isLoginFormActive() ) {
            dreField.setVisibility(View.VISIBLE);
            signup.setVisibility(View.GONE);
        } else {
            dreField.setVisibility(View.GONE);
            signup.setVisibility(View.VISIBLE);
        }
    }

    private boolean isLoginFormActive(){
        return dreField.getVisibility() == View.VISIBLE;
    }

    private void userLogin(){
        String dre = dreField.getText().toString().trim();
        if(Utils.isDreValido(dre)){

            try {
                AlunoController.getAluno(dre).enqueue(new Callback<Aluno>() {
                    @Override
                    public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                        //TODO Salvar o usuário da resposta na aplicação pra sempre
                        Intent i = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Aluno> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Erro na requisição - " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (IOException e) {
                Toast.makeText(this, "Erro na requisição - " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "DRE Inválido", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if( isLoginFormActive() ){
            toggleLoginForm();
        } else {
            super.onBackPressed();
        }
    }
}
