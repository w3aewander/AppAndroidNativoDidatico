package br.com.wscomvix.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.wscomvix.myapp.R;

public class MainActivity2 extends AppCompatActivity  {

    private ListView lst ;
    private static String item;
    private TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lst = findViewById(R.id.lstUsuarios);
        txtUser = findViewById(R.id.textView);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = lst.getItemAtPosition(position).toString();
                txtUser.setText(item);
            }
        });
    }

    public void entregarResultados(View v) {

        Intent intent = getIntent();

        String nome = item;
        intent.putExtra("nome",nome);

        setResult(RESULT_OK, intent);

        finish();
    }

}