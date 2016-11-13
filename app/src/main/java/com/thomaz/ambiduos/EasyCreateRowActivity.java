package com.thomaz.ambiduos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.thomaz.ambiduos.to.StrategyOnClick;

public class EasyCreateRowActivity extends AppCompatActivity {

    static public final String LAYOUT = "LAYOUT";
    static public final String ACTION = "ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        setContentView(bundle.getInt(LAYOUT));

        EditText text = ((EditText) findViewById(R.id.tv_value));

        StrategyOnClick c = bundle.getParcelable(ACTION);
        c.setData(text);
        c.setToClose(this);

        findViewById(R.id.bt_salvar).setOnClickListener(c);
    }
}
