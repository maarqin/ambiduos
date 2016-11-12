package com.thomaz.ambiduos.dbs;

import android.content.Context;

import com.thomaz.ambiduos.support.CustomSQLiteOpenHelper;

/**
 * Created by thomaz on 10/11/16.
 */
public class DBHelperMestreObra extends CustomSQLiteOpenHelper {

    static public final String ID = "id";
    static public final String OBRA_ID = "obra_id";
    static public final String NOME = "nome";

    static public final String TABLE = "amb_mestre_de_obras";

    public DBHelperMestreObra(Context context) {
        super(context, ID, TABLE);

        fields.add(new Fields(ID, "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"));
        fields.add(new Fields(NOME, "text"));
        fields.add(new Fields(OBRA_ID, "integer"));
    }



}