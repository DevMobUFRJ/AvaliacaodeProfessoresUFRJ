package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Form1 extends Activity{

    // Substituir depois pelas variaveis globais
    String dreAluno = "115545454";



    EditText comentario;
    TextView txt_mat;
    Button btn_prox;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    static float nota;
    RatingBar rtg_1;
    Avaliacao mAvaliacao = new Avaliacao();
    int[] btn_aux = new int[5];
    int bot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        mostraValor();
        btn1 = (Button) findViewById(R.id.btn_didatica);
        btn2 = (Button) findViewById(R.id.btn_mat);
        btn3 = (Button) findViewById(R.id.btn_paciencia);
        btn4 = (Button) findViewById(R.id.btn_organizacao);
        btn5 = (Button) findViewById(R.id.btn_comp);

        txt_mat = (TextView) findViewById(R.id.txt_mat);
        btn_prox = (Button) findViewById(R.id.btn_prox);
        comentario = (EditText) findViewById(R.id.edt_com);

        final Bundle b = getIntent().getExtras();
        if(b.containsKey("NOME")){
            String n = b.getString("NOME");
            txt_mat.setText(n);
        }

        mAvaliacao.setMatProf(b.getString("MatProf"));
        //mAvaliacao.setId(b.getString("CODDISC"));

        btn1.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
        btn2.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
        btn3.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
        btn4.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
        btn5.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));


        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 0;
                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn1.setBackgroundColor(android.graphics.Color.parseColor("#169216"));
                    Toast.makeText(getApplicationContext(), "Didática avaliada como positiva!", Toast.LENGTH_SHORT).show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn1.setBackgroundColor(android.graphics.Color.parseColor("#a90606"));
                    Toast.makeText(getApplicationContext(), "Didática avaliada como negativa!", Toast.LENGTH_SHORT).show();
                } else {
                    btn_aux[bot] = 0;
                    btn1.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                    Toast.makeText(getApplicationContext(), "Didática avaliada como neutra", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 1;
                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn2.setBackgroundColor(android.graphics.Color.parseColor("#169216"));
                    Toast.makeText(getApplicationContext(), "Material avaliada como positiva!", Toast.LENGTH_SHORT).show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn2.setBackgroundColor(android.graphics.Color.parseColor("#a90606"));
                    Toast.makeText(getApplicationContext(), "Material avaliada como negativa!", Toast.LENGTH_SHORT).show();
                } else {
                    btn_aux[bot] = 0;
                    btn2.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                    Toast.makeText(getApplicationContext(), "Material avaliada como neutra", Toast.LENGTH_SHORT).show();
                }
            }        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 2;
                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn3.setBackgroundColor(android.graphics.Color.parseColor("#169216"));
                    Toast.makeText(getApplicationContext(), "Paciência avaliada como positiva!", Toast.LENGTH_SHORT).show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn3.setBackgroundColor(android.graphics.Color.parseColor("#a90606"));
                    Toast.makeText(getApplicationContext(), "Paciência avaliada como negativa!", Toast.LENGTH_SHORT).show();
                } else {
                    btn_aux[bot] = 0;
                    btn3.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                    Toast.makeText(getApplicationContext(), "Paciência avaliada como neutra", Toast.LENGTH_SHORT).show();
                }
            }        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 3;
                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn4.setBackgroundColor(android.graphics.Color.parseColor("#169216"));
                    Toast.makeText(getApplicationContext(), "Organização avaliada como positiva!", Toast.LENGTH_SHORT).show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn4.setBackgroundColor(android.graphics.Color.parseColor("#a90606"));
                    Toast.makeText(getApplicationContext(), "Organização avaliada como negativa!", Toast.LENGTH_SHORT).show();
                } else {
                    btn_aux[bot] = 0;
                    btn4.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                    Toast.makeText(getApplicationContext(), "Organização avaliada como neutra", Toast.LENGTH_SHORT).show();
                }
            }        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 4;
                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn5.setBackgroundColor(android.graphics.Color.parseColor("#169216"));
                    Toast.makeText(getApplicationContext(), "Compreensão avaliada como positiva!", Toast.LENGTH_SHORT).show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn5.setBackgroundColor(android.graphics.Color.parseColor("#a90606"));
                    Toast.makeText(getApplicationContext(), "Compreensão avaliada como negativa!", Toast.LENGTH_SHORT).show();
                } else {
                    btn_aux[bot] = 0;
                    btn5.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                    Toast.makeText(getApplicationContext(), "Compreensão avaliada como neutra", Toast.LENGTH_SHORT).show();
                }
            }        });



                btn_prox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // Pega nota da avaliação
                        mAvaliacao.setNota(rtg_1.getRating());

                        // Pega descriçãpo
                        String coment = comentario.getText().toString();
                        mAvaliacao.setComentario(coment);

                        // Envia avaliação pro servidor
                        mAvaliacao.setAvaliacao(btn_aux);

                        Toast.makeText(getApplicationContext(), "Sua resposta foi salva", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });

    }


    public void mostraValor()
    {
        rtg_1= (RatingBar) findViewById(R.id.ratingBar);
        //result_1= (TextView) findViewById(R.id.Result1_ID);
        //quando o valor é mudado então muda n na tela, isso só serve pra mostrar que os valores já não são somente estrelas
        //já podemos trabalhar com esses valores, armazenando-os em variáveis
        rtg_1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar rtg_1, float rating, boolean fromUser) {
                //result_1.setText(String.valueOf(rating));
                nota = rating;
            }
        });
    }


}
