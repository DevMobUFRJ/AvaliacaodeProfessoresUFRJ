package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by georgerappel on 03/10/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    Button autorizar;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autorizar = (Button) findViewById(R.id.autorizarSiga);
        autorizar.setOnClickListener(this);

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.autorizarSiga:
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.signup:
                Intent iSignup = new Intent(this, SignUpActivity.class);
                startActivity(iSignup);
                finish();
            default:
                break;
        }
    }
}
