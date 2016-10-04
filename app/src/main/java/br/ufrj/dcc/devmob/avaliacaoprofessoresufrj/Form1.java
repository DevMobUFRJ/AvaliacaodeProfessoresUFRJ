package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Form1 extends AppCompatActivity {

    TextView txt_mat;
    Button btn_prox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        txt_mat = (TextView)findViewById(R.id.txt_mat);
        btn_prox = (Button)findViewById(R.id.btn_prox);

        Bundle b = getIntent().getExtras();
        if(b.containsKey("NOME")){
            String n = b.getString("NOME");
            txt_mat.setText(n);
        }
    }
}
