package br.com.wscomvix.myapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ThemeUtils;


import br.com.wscomvix.myapp.model.Pessoa;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

public class ListaPessoasAdapter extends ArrayAdapter<Pessoa>  {

    private final int REQUEST_CAMERA = 10000;

    public ListaPessoasAdapter(@NonNull Context context,  @NonNull Pessoa[] objects) {
        super(context,R.layout.item_layout,objects);

    }

    @Nullable
    @Override
    public Pessoa getItem(int position) {
        return super.getItem(position);
    }

    /**
     * Este método percorre cada linha da lista e infla o layout na linha para cada item.
     * @author Wanderlei Silva do Carmo <wander.silva@gmail.com>
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pessoa pessoa = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }
        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtDataNascimento = convertView.findViewById(R.id.txtDataNascimento);
        TextView txtProfissao = convertView.findViewById(R.id.txtProfissao);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Button alterarFoto = convertView.findViewById(R.id.alterarFoto);

        alterarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Testando...", Toast.LENGTH_LONG).show();
            }
        });

        txtNome.setText(pessoa.getNome());
        String format = Utils.fromDateToString(pessoa.getDataNascimento());
        txtDataNascimento.setText(format);
        txtProfissao.setText(pessoa.getProfissao());

        return convertView;
    }
}
