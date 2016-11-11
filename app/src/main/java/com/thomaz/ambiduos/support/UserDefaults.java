package com.thomaz.ambiduos.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by thomaz on 10/11/16.
 */

public class UserDefaults {

    private boolean here;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static String DEFAULTS_ORDER_TO_ID = "DEFAULTS_ORDER_TO_ID";

    @SuppressLint("CommitPrefEdits")
    public UserDefaults(Context context) {
        this(context, "AMBIDUOS");
    }

    @SuppressLint("CommitPrefEdits")
    public UserDefaults(Context context, String local) {
        preferences = context.getSharedPreferences(local, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * @param values HashMap<String, Object>
     */
    public void write(HashMap<String, Object> values) {

        here = true;
        for (HashMap.Entry<String, Object> entry : values.entrySet()) {
            write(entry.getKey(), entry.getValue());
        }
        here = false;
        this.editor.apply();
    }

    /**
     * Tip! When use it, you must to apply values with apply method returned
     *
     * @param key
     * @param value
     * @return editor SharedPreferences.Editor
     */

    public SharedPreferences.Editor write(String key, Object value) {

        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, ((Set<String>) value));
        } else {
            editor.putLong(key, (Long) value);
        }

        if (!here) editor.apply();

        return editor;
    }

    /**
     * @param values
     * @return
     */
    public HashMap<String, Object> read(HashMap<String, Object> values) {

        for (HashMap.Entry<String, Object> entry : values.entrySet()) {
            values.put(entry.getKey(), read(entry.getKey()));
        }
        return values;
    }

    /**
     * @param key
     */
    public Object read(String key) {
        return preferences.getAll().get(key);
    }

    /**
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        Set<String> keys = preferences.getAll().keySet();
        for (String k : keys) {
            if (k.equals(key)) return true;
        }
        return false;
    }

    /**
     * @param key
     * @return
     */
    public boolean remove(String key) {
        return editor.remove(key).commit();
    }

    /**
     * @return
     */
    public boolean clearAll() {
        return editor.clear().commit();
    }

}