package com.thomaz.ambiduos.dbs;

import android.content.Context;

import com.thomaz.ambiduos.support.CustomSQLiteOpenHelper;

/**
 * Created by thomaz on 10/11/16.
 */
public class DBHelperCacamba extends CustomSQLiteOpenHelper {

    static public final String ID = "id";
    static public final String NOME = "nome";

    static public final String TABLE = "amb_cacamba";

    public DBHelperCacamba(Context context) {
        super(context, ID, TABLE);

        fields.add(new CustomSQLiteOpenHelper.Fields(ID, "integer"));
        fields.add(new CustomSQLiteOpenHelper.Fields(NOME, "text"));
    }



}