package com.cursoandroid.sssapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.adapter.MenuAdapter;
import com.cursoandroid.sssapp.adapter.RecyclerItemClickListener;
import com.cursoandroid.sssapp.model.BanhoDeErvas;
import com.cursoandroid.sssapp.model.MenuOpcoes;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView menuPrincipal_recyclerView;
    private List<MenuOpcoes> menuOpcoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        menuPrincipal_recyclerView = findViewById(R.id.menuPrincipal);

        //Define Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        menuPrincipal_recyclerView.setLayoutManager(layoutManager);

        //Define Adapter
        this.buildMenu(); //constroi o menu manualmente -> mudar para banco de dados futuramente
        MenuAdapter menuAdapter = new MenuAdapter(menuOpcoes);
        menuPrincipal_recyclerView.setAdapter(menuAdapter);

        menuPrincipal_recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                menuPrincipal_recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = null;
                        switch (position) {
                            case 0:
                                Log.i("FIREBASE", String.valueOf(position));
                                intent = new Intent(getApplicationContext(), ListaBanhosActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Log.i("FIREBASE", String.valueOf(position));
                                intent = new Intent(getApplicationContext(), ListaOracoesActivity.class);
                                startActivity(intent);
                                break;
                            /*case 3:
                                intent = new Intent(getApplicationContext(), ListaOrixasActivity.class);
                                startActivity(intent);
                                break;
                            */
                            default:
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }

    public void buildMenu(){

        MenuOpcoes opcaoMenu = new MenuOpcoes("Banhos de Ervas", "Os banhos ritualísticos de uma maneira geral, " +
                "são rituais, onde utilizamos determinados elementos da natureza, de maneira ordenada e com " +
                "conhecimento de causa, com o intuito de troca energética entre o indivíduo e a natureza, afim " +
                "de fornecer-lhe equilíbrio energético e mental.", R.drawable.imagem_banho_ervas);
        menuOpcoes.add(opcaoMenu);

        opcaoMenu = new MenuOpcoes("Orações", "Orar é expressar aquilo que o coração emana e a mente deseja " +
                "por meio das palavras. Orar ou rezar é conectar-se com o Divino, com o Sagrado, para receber as bençãos de Deus, " +
                "dos anjos, dos orixás e das linhas de Umbanda.",
                R.drawable.imagem_oracao);
        menuOpcoes.add(opcaoMenu);

        opcaoMenu = new MenuOpcoes("Orixás", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Duis vel consequat arcu. Nam porttitor sagittis lacus, sit amet ullamcorper libero egestas vel. " +
                "Integer luctus venenatis augue at pulvinar. Vivamus a tristique nisl. Curabitur aliquet enim augue, " +
                "pretium blandit mauris molestie et. Pellentesque et enim gravida, maximus sem non, gravida ante. ",
                R.drawable.imagem_orixas);
        menuOpcoes.add(opcaoMenu);
    }
}