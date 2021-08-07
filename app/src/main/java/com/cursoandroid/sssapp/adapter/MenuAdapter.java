package com.cursoandroid.sssapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.sssapp.R;
import com.cursoandroid.sssapp.model.MenuOpcoes;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private List<MenuOpcoes> menuOpcoes; //lista para as opções do menu

    //contrutor que recebe uma lista
    public MenuAdapter(List<MenuOpcoes> menuOpcoesList) {
        this.menuOpcoes = menuOpcoesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item_menu = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_layout, parent, false);
        return new MyViewHolder(item_menu);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nome_opcao_menu.setText(menuOpcoes.get(position).getNome());
        holder.descricao_opcao_menu.setText(menuOpcoes.get(position).getDescricao());
        holder.imagem_opcao_menu.setImageResource(menuOpcoes.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        return menuOpcoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nome_opcao_menu;
        private TextView descricao_opcao_menu;
        private ImageView imagem_opcao_menu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_opcao_menu = itemView.findViewById(R.id.textView_nomeOpcaoMenu);
            descricao_opcao_menu = itemView.findViewById(R.id.textView_descricaoOpcaoMenu);
            imagem_opcao_menu = itemView.findViewById(R.id.imageView_opcaoMenu);
        }
    }

}
