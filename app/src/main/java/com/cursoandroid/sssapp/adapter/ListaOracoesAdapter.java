package com.cursoandroid.sssapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.model.Oracao;

import java.util.List;

public class ListaOracoesAdapter extends RecyclerView.Adapter<ListaOracoesAdapter.MyViewHolder>{

    //lista para as opções do menu
    private List<Oracao> listaOracoes;

    //contrutor que recebe uma lista
    public ListaOracoesAdapter(List<Oracao> oracoesList) {
        this.listaOracoes = oracoesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_menu = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_oracoes_layout, parent, false);
        return new MyViewHolder(item_menu);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome_oracao.setText(listaOracoes.get(position).getNome());
        //holder.texto_oracao.setText(listaOracoes.get(position).getTexto());
    }

    @Override
    public int getItemCount() {
        return listaOracoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome_oracao;
        //TextView texto_oracao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_oracao = itemView.findViewById(R.id.textView_NomeOracao);
            //texto_oracao = itemView.findViewById(R.id.textView_TextoOracao);
        }
    }
}
