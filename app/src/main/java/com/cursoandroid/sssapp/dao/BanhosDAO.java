package com.cursoandroid.sssapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cursoandroid.sssapp.model.BanhoDeErvas;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/*
    Classe utilizada para manipular os resgistros do banco de dados
    Operações CRUD
*/

public class BanhosDAO implements IBanhosDAO{

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    private DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();

    public BanhosDAO(Context context){
        DataBaseSSS db = new DataBaseSSS(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(BanhoDeErvas banhoDeErvas) {
        return false;
    }

    @Override
    public boolean atualizar(BanhoDeErvas banhoDeErvas) {
        return false;
    }

    @Override
    public boolean deletar(BanhoDeErvas banhoDeErvas) {
        return false;
    }

    @Override
    public List<BanhoDeErvas> listar() {

        List<BanhoDeErvas> banhosDeErvas = new ArrayList<>();

        String sql = "SELECT * FROM "+ DataBaseSSS.TABELA_BANHOS + ";";
        Cursor cursor = read.rawQuery(sql, null);

        while (cursor.moveToNext()){
            BanhoDeErvas banho = new BanhoDeErvas();
            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nomeBanho = cursor.getString(cursor.getColumnIndex("nome"));
            String ingredientes = cursor.getString(cursor.getColumnIndex("ingredientes"));
            String modo_preparo = cursor.getString(cursor.getColumnIndex("modo_preparo"));
            String oracoes = cursor.getString(cursor.getColumnIndex("oracoes"));
            String defumacao = cursor.getString(cursor.getColumnIndex("defumacao"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));

            banho.setNome(nomeBanho);
            banho.setIngredientes(ingredientes);
            banho.setModo_preparo(modo_preparo);
            banho.setOracoes(oracoes);
            banho.setDefumacao(defumacao);
            banho.setDescricao(descricao);

            banhosDeErvas.add(banho);
        }
        return banhosDeErvas;
    }
}
