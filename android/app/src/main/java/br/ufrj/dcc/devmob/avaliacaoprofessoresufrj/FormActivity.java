package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
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
        btn_voltar = (Button) findViewById(R.id.btn_voltar);
        comentario = (EditText) findViewById(R.id.edt_com);

        final GradientDrawable btn1Shape = (GradientDrawable)btn1.getBackground();
        final GradientDrawable btn2Shape = (GradientDrawable)btn2.getBackground();
        final GradientDrawable btn3Shape = (GradientDrawable)btn3.getBackground();
        final GradientDrawable btn4Shape = (GradientDrawable)btn4.getBackground();
        final GradientDrawable btn5Shape = (GradientDrawable)btn5.getBackground();
        btn1Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
        btn2Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
        btn3Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
        btn4Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
        btn5Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));

        //btn5Shape.setColor(android.graphics.Color.parseColor("#BDBDBD"));


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
                    btn1Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.positiva, null));
                    btn1.setTextColor(ResourcesCompat.getColor(getResources(), R.color.CorFundo, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn1Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.negativa, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Didática avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn1Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
                    btn1.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
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
                    btn2Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.positiva, null));
                    btn2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.CorFundo, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn2Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.negativa, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Material avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn2Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
                    btn2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
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
                    btn3Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.positiva, null));
                    btn3.setTextColor(ResourcesCompat.getColor(getResources(), R.color.CorFundo, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn3Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.negativa, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Paciência avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn3Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
                    btn3.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
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
                    btn4Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.positiva, null));
                    btn4.setTextColor(ResourcesCompat.getColor(getResources(), R.color.CorFundo, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn4Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.negativa, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Organização avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn4Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
                    btn4.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
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
                    btn5Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.positiva, null));
                    btn5.setTextColor(ResourcesCompat.getColor(getResources(), R.color.CorFundo, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como positiva!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else if (valor_tag[btn] == 1){
                    valor_tag[btn] = -1;
                    btn5Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.negativa, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como negativa!", Toast.LENGTH_SHORT);
                    toast[0].show();
                } else {
                    valor_tag[btn] = 0;
                    btn5Shape.setColor(ResourcesCompat.getColor(getResources(), R.color.neutra, null));
                    btn5.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
                    toast[0] = Toast.makeText(getApplicationContext(), "Compreensão avaliada como neutra", Toast.LENGTH_SHORT);
                    toast[0].show();
                }
            }        });

        btn_prox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Pega nota da avaliação
                        //mAvaliacao.setNota(rtg_1.getRating());

                        // Pega descriçãpo
                        //String coment = comentario.getText().toString();
                        //mAvaliacao.setComentario(coment);

                        // Envia avaliação pro servidor
                        //mAvaliacao.setTags(valor_tag);

                        Toast.makeText(getApplicationContext(), "Sua resposta foi salva", Toast.LENGTH_SHORT).show();
                        if (toast[0] != null) {toast[0].cancel();}
                        finish();

                    }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
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
