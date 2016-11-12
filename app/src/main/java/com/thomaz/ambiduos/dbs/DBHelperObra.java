package com.thomaz.ambiduos.dbs;

import android.content.Context;

import com.thomaz.ambiduos.support.CustomSQLiteOpenHelper;

/**
 * Created by thomaz on 10/11/16.
 */
public class DBHelperObra extends CustomSQLiteOpenHelper {

    static public final String ID = "id";
    static public final String NOME = "obra";
    static public final String TIPO_OBRA = "tipo_obra";
    static public final String ENDERECO = "endereco";

    static public final String TABLE = "amb_obras";

    public DBHelperObra(Context context) {
        super(context, ID, TABLE);

        fields.add(new Fields(ID, "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"));
        fields.add(new Fields(NOME, "text"));
        fields.add(new Fields(TIPO_OBRA, "text"));
        fields.add(new Fields(ENDERECO, "text"));
    }



}