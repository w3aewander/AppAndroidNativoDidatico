package br.com.wscomvix.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class FluxoCaixa extends AppCompatActivity {

    private static ListView contasFixas;
    private static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluxo_caixa);

        contasFixas = findViewById(R.id.contasFixas);

        contasFixas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                message = contasFixas.getItemAtPosition(position).toString();
                Button btRetornar = findViewById(R.id.btnRetornar);
                btRetornar.setText(message);

            }
        });

    }

    public void retornarConta(View v){

        Intent intent = getIntent();
        intent.putExtra("message", message);

        setResult(RESULT_OK, intent);

        finish();
    }
}