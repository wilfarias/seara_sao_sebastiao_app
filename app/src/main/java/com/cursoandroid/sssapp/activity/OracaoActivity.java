package com.cursoandroid.sssapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.model.BanhoDeErvas;
import com.cursoandroid.sssapp.model.Oracao;

public class OracaoActivity extends AppCompatActivity {

    private TextView nome_oração;
    private TextView texto_oração;

    private Oracao oracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oracao);

        nome_oração = findViewById(R.id.textView_NomeOracao);
        texto_oração = findViewById(R.id.textView_TextoOracao);

        //Recuperar dados enviados
        Bundle dados = getIntent().getExtras();
        oracao = (Oracao) dados.getSerializable("oracao");

        nome_oração.setText(oracao.getNome());
        texto_oração.setText(oracao.getTexto().replace(";","\n\n"));
    }
}