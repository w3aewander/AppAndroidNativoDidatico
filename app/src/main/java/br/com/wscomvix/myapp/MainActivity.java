package br.com.wscomvix.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.wscomvix.myapp.R;

public class MainActivity extends AppCompatActivity {

    private final int  REQUEST_CAMERA = 10000;
    private final int REQUEST_USER = 20000;
    private final int REQUEST_CONTAS_FIXAS = 30000;

    private TextView textUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUser = findViewById(R.id.resultado);
    }

    public void sair(View v){

        View dialogo = getLayoutInflater().inflate(R.layout.dialogo, null);


        Boolean confirmaSair = false;

        Dialog dialog = new Dialog(this);
        dialog.setTitle("Sair da aplicação");

        dialog.setCancelable(true);

        dialog.setContentView(dialogo);
        Button btDialogoSair = dialogo.findViewById(R.id.btFecharDialogoSair);
        btDialogoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Toast.makeText(v.getContext(),"Tchaw, até a próxima", Toast.LENGTH_LONG).show();
               MainActivity.super.finish();
            }
        });
       Button btCancelar = dialogo.findViewById(R.id.btCancelar);
       btCancelar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });

        //dialog.create();
        dialog.show();


    }
    public void obterUsuario(View v){
        startActivityForResult(new Intent(MainActivity.this, MainActivity2.class), REQUEST_USER);
    }
    public void abrirForResults(View v){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, REQUEST_CAMERA);

    }

    public void abrirContasFixas(View v){
        startActivityForResult(new Intent(MainActivity.this, FluxoCaixa.class), REQUEST_CONTAS_FIXAS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){

            Toast.makeText(this, "Recebido resultado", Toast.LENGTH_LONG).show();
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);

        } else if ( requestCode == REQUEST_USER && resultCode == RESULT_OK ) {

            //Toast.makeText(this, "Usuário recebido: " + data.getStringExtra("nome"), Toast.LENGTH_LONG).show();
            textUser.setText(data.getStringExtra("nome"));
        } else if ( requestCode == REQUEST_CONTAS_FIXAS && resultCode == RESULT_OK){

            textUser.setText(data.getStringExtra("message"));
        } else {

            //Toast.makeText(this, "Nenhuma dado ou foto.", Toast.LENGTH_LONG).show();
            textUser.setText(data.getStringExtra("nome"));
        }
    }
}