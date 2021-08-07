package com.cursoandroid.sssapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.adapter.ListaBanhosAdapter;
import com.cursoandroid.sssapp.adapter.ListaOracoesAdapter;
import com.cursoandroid.sssapp.adapter.RecyclerItemClickListener;
import com.cursoandroid.sssapp.model.BanhoDeErvas;
import com.cursoandroid.sssapp.model.Oracao;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaOracoesActivity extends AppCompatActivity {

    private RecyclerView recyclerView_listaOracoes;
    private List<Oracao> listaOracoes = new ArrayList<>();

    private DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_oracoes);

        recyclerView_listaOracoes = findViewById(R.id.recyclerView_listaOracoes);

        //Acesso ao nó "oracoes" no firebase
        DatabaseReference oracoes = firebaseRef.child( "oracoes" );

        oracoes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Log.i("FIREBASE", postSnapshot.toString());
                    listaOracoes.add(postSnapshot.getValue(Oracao.class));
                }

                //Configurar RecyclerView
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView_listaOracoes.setLayoutManager(layoutManager);
                recyclerView_listaOracoes.setHasFixedSize(true);

                //Define Adapter
                ListaOracoesAdapter listaOracoesAdapter = new ListaOracoesAdapter(listaOracoes);
                recyclerView_listaOracoes.addItemDecoration(new DividerItemDecoration(
                        getApplicationContext(), LinearLayout.VERTICAL)); //insere divisor entre os itens
                recyclerView_listaOracoes.setAdapter(listaOracoesAdapter);

                //Evento de Click
                //Utilização de classe implementada para o evento de click (google)
                recyclerView_listaOracoes.addOnItemTouchListener(
                        new RecyclerItemClickListener(
                                getApplicationContext(),
                                recyclerView_listaOracoes,
                                new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {

                                        //Abre outra activity
                                        Intent intent = new Intent(getApplicationContext(), OracaoActivity.class);

                                        //Passar dados para activity
                                        Oracao oracao = listaOracoes.get(position);
                                        intent.putExtra("oracao", oracao);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onLongItemClick(View view, int position) {

                                    }

                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    }
                                }
                        )
                );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*
        //Acesso e recuperação dos dados do banco de dados
        BanhosDAO banhosDAO = new BanhosDAO(getApplicationContext());
        //listaBanhos = banhosDAO.listar();
        listaBanhos = banhosDAO.listar();
        */
    }
}