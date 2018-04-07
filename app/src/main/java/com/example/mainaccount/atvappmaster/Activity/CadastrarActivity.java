package com.example.mainaccount.atvappmaster.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mainaccount.atvappmaster.Livro;
import com.example.mainaccount.atvappmaster.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarActivity extends Activity {

    private Livro livro;
    private EditText editLivro;
    private EditText editAutor;
    private Button btn_cadastrar;
    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editLivro = (EditText)findViewById(R.id.editLivro);
        editAutor = (EditText)findViewById(R.id.editAutor);
        btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livro = new Livro();
                livro.setLivro(editLivro.getText().toString());
                livro.setAutor(editAutor.getText().toString());

                salvarLivro(livro);
            }
        });

    }

    private boolean salvarLivro(Livro livro){
        try{
            firebase = FirebaseDatabase.getInstance().getReference();
            firebase = firebase.child("addlivro");
            firebase.child(livro.getLivro()).setValue(livro);
            Toast.makeText(CadastrarActivity.this,"Cadastrado efetuado", Toast.LENGTH_SHORT).show();

            Intent pagInicial = new Intent(CadastrarActivity.this, MainActivity.class);
            startActivity(pagInicial);

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
