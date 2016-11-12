package com.thomaz.ambiduos.support;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

/**
 * Created by thomaz on 10/10/16.
 */
public class UserDialog {

    private String title;
    private String message;
    private CharSequence[] items;
    private EditText text;
    private DialogInterface.OnClickListener clickOkListener;

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
        if( items != null ) {
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    text.setText(items[i]);
                }
            });
        }

        if( clickOkListener != null ) {
            builder.setNeutralButton("Ok", clickOkListener);
        }
        builder.show();
    }

    public void setText(EditText text) {
        this.text = text;
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

    public void setItems(CharSequence[] items) {
        this.items = items;
    }

    public void setClickOkListener(DialogInterface.OnClickListener clickOkListener) {
        this.clickOkListener = clickOkListener;
    }

    public void setClean(){
        instance = null;
    }

}
