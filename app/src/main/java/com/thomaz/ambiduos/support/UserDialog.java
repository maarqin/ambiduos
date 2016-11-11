package com.thomaz.ambiduos.support;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by thomaz on 10/11/16.
 */

public class UserDialog {

    private String title;
    private String message;

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
