package com.thomaz.ambiduos;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.thomaz.ambiduos.fragment.TripPackageOpenedFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by thomaz on 05/10/16.
 */
@EActivity
public class SimpleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_simple_view, true);

        setNewFragment(new TripPackageOpenedFragment_(), "adafsd");
    }

}
