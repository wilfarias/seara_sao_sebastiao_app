package com.cursoandroid.sssapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.model.BanhoDeErvas;

import java.util.List;

public class ListaBanhosAdapter extends RecyclerView.Adapter<ListaBanhosAdapter.MyViewHolder> {

    //lista para as opções do menu
    private List<BanhoDeErvas> listaBanhos;

    //contrutor que recebe uma lista
    public ListaBanhosAdapter(List<BanhoDeErvas> banhosList) {
        this.listaBanhos = banhosList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_menu = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_banhos_layout, parent, false);
        return new MyViewHolder(item_menu);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.banho_nome.setText(listaBanhos.get(position).getNome());
        holder.banho_descricao.setText(listaBanhos.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return listaBanhos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView banho_nome;
        TextView banho_descricao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            banho_nome = itemView.findViewById(R.id.textView_NomeBanho);
            banho_descricao = itemView.findViewById(R.id.textView_DescricaoBanho);
        }
    }

}
