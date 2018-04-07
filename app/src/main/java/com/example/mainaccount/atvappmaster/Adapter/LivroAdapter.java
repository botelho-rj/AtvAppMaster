package com.example.mainaccount.atvappmaster.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mainaccount.atvappmaster.Livro;
import com.example.mainaccount.atvappmaster.R;

import java.util.ArrayList;
import java.util.List;

public class LivroAdapter extends ArrayAdapter<Livro>{

    private ArrayList<Livro> livros;
    private Context contexto;


    public LivroAdapter(Context context,ArrayList<Livro> objects) {
        super(context, 0, objects);
        this.contexto = context;
        this.livros = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.listalivro, parent, false);

        TextView txtLivro = (TextView) view.findViewById(R.id.txtLivro);
        TextView txtAutor = (TextView) view.findViewById(R.id.txtAutor);

        Livro livro = livros.get(position);

        txtLivro.setText("Livro: "+livro.getLivro());
        txtAutor.setText("Autor: "+livro.getAutor());

        return view;
    }
}
