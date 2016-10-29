package com.thomaz.ambiduos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.thomaz.ambiduos.fragment.Engenheiro.ProjectFragment;
import com.thomaz.ambiduos.to.IAdapter;
import com.thomaz.ambiduos.to.TypeCallForSimpleActivity;

import org.androidannotations.annotations.EActivity;

import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.EXTRA;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.KEY;

/**
 * Created by thomaz on 05/10/16.
 */
@EActivity
public class SimpleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_simple_view, true);

        Bundle b = getIntent().getExtras();
        int type = b.getInt(KEY);
        IAdapter obj = ((IAdapter) b.getSerializable(EXTRA));

        String title = "";
        Fragment fragment = null;
        switch (type) {
            case TypeCallForSimpleActivity.PROJECT :
                fragment = new ProjectFragment();
                title = obj.getName();
                break;
        }
        setNewFragment(fragment, title);
    }


}
