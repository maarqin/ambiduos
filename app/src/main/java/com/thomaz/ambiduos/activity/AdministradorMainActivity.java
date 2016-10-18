package com.thomaz.ambiduos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.thomaz.ambiduos.MainActivity;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.fragment.ProjectsFragment;

import org.androidannotations.annotations.EActivity;

/**
 * Created by thomaz on 15/10/16.
 */
@EActivity
public class AdministradorMainActivity extends MainActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setNewFragment(new ProjectsFragment(), "Controlar obras");
    }

    @Override
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        switch(menuItem.getItemId()) {
            case R.id.nav_obra :
                fragment = new ProjectsFragment();
                break;
            case R.id.nav_controlar_despejos :
                break;
            case R.id.nav_transporte :
                break;
            case R.id.nav_mestre_de_obra :
                break;
            case R.id.nav_solicitacao :
                break;
        }
        setNewFragment(fragment, menuItem.getTitle());

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }
}
