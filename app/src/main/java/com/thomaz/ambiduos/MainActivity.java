package com.thomaz.ambiduos;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.thomaz.ambiduos.fragment.InnFragment_;
import com.thomaz.ambiduos.fragment.SearchFragment;
import com.thomaz.ambiduos.fragment.TripPackageFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by thomaz on 03/10/16.
 */
@EActivity
public class MainActivity extends BaseActivity {

    protected DrawerLayout mDrawer;
    protected NavigationView nvDrawer;

    protected ImageView ivCover;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main, false);

        nvDrawer = ((NavigationView) findViewById(R.id.nvView));
        mDrawer = ((DrawerLayout) findViewById(R.id.drawer_layout));

        setupDrawerContent(nvDrawer);
        nvDrawer.setItemIconTintList(null);
        nvDrawer.setItemTextColor(null);

        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);

        mDrawer.addDrawerListener(drawerToggle);

        setNewFragment(new TripPackageFragment_(), "Destinos");
        nvDrawer.getMenu().performIdentifierAction(R.id.nav_destino, 0);

        View headerLayout = nvDrawer.inflateHeaderView(R.layout.nav_header);
        ivCover = ((ImageView) headerLayout.findViewById(R.id.iv_cover_header_drawer));
        ivCover.setColorFilter(Color.rgb(123, 123, 123), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    /**
     * @param navigationView NavigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    /**
     * @param menuItem MenuItem
     */
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment;
        switch(menuItem.getItemId()) {
            case R.id.nav_hotel :
                fragment = new InnFragment_();
                break;
            case R.id.nav_buscar :
                fragment = new SearchFragment();
                break;
            default:
                fragment = new TripPackageFragment_();
        }
        setNewFragment(fragment, menuItem.getTitle());

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    /**
     * @return ActionBarDrawerToggle
     */
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
