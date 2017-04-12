package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by georgerappel on 03/10/16.
 */
public class MainActivity extends Activity implements View.OnClickListener{
    Button autorizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autorizar = (Button)findViewById(R.id.autorizarSiga);
        autorizar.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.autorizarSiga:
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
                finish();
                break;
            default:
                break;
        }
    }
}
