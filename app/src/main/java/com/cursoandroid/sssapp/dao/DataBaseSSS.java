package com.cursoandroid.sssapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseSSS extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_SSS";
    public static String TABELA_BANHOS = "banhos";
    public static String TABELA_ORACOES = "oracoes";
    public static String TABELA_ORIXAS = "orixas";


    public DataBaseSSS(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create_tabela_banhos = "CREATE TABLE IF NOT EXISTS " + TABELA_BANHOS
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT NOT NULL,"
                + "ingredientes TEXT NOT NULL,"
                + "modo_preparo TEXT NOT NULL,"
                + "oracoes TEXT NOT NULL,"
                + "defumacao TEXT,"
                + "descricao TEXT);" ;

        /*String sql_create_tabela_oracoes = "CREATE TABLE IF NOT EXISTS " + TABELA_ORACOES
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT NOT NULL,"
                + "texto TEXT NOT NULL); ";*/

        /*String sql_create_tabela_orixas = "CREATE TABLE IF NOT EXISTS " + TABELA_ORIXAS
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT NOT NULL,"
                + "texto TEXT NOT NULL); ";*/

        try {
            db.execSQL(sql_create_tabela_banhos);
            //db.execSQL(sql_create_tabela_oracoes);
            //db.execSQL(sql_create_tabela_orixas);

            Log.i("INFO DB", "sucesso ao criar a tabela ");

        }catch (Exception e){
            Log.i("INFO DB", "erro ao criar a tabela "+e.getMessage());
        }

        inserirDadosBanhos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserirDadosBanhos(SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put("nome", "Banho de Limpeza");

        cv.put("ingredientes", "1 Cuia Petinga\n" +
                "7 Lim??es Galegos\n" +
                "Largura de 2 dedos de Tabaco de Corda\n" +
                "3 Galhos de Mucuraca??\n" +
                "7 colheres de Sopa de Sal Virgem\n" +
                "Amon??aco\n" +
                "1 Litro de Marafo\n" +
                "Sab??o Dand?? da Costa (Sab??o de Cacau)");

        cv.put("modo_preparo", "Pega-se a cuia petinga, apoie em uma superf??cie para n??o virar;\n" +
                "\nPegue os lim??es descasque e siga cortando em formato de cruz cada uma e " +
                "espremendo com os caro??os deixando os baga??os dentro da cuia;\n" +
                "\nEm seguida pegue 1 dedo de tabaco de corda e corte bem picadinho, " +
                "acrescentando dentro da cuida j?? com os lim??es espremidos;\n" +
                "\nPega-se a mucuraca?? esfregando at?? esfarelar todinho;\n" +
                "\nPega-se o sal virgem, colocando se na cuia com os outros ingredientes e deixe " +
                "para cozinhar no calor do sol;\n" +
                "\nPor final ap??s o cozimento, acrescente o marafo e o amon??aco, tudo na mesma " +
                "cuia e ap??s a mistura tome o banho do pesco??o para baixo, esfregando o " +
                "baga??o do lim??o em todo o corpo.\n" +
                "\nEm continuidade tome o banho com a agua corrente, se ensaboando com o " +
                "sab??o de cacau e posterior tome o banho normal.\n" +
                "\nOBS: Lembrando que o banho especialmente deve-se preparado e tomado " +
                "antes das 18:00h.");

        cv.put("oracoes", "1 Credo;\n" +
                "1 Pai Nosso;\n" +
                "3 Ave Maria");

        cv.put("defumacao", "Depois de todo o processo realizado, realize a defuma????o com alfazema e alecrim");

        cv.put("descricao", "Este banho utiliza-se para limpar as energias negativas, livra a pessoa " +
                "de influ??ncias negativas e tem grande import??ncia na manuten????o do corpo.");
        //-----------------------------------
        ContentValues cv2 = new ContentValues();
        cv2.put("nome", "Banho de Descarga Geral");

        cv2.put("ingredientes", "7 dedos da Folha de Comigo Ningu??m Pode;\n" +
                "7 dedos da Espada de S??o Jorge;\n" +
                "7 dedos de Espada de Joana D???arc;\n" +
                "7 dedos de chicote de Ogum;\n" +
                "7 Folhas de Pe??o Roxo;\n" +
                "7 Galhos de Cipo D???alho;\n" +
                "1 Palmo de Paxiub??;\n" +
                "1 Palmo de Croat??;\n" +
                "7 galhos de Mucuraca??;\n" +
                "7 cabe??as de Alho;\n" +
                "9 Pimentas Malagueta;\n" +
                "7 Haste de Aruera de 5 cm;\n" +
                "7 Palmas de Arruda;\n" +
                "9 Folhas de lim??o Galego;\n" +
                "Largura de 2 dedos de tabaco de Corda ou 7 Folhas;\n" +
                "7 Galhos de Coentro;\n" +
                "7 Folhas de Eucalipto;\n" +
                "9 Folhas de Cab??;\n" +
                "7 litros de Marafo;\n" +
                "1 litro de Amon??aco;\n" +
                "Sal Virgem (N??o ?? o sal de Churrasco).");

        cv2.put("modo_preparo", "Em uma panela ou lata de 20 litros, amasse todas as 7 cabe??as de alho mantendo-se as cascas, " +
                "tabaco de corda cortado e acrescente todos os ingredientes, exceto o (marafo, sal virgem e amon??aco) e " +
                "complete a panela com agua e coloque para ferver. Ap??s a fervura de 3 horas, espere esfriar e retire todos os " +
                "ingredientes passando por um crivo e posterior acrescente o marafo, amon??aco, sal virgem.\n" +
                "\nO banho poder?? ser utilizado para limpeza residencial e corporal, por??m quando utilizado para o corpo, dever?? ser " +
                "separado em uma cuia petinga e jogado do pesco??o para baixo, ensaboando ??? se com sab??o grosso e posterior " +
                "tomando o banho normal com ??gua corrente. Durante o processo dever?? realizar as ora????es.\n" +
                "\nO banho em resid??ncia dever?? ser jogado da cozinha para a porta da rua e a defuma????o dever?? ser de tr??s para frente, " +
                "em acompanhamento das ora????es espont??neas e a de combate.\n" +
                "\nOBS: O banho dever?? ser conservado em uma recipiente de vidro e separado em 4 garraf??es de 5 litros.\n" +
                "\nOBS2: Estes banhos dever??o ser realizados nos dias de ter??a, quinta e s??bado.");
        cv2.put("oracoes", "Ora????o contra todos os males\n" +
                "Ora????o de Combate de S??o Miguel Arcanjo");

        cv2.put("defumacao", "Raspa de Chifre, Palha de Alho, breu branco, quebra barreira, vence tudo, vence batalha e vende demanda.");

        cv2.put("descricao", "Este banho de descarga ou desimpregna????o energ??tica ?? o mais comum e mais conhecido. " +
                "Este banho serve para livrar o indiv??duo de cargas energ??ticas negativas.");
        //-----------------------------------
        ContentValues cv3 = new ContentValues();
        cv3.put("nome", "Banho Cheiroso");

        cv3.put("ingredientes", "20 litros de Agua;\n" +
                "500 gramas de Manjeric??o Roxo;\n" +
                "10 folhas de Vindic?? Paj??;\n" +
                "500 gramas de Manjerona;\n" +
                "500 grama de Oriz??;\n" +
                "500 gramas de Caatinga de Mulata;\n" +
                "500 gramas de Alecrim da Angola;\n" +
                "500 gramas de Abre Caminho;\n" +
                "500 gramas de Folhas de Alfazema;\n" +
                "500 gramas de Folhas de Chama;");

        cv3.put("modo_preparo", "Em 20 litros de agua, as ervas dever??o ser maceradas at?? criar um sumo e posteriormente coadas. " +
                "Depois de coadas, usar as col??nias de Seiva de Alfazema, Col??nia Selvagem ou de prefer??ncia pessoal. " +
                "(S??o 4 vidros de col??nia de 500 ml).\n" +
                "\nO banho cheiroso dever?? ser jogado da cabe??a para baixo, sempre ap??s o banho normal tomado diariamente, " +
                "cumprindo os dias que s??o: Segunda, Quarta e Sexta Feira.\n" +
                "\nHor??rios de escolha para o Banho: 06:00h da manh?? ou 12:00h ou 18:00h.\n" +
                "\nObs: Conservar em um recipiente de vidro.\n");

        cv3.put("oracoes", "1 Pai Nosso;\n" +
                "3 Ave Marias\n" +
                "1 Salve Rainha\n" +
                "\nOBS: Deve-se oferecer ao anjo da guarda as ora????es, solicitando prote????o, e deixar acesa 1 candeia branca");
        cv3.put("defumacao", "-");

        cv3.put("descricao", "Este banho reativa os centros energ??ticos e refaz o teor positivo do aura. Reequilibra a pessoa e " +
                "aumenta a capacidade receptiva do aparelho medi??nico, j?? que os chacras ser??o desobstru??dos");
        try{
            db.insert(DataBaseSSS.TABELA_BANHOS, null, cv);
            db.insert(DataBaseSSS.TABELA_BANHOS, null, cv2);
            db.insert(DataBaseSSS.TABELA_BANHOS, null, cv3);
            Log.i("INFO", "dados banho salvo ");
        }catch (Exception e){
            Log.i("INFO", "erro ao salvar dados banho "+e.getMessage());
        }
    }

    /*public void inserirDadosOracoes(SQLiteDatabase db){

        ContentValues cv = new ContentValues();
        cv.put("nome", "Banho Cheiroso");

        cv.put("ingredientes", "20 litros de Agua;\n" +
                "500 gramas de Manjeric??o Roxo;\n" +
                "10 folhas de Vindic?? Paj??;\n" +
                "500 gramas de Manjerona;\n" +
                "500 grama de Oriz??;\n" +
                "500 gramas de Caatinga de Mulata;\n" +
                "500 gramas de Alecrim da Angola;\n" +
                "500 gramas de Abre Caminho;\n" +
                "500 gramas de Folhas de Alfazema;\n" +
                "500 gramas de Folhas de Chama;");

        cv.put("modo_preparo", "Em 20 litros de agua, as ervas dever??o ser maceradas at?? criar um sumo e posteriormente coadas. " +
                "Depois de coadas, usar as col??nias de Seiva de Alfazema, Col??nia Selvagem ou de prefer??ncia pessoal. " +
                "(S??o 4 vidros de col??nia de 500 ml).\n" +
                "\nO banho cheiroso dever?? ser jogado da cabe??a para baixo, sempre ap??s o banho normal tomado diariamente, " +
                "cumprindo os dias que s??o: Segunda, Quarta e Sexta Feira.\n" +
                "\nHor??rios de escolha para o Banho: 06:00h da manh?? ou 12:00h ou 18:00h.\n" +
                "\nObs: Conservar em um recipiente de vidro.\n");

        cv.put("oracoes", "1 Pai Nosso;\n" +
                "3 Ave Marias\n" +
                "1 Salve Rainha\n" +
                "\nOBS: Deve-se oferecer ao anjo da guarda as ora????es, solicitando prote????o, e deixar acesa 1 candeia branca");
        cv.put("defumacao", "");

        cv.put("descricao", "Este banho reativa os centros energ??ticos e refaz o teor positivo do aura. Reequilibra a pessoa e " +
                "aumenta a capacidade receptiva do aparelho medi??nico, j?? que os chacras ser??o desobstru??dos");
        try{
            db.insert(DataBaseSSS.TABELA_ORACOES, null, cv);
            Log.i("INFO", "dados ora????es salvo ");
        }catch (Exception e){
            Log.i("INFO", "erro ao salvar dados ora????es "+e.getMessage());
        }

    }*/

}
