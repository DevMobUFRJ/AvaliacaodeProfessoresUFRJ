package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

    Button btn_avalia= (Button) findViewById(R.id.btn_avaliacoes);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

}
