package com.thomaz.ambiduos.dbs;

import android.content.Context;

import com.thomaz.ambiduos.support.CustomSQLiteOpenHelper;

/**
 * Created by thomaz on 10/11/16.
 */
public class DBHelperSolicitacaoCacamba extends CustomSQLiteOpenHelper {

    static public final String ID = "id";
    static public final String OBRA = "obra";
    static public final String QTDE_CACAMBA = "qtde_cacamba";
    static public final String LOCADORA = "locadora";

    static public final String TABLE = "amb_solicitacao_cacamba";

    public DBHelperSolicitacaoCacamba(Context context) {
        super(context, ID, TABLE);

        fields.add(new Fields(ID, "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"));
        fields.add(new Fields(OBRA, "text"));
        fields.add(new Fields(QTDE_CACAMBA, "integer"));
        fields.add(new Fields(LOCADORA, "text"));
    }



}