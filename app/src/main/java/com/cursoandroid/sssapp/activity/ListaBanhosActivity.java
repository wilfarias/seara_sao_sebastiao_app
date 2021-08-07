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
import com.cursoandroid.sssapp.adapter.RecyclerItemClickListener;
import com.cursoandroid.sssapp.model.BanhoDeErvas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaBanhosActivity extends AppCompatActivity {

    private RecyclerView recyclerView_listaBanhos;
    private List<BanhoDeErvas> listaBanhos = new ArrayList<>();

    private DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_banhos);

        recyclerView_listaBanhos = findViewById(R.id.recyclerView_listaBanhos);

        //Acesso ao nó "banhos" no firebase
        DatabaseReference banhoDeErvas = firebaseRef.child( "banhos" );

        banhoDeErvas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Log.i("FIREBASE", postSnapshot.toString());
                    listaBanhos.add(postSnapshot.getValue( BanhoDeErvas.class ));
                }

                //Configurar RecyclerView
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView_listaBanhos.setLayoutManager(layoutManager);
                recyclerView_listaBanhos.setHasFixedSize(true);

                //Define Adapter
                ListaBanhosAdapter listaBanhosAdapter = new ListaBanhosAdapter(listaBanhos);
                recyclerView_listaBanhos.addItemDecoration(new DividerItemDecoration(
                        getApplicationContext(), LinearLayout.VERTICAL)); //insere divisor entre os itens
                recyclerView_listaBanhos.setAdapter(listaBanhosAdapter);

                //Evento de Click
                //Utilização de classe implementada para o evento de click (google)
                recyclerView_listaBanhos.addOnItemTouchListener(
                        new RecyclerItemClickListener(
                                getApplicationContext(),
                                recyclerView_listaBanhos,
                                new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {

                                        //Abre outra activity
                                        Intent intent = new Intent(getApplicationContext(), BanhoDeErvasActivity.class);

                                        //Passar dados para activity
                                        BanhoDeErvas banhoDeErvas = listaBanhos.get(position);
                                        intent.putExtra("banho", banhoDeErvas);
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