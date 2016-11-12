package com.thomaz.ambiduos.dbs;

import android.content.Context;

import com.thomaz.ambiduos.support.CustomSQLiteOpenHelper;

/**
 * Created by thomaz on 10/11/16.
 */
public class DBHelperSolicitacaoTransporte extends CustomSQLiteOpenHelper {

    static public final String ID = "id";
    static public final String CACAMBA_ID = "cacamba_id";
    static public final String COOPERATIVA = "cooperativa";

    static public final String TABLE = "amb_transportes";

    public DBHelperSolicitacaoTransporte(Context context) {
        super(context, ID, TABLE);

        fields.add(new Fields(ID, "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"));
        fields.add(new Fields(CACAMBA_ID, "integer"));
        fields.add(new Fields(COOPERATIVA, "text"));
    }



}