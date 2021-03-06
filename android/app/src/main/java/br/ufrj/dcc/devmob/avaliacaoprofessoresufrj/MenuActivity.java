package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_avalia;
    Button btn_pesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        btn_avalia = (Button) findViewById(R.id.btn_avaliacoes);
        btn_pesquisa = (Button) findViewById(R.id.btn_pesquisa);

        btn_avalia.setOnClickListener(this);
        btn_pesquisa.setOnClickListener(this);

    }


        public void onClick(View view) {
            switch (view.getId()){
            case R.id.btn_avaliacoes:
                Intent a = new Intent(MenuActivity.this, HomeActivity.class);
                String DRE = getIntent().getStringExtra("DRE");
                a.putExtra("DRE", DRE);
                startActivity(a);
                break;
            case R.id.btn_pesquisa:
                Intent b = new Intent(MenuActivity.this, SearchActivity.class);
                startActivity(b);
                break;
            }
        }
}


