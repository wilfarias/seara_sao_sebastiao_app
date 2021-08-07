package com.cursoandroid.sssapp.dao;

import com.cursoandroid.sssapp.model.BanhoDeErvas;

import java.util.List;

public interface IBanhosDAO {

    public boolean salvar (BanhoDeErvas banhoDeErvas);
    public boolean atualizar (BanhoDeErvas banhoDeErvas);
    public boolean deletar (BanhoDeErvas banhoDeErvas);
    public List<BanhoDeErvas> listar();

}
