package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.rating;

public class Form1 extends Activity {

    TextView txt_mat;
    Button btn_prox;
    Button btn1;
    RatingBar rtg_1;
    TextView result_1;
    int btn_aux = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        mostraValor();

        btn1 = (Button) findViewById(R.id.Btn1);
        txt_mat = (TextView)findViewById(R.id.txt_mat);
        btn_prox = (Button)findViewById(R.id.btn_prox);

        Bundle b = getIntent().getExtras();
        if(b.containsKey("NOME")){
            String n = b.getString("NOME");
            txt_mat.setText(n);
        }

                btn1.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                btn1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view){
                        if (btn_aux == 0) {
                            btn_aux = 1;
                            btn1.setBackgroundColor(android.graphics.Color.parseColor("#169216"));
                            Toast.makeText(getApplicationContext(), "Didática avaliada como positiva!", Toast.LENGTH_SHORT).show();
                        } else if (btn_aux == 1){
                            btn_aux = 2;
                            btn1.setBackgroundColor(android.graphics.Color.parseColor("#a90606"));
                            Toast.makeText(getApplicationContext(), "Didática avaliada como negativa!", Toast.LENGTH_SHORT).show();
                        } else {
                            btn_aux = 0;
                            btn1.setBackgroundColor(android.graphics.Color.parseColor("#b2a7a7"));
                            Toast.makeText(getApplicationContext(), "Didática avaliada como neutra", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                btn_prox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Sua resposta foi salva", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });

    }
    public void mostraValor()
    {
        rtg_1= (RatingBar) findViewById(R.id.ratingBar);
        result_1= (TextView) findViewById(R.id.Result1_ID);
        //quando o valor é mudado então muda n na tela, isso só serve pra mostrar que os valores já não são somente estrelas
        //já podemos trabalhar com esses valores, armazenando-os em variáveis
        rtg_1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar rtg_1, float rating, boolean fromUser) {
                result_1.setText(String.valueOf(rating));
            }
        });
    }


}
