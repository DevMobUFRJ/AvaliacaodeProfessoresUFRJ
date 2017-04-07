package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class avaliacao_feitas extends AppCompatActivity {

    TextView txt_mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_feitas);

        txt_mat = (TextView) findViewById(R.id.txt_mat);
        String NomeMat = getIntent().getStringExtra("Nome_Mat" );
        txt_mat.setText(NomeMat);
    }
}
