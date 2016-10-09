package com.thomaz.ambiduos;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by thomaz on 05/10/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    protected void onCreate(@Nullable Bundle savedInstanceState, @LayoutRes int res, boolean backable) {
        super.onCreate(savedInstanceState);
        setContentView(res);

        if( backable ) {
            showBackButton();
        }

        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(toolbar);
    }

    /**
     * @param fragment Fragment
     */
    protected void setNewFragment(Fragment fragment, CharSequence title) {
        // Set action bar title
        setTitle(title);
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    private void showBackButton() {
        if( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
