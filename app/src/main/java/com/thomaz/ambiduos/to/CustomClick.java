package com.thomaz.ambiduos.to;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by thomaz on 12/11/16.
 */

public interface CustomClick extends View.OnClickListener {
    void setData(EditText data);

    void setToClose(Activity activity);
}
