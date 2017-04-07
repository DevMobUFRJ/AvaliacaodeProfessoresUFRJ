package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao.Avaliacao;

public class FormActivity extends Activity{

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
    Tag teste = new Tag();
    int click = teste.getClique();

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
        final Toast[] toast = new Toast[1];

        txt_mat = (TextView) findViewById(R.id.txt_mat);
        btn_prox = (Button) findViewById(R.id.btn_prox);
        comentario = (EditText) findViewById(R.id.edt_com);

        //mAvaliacao.setMatProf(b.getString("MatProf"));
        //mAvaliacao.setId(b.getString("CODDISC"));


        String NomeMat = getIntent().getStringExtra("Nome_Mat");
        txt_mat.setText(NomeMat);
        btn1.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn2.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn3.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn4.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn5.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
        if (toast[0] != null){
            toast[0].cancel();
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                bot = 0;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn1.setBackgroundColor(android.graphics.Color.parseColor("#66BB6A"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn1.setBackgroundColor(android.graphics.Color.parseColor("#EF5350"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    btn_aux[bot] = 0;
                    btn1.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                bot = 1;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn2.setBackgroundColor(android.graphics.Color.parseColor("#66BB6A"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn2.setBackgroundColor(android.graphics.Color.parseColor("#EF5350"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    btn_aux[bot] = 0;
                    btn2.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                bot = 2;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn3.setBackgroundColor(android.graphics.Color.parseColor("#66BB6A"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn3.setBackgroundColor(android.graphics.Color.parseColor("#EF5350"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    btn_aux[bot] = 0;
                    btn3.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 3;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn4.setBackgroundColor(android.graphics.Color.parseColor("#66BB6A"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn4.setBackgroundColor(android.graphics.Color.parseColor("#EF5350"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    btn_aux[bot] = 0;
                    btn4.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                bot = 4;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (btn_aux[bot] == 0) {
                    btn_aux[bot] = 1;
                    btn5.setBackgroundColor(android.graphics.Color.parseColor("#66BB6A"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (btn_aux[bot] == 1){
                    btn_aux[bot] = -1;
                    btn5.setBackgroundColor(android.graphics.Color.parseColor("#EF5350"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    btn_aux[bot] = 0;
                    btn5.setBackgroundColor(android.graphics.Color.parseColor("#BDBDBD"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
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
                        mAvaliacao.setTags(btn_aux);

                        Toast.makeText(getApplicationContext(), "Sua resposta foi salva", Toast.LENGTH_SHORT).show();
                        if (toast[0] != null){
                            toast[0].cancel();
                        }
                        click = 1;
                        teste.setClique(click);
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
