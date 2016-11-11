package com.thomaz.ambiduos.support;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by thomaz on 10/10/16.
 */
public class UserDialog {

    private String title;
    private String message;

    private static UserDialog instance;

    public static UserDialog getInstance() {
        if( instance == null ) {
            instance = new UserDialog();
        }
        return instance;
    }

    // Singleton
    // Construct must to be private
    private UserDialog() {

    }

    public void show(Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
