package com.thomaz.ambiduos.support;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by thomaz on 10/11/16.
 */

public abstract class CustomSQLiteOpenHelper extends SQLiteOpenHelper {

    static public final String EQUAL = "=";
    static public final String NOT_EQUAL = "!=";
    static public final String ASC = "asc";
    static public final String DESC = "desc";

    private static final String DB_NAME = "DataBase.db";
    protected List<Fields> fields = new ArrayList<>();
    private String primaryKey;
    public String table;
    private StringBuilder where = new StringBuilder();
    private List<Object> values = new ArrayList<>();
    private StringBuilder order = new StringBuilder();
    private Context mContext;

    /**
     * @param context    Context
     * @param primaryKey String
     * @param table      String
     * @param fields     List
     */
    public CustomSQLiteOpenHelper(Context context, String primaryKey, String table,
                                  List<Fields> fields) {
        super(context, DB_NAME, null, 1);
        this.primaryKey = primaryKey;
        this.table = table;
        this.fields = fields;
        mContext = context;
    }

    /**
     * @param context    Context
     * @param primaryKey String
     * @param table      String
     */
    public CustomSQLiteOpenHelper(Context context, String primaryKey, String table) {
        super(context, DB_NAME, null, 1);
        this.primaryKey = primaryKey;
        this.table = table;
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (fields.size() == 0) return;

        StringBuilder sql = new StringBuilder();
        sql.append("create table ").append(table).append('(');
        for (Fields field : fields) {
            sql.append(field.name).append(' ').append(field.type).append(',');
        }
        sql.delete(sql.length() - 1, sql.length()).append(')');

        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTable();
        onCreate(db);
    }

    public void dropTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("drop table if exists " + table);
        onCreate(db);
    }

    /**
     * @return List
     */
    public ArrayList<HashMap<String, String>> all() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + table, null);

        return select(res);
    }

    /**
     * @param foreign    String
     * @param key        String
     * @param foreignKey String
     * @param where      String
     * @param value      String
     * @param orded      String
     * @return ArrayList<HashMap<String,String>>
     */
    public ArrayList<HashMap<String, String>> getWithJoin(String foreign, String key,
                                                          String foreignKey, String where,
                                                          String value, String orded) {
        SQLiteDatabase db = this.getReadableDatabase();

        orded = (orded != null) ? " order by t1." + orded : "";

        Cursor res = db.rawQuery("select * from " + table + " t1 inner join "
                + foreign + " t2 on (t1." + key + " = t2." + foreignKey + ") where "
                + where + "=?" + orded, new String[]{value});

        return select(res);
    }

    public ArrayList<HashMap<String, String>> getJoin() {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor res = db.rawQuery("     select * from cfrases c \n" +
                "     inner join cparametros p on(c.tipo_parametro_id = p.parametro_id)\n" +
                "     inner join ccategorias c2 on(p.categoria_id = c2.categoria_id)\n" +
                "     where c.selected = ?", new String[]{"1"});

        return select(res);
    }



    /**
     * @param values List
     * @return boolean
     */
    public boolean store(List<HashMap<String, String>> values) {
        boolean ret = false;
        for (HashMap<String, String> r : values) {
            ret = storeEach(r);
        }
        return ret;
    }

    /**
     * @param r HashMap
     * @return boolean
     */
    public boolean storeEach(HashMap<String, String> r) {
        SQLiteDatabase db = getWritableDatabase();

        boolean ret = db.insert(table, null, prepare(r)) > 0;
        db.close();
        return ret;
    }

    /**
     * @param newValue HashMap
     * @param id       String
     * @return boolean
     */
    public boolean update(HashMap<String, String> newValue, String id) {
        SQLiteDatabase db = getWritableDatabase();
        boolean ret;
        ret = db.update(table, prepare(newValue), primaryKey + "=?", new String[]{id}) > 0;
        db.close();

        return ret;
    }

    /**
     * @param newValue HashMap
     * @param where    String
     * @param id       String[]
     * @return boolean
     */
    public boolean update(HashMap<String, String> newValue, String where, String[] id) {
        SQLiteDatabase db = getWritableDatabase();
        boolean ret;
        ret = db.update(table, prepare(newValue), where, id) > 0;
        db.close();
        return ret;
    }

    /**
     * @param newValues List
     * @param id        String
     * @return boolean
     */
    public boolean update(List<HashMap<String, String>> newValues, String id) {
        for (HashMap<String, String> r : newValues) {
            if (!update(r, id)) return false;
        }
        return true;
    }

    /**
     * @param key    String
     * @param signal String
     * @param value  Object
     * @return CustomSQLiteOpenHelper
     */
    public CustomSQLiteOpenHelper where(String key, String signal, Object value) {
        return where(key, signal, value, null);
    }

    /**
     * @param key    String
     * @param signal String
     * @param value  Object
     * @return CustomSQLiteOpenHelper
     */
    public CustomSQLiteOpenHelper where(String key, String signal, Object value, String operator) {
        if (where.length() == 0) {
            where.append(" where ");
        }

        where.append(key).append(signal).append("?");
        values.add(value);

        if (operator != null) {
            where.append(' ').append(operator).append(' ');
        }

        return this;
    }

    /**
     * @param key String
     * @param ad  Object
     * @return CustomSQLiteOpenHelper
     */
    public CustomSQLiteOpenHelper order(String key, String ad) {
        if (order.length() == 0) {
            order.append(" order by ");
        } else {
            order.append(',');
        }
        order.append(key).append(' ').append(ad).append(' ');

        return this;
    }

    /**
     * @return ArrayList
     */
    public ArrayList<HashMap<String, String>> execute() {
        SQLiteDatabase db = getReadableDatabase();

        String[] vs = new String[values.size()];
        int i = 0;
        for (Object value : values) {
            vs[i++] = String.valueOf(value);
        }
        Cursor res = db.rawQuery("select * from " + table + where + order, vs);

        where = new StringBuilder();
        order = new StringBuilder();
        values = new ArrayList<>();

        return select(res);
    }

    public ArrayList<HashMap<String, String>> selectRand() {
        // SELECT * FROM table ORDER BY RANDOM() LIMIT

        SQLiteDatabase db = getReadableDatabase();

        String[] vs = new String[values.size()];
        int i = 0;
        for (Object value : values) {
            vs[i++] = String.valueOf(value);
        }

        Cursor res = db.rawQuery("SELECT * FROM " + table + where + " ORDER BY RANDOM()", vs);

        return select(res);
    }

    /**
     * @param value String
     * @return int
     */
    public int destroy(String value) {
        SQLiteDatabase db = getWritableDatabase();
        int ret = db.delete(table, primaryKey + "=?", new String[]{value});
        db.close();
        return ret;
    }

    /**
     * @param r HashMap
     * @return ContentValues
     */
    private ContentValues prepare(HashMap<String, String> r) {
        ContentValues cv = new ContentValues();
        Set<String> keys = r.keySet();
        for (String key : keys) {
            cv.put(key, r.get(key));
        }
        return cv;
    }

    /**
     * @param res Cursor
     * @return ArrayList<HashMap<String, String>>
     */
    private ArrayList<HashMap<String, String>> select(Cursor res) {
        ArrayList<HashMap<String, String>> all = new ArrayList<>();
        res.moveToFirst();

        while (!res.isAfterLast()) {
            HashMap<String, String> map = new HashMap<>();
            for (Fields field : fields) {
                map.put(field.name, res.getString(res.getColumnIndex(field.name)));
            }
            all.add(map);
            res.moveToNext();
        }
        res.close();

        return all;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }

    public void setWhere(StringBuilder where) {
        this.where = where;
    }

    public void setOrder(StringBuilder order) {
        this.order = order;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public static class Fields {

        private String name;
        private String type;

        public Fields(String name, String type) {
            this.name = name;
            this.type = type;
        }

    }


}
