package com.example.mainaccount.atvappmaster.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mainaccount.atvappmaster.Adapter.LivroAdapter;
import com.example.mainaccount.atvappmaster.Livro;
import com.example.mainaccount.atvappmaster.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListarActivity extends Activity {

    private ListView list;
    private ArrayAdapter<Livro> adapter;
    private ArrayList<Livro> livros;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        livros = new ArrayList<>();
        list = (ListView) findViewById(R.id.list);
        adapter = new LivroAdapter(this, livros);
        list.setAdapter(adapter);

        firebase = FirebaseDatabase.getInstance().getReference();
        firebase = firebase.child("addlivro");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                livros.clear();

                for(DataSnapshot dados : dataSnapshot.getChildren()){
                    Livro novoLivro = dados.getValue(Livro.class);
                    livros.add(novoLivro);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListener);
    }
}
