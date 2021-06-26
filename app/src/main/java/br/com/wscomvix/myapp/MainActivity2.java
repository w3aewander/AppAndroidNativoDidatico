package br.com.wscomvix.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.Inflater;

import br.com.wscomvix.myapp.model.Pessoa;

public class MainActivity2 extends AppCompatActivity {

    private ListView lst;
    private static String item;
    private TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Calendar calendar = Calendar.getInstance();



        Pessoa[] pessoas = {
                new Pessoa("Wanderlei", Utils.fromStringToDate("11/02/1965"), "Analista de Sistemas"),
                new Pessoa("Marileide", Utils.fromStringToDate("13/04/1972"), "Modelista"),
                new Pessoa("Octávio", Utils.fromStringToDate("09/11/2000"), "Estudante"),

        };

        lst = findViewById(R.id.lstUsuarios);
        //Cria um adaptador para os itens da lista
        ListaPessoasAdapter adapter = new ListaPessoasAdapter(
                                         getApplicationContext(),
                                         pessoas);

        lst.setAdapter(adapter);

        txtUser = findViewById(R.id.textView);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pessoa pessoa = adapter.getItem(position);
                item = pessoa.getNome();

                txtUser.setText(item);
            }
        });


    }


    public void entregarResultados(View v) {

        Intent intent = getIntent();

        String nome = item;
        intent.putExtra("nome", nome);

        setResult(RESULT_OK, intent);

        finish();
    }

}