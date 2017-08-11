package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
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
    Button btn_voltar;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Tag valores = new Tag();
    static float nota;
    RatingBar rtg_1;
    Avaliacao mAvaliacao = new Avaliacao();
    int[] valor_tag = new int[5];
    int btn = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        mostraValor();

        btn1 = (Button) findViewById(R.id.btn_didatica);
        btn2 = (Button) findViewById(R.id.btn_mat);
        btn3 = (Button) findViewById(R.id.btn_paciencia);
        btn4 = (Button) findViewById(R.id.btn_organizacao);
        btn5 = (Button) findViewById(R.id.btn_comp);
        txt_mat = (TextView) findViewById(R.id.txt_mat);
        btn_prox = (Button) findViewById(R.id.btn_prox);
        comentario = (EditText) findViewById(R.id.edt_com);

        final GradientDrawable btn1Shape = (GradientDrawable)btn1.getBackground();
        final GradientDrawable btn2Shape = (GradientDrawable)btn2.getBackground();
        final GradientDrawable btn3Shape = (GradientDrawable)btn3.getBackground();
        final GradientDrawable btn4Shape = (GradientDrawable)btn4.getBackground();
        final GradientDrawable btn5Shape = (GradientDrawable)btn5.getBackground();
        btn1Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn2Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn3Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn4Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
        btn5Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));


        final Toast[] toast = new Toast[1];

        //mAvaliacao.setMatProf(b.getString("MatProf"));
        //mAvaliacao.setCodigo(b.getString("CODDISC"));

        String NomeMat = getIntent().getStringExtra("Nome_Mat");
        txt_mat.setText(NomeMat);
        if (toast[0] != null) {toast[0].cancel();}

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                btn = 0;
                if (toast[0] != null) {toast[0].cancel();}
                if (valor_tag[btn] == 0) {
                    valor_tag[btn] = 1;
                    btn1Shape.setColor(android.graphics.Color.parseColor("#0fce6d"));
                    btn1.setTextColor(getResources().getColor(R.color.CorFundo));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn1Shape.setColor(android.graphics.Color.parseColor("#ce0f26"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn1Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
                    btn1.setTextColor(getResources().getColor(R.color.black));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                btn = 1;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (valor_tag[btn] == 0) {
                    valor_tag[btn] = 1;
                    btn2Shape.setColor(android.graphics.Color.parseColor("#0fce6d"));
                    btn2.setTextColor(getResources().getColor(R.color.CorFundo));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn2Shape.setColor(android.graphics.Color.parseColor("#ce0f26"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn2Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
                    btn2.setTextColor(getResources().getColor(R.color.black));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                btn = 2;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (valor_tag[btn] == 0) {
                    valor_tag[btn] = 1;
                    btn3Shape.setColor(android.graphics.Color.parseColor("#0fce6d"));
                    btn3.setTextColor(getResources().getColor(R.color.CorFundo));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn3Shape.setColor(android.graphics.Color.parseColor("#ce0f26"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn3Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
                    btn3.setTextColor(getResources().getColor(R.color.black));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                btn = 3;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (valor_tag[btn] == 0) {
                    valor_tag[btn] = 1;
                    btn4Shape.setColor(android.graphics.Color.parseColor("#0fce6d"));
                    btn4.setTextColor(getResources().getColor(R.color.CorFundo));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn4Shape.setColor(android.graphics.Color.parseColor("#ce0f26"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn4Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
                    btn4.setTextColor(getResources().getColor(R.color.black));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                btn = 4;
                if (toast[0] != null){
                    toast[0].cancel();
                }

                if (valor_tag[btn] == 0) {
                    valor_tag[btn] = 1;
                    btn5Shape.setColor(android.graphics.Color.parseColor("#0fce6d"));
                    btn5.setTextColor(getResources().getColor(R.color.CorFundo));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn5Shape.setColor(android.graphics.Color.parseColor("#ce0f26"));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn5Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));
                    btn5.setTextColor(getResources().getColor(R.color.black));
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
                        mAvaliacao.setTags(valor_tag);

                        Toast.makeText(getApplicationContext(), "Sua resposta foi salva", Toast.LENGTH_SHORT).show();
                        if (toast[0] != null) {toast[0].cancel();}
                        finish();

                    }
                 });

    }



    public void mostraValor()
    {
        rtg_1 = (RatingBar) findViewById(R.id.ratingBar);
        rtg_1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar rtg_1, float rating, boolean fromUser) {
                nota = rating;
            }
        });
    }
}
