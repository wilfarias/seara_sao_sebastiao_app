package com.cursoandroid.sssapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.model.BanhoDeErvas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BanhoDeErvasActivity extends AppCompatActivity {

    private TextView nomeBanho;
    private TextView descricaoBanho;
    private TextView ingredientes;
    private TextView modo_preparo;
    private TextView oracoes;
    private TextView defumacao;

    private BanhoDeErvas banhoDeErvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banho_de_ervas);

        nomeBanho = findViewById(R.id.textView_NomeBanhoDeErvas);
        descricaoBanho = findViewById(R.id.textView_descricaoBanho);
        ingredientes = findViewById(R.id.textView_ingredientesBanho);
        modo_preparo = findViewById(R.id.textView_modoPreparoBanho);
        oracoes = findViewById(R.id.textView_oracoesBanho);
        defumacao = findViewById(R.id.textView_defumacaoBanho);

        //Recuperar dados enviados
        Bundle dados = getIntent().getExtras();
        banhoDeErvas = (BanhoDeErvas) dados.getSerializable("banho");

        nomeBanho.setText(banhoDeErvas.getNome());
        descricaoBanho.setText(banhoDeErvas.getDescricao());
        ingredientes.setText(banhoDeErvas.getIngredientes().replace(";","\n"));
        modo_preparo.setText(banhoDeErvas.getModo_preparo().replace(";","\n\n"));
        oracoes.setText(banhoDeErvas.getOracoes().replace(";","\n"));
        defumacao.setText(banhoDeErvas.getDefumacao());

    }
}