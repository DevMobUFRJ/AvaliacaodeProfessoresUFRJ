package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MenuActivity extends Activity implements View.OnClickListener {

    Button btn_avalia;
    Button btn_pesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_avalia = (Button) findViewById(R.id.btn_avaliacoes);
        btn_pesquisa = (Button) findViewById(R.id.btn_pesquisa);

        btn_avalia.setOnClickListener(this);
        btn_pesquisa.setOnClickListener(this);
    }


        public void onClick(View view) {
            switch (view.getId()){
            case R.id.btn_avaliacoes:
                Intent a = new Intent(MenuActivity.this, HomeActivity.class);
                startActivity(a);
                break;
            case R.id.btn_pesquisa:
                Intent b = new Intent(MenuActivity.this, Busca.class);
                startActivity(b);
                break;
            }
        }
}


