package com.example.mainaccount.atvappmaster.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainaccount.atvappmaster.R;

public class MainActivity extends Activity {

    private Button btn_cadastro;
    private Button btn_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cadastro = (Button) findViewById(R.id.btn_cadastro);
        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamarCadastrar = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(chamarCadastrar);
            }
        });

        btn_lista = (Button) findViewById(R.id.btn_lista);
        btn_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamarListar = new Intent(MainActivity.this, ListarActivity.class);
                startActivity(chamarListar);
            }
        });



    }
}
