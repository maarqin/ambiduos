package com.thomaz.ambiduos;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.thomaz.ambiduos.fragment.Cooperativa.ConsultarDespachoResiduoCooperativaFragment;
import com.thomaz.ambiduos.fragment.Engenheiro.ControlarMestreDeObraFragment;
import com.thomaz.ambiduos.fragment.Engenheiro.ProjectsFragment;
import com.thomaz.ambiduos.fragment.Locador.ConsultarLocacoesFragment;
import com.thomaz.ambiduos.fragment.Locador.ConsultarSolicitacaoDeCacambaFragment;
import com.thomaz.ambiduos.fragment.Locador.ControlarCacambaFragment;
import com.thomaz.ambiduos.fragment.Locador.GerarDespachoResiduoCooperativaFragment;
import com.thomaz.ambiduos.fragment.Locador.GerarDespachoResiduoFragment;
import com.thomaz.ambiduos.fragment.MestreDeObra.GerarSolicitacaoDeCacambaFragment;
import com.thomaz.ambiduos.fragment.MestreDeObra.GerarSolicitacaoTransporteFragment;
import com.thomaz.ambiduos.fragment.MinhaContaFragment;
import com.thomaz.ambiduos.fragment.Transportador.ConsultarSolicitacaoTransporteFragment;
import com.thomaz.ambiduos.fragment.Transportador.DocumentsFragment;
import com.thomaz.ambiduos.fragment.WelcomeFragment;

import java.util.Locale;

/**
 * Created by thomaz on 03/10/16.
 */
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

        // Recupera o menu
        int menu = getIntent().getExtras().getInt("MENU");

        nvDrawer.inflateMenu(menu);

        setupDrawerContent(nvDrawer);
        nvDrawer.setItemIconTintList(null);
        nvDrawer.setItemTextColor(null);

        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);

        mDrawer.addDrawerListener(drawerToggle);

        setNewFragment(new WelcomeFragment(), false);

        View headerLayout = nvDrawer.inflateHeaderView(R.layout.nav_header);
//        ivCover = ((ImageView) headerLayout.findViewById(R.id.iv_cover_header_drawer));
//        ivCover.setColorFilter(Color.rgb(123, 123, 123), android.graphics.PorterDuff.Mode.MULTIPLY);


        // Language
        String lang = Locale.getDefault().getLanguage();

        System.out.println("lang = " + lang);
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

     public void selectDrawerItem(MenuItem menuItem) {
         Fragment fragment = new Fragment();

         switch (menuItem.getItemId()) {
             // Cooperativa
             case R.id.nav_sucConsultarDespachoResiduoCooperativa :
                 fragment = new ConsultarDespachoResiduoCooperativaFragment();
                 break;

             // Engenheiro
             case R.id.nav_sucControlarObra :
                 fragment = new ProjectsFragment();
                 break;
             case R.id.nav_sucControlarMestreDeObra :
                 fragment = new ControlarMestreDeObraFragment();
                 break;

             // Locador
             case R.id.nav_sucConsultarSolicitacaoDeCacamba :
                 fragment = new ConsultarSolicitacaoDeCacambaFragment();
                 break;
             case R.id.nav_sucGerarDespachoResiduos :
                 fragment = new GerarDespachoResiduoFragment();
                 break;
             case R.id.nav_sucGerarDespachoResiduoCooperativa :
                 fragment = new GerarDespachoResiduoCooperativaFragment();
                 break;
             case R.id.nav_sucConsultarLocacoes :
                 fragment = new ConsultarLocacoesFragment();
                 break;
             case R.id.nav_sucControlarCacamba :
                 fragment = new ControlarCacambaFragment();
                 break;

             // Mestre de obra
             case R.id.nav_sucGerarSolicitacaoDeCacamba :
                 fragment = new GerarSolicitacaoDeCacambaFragment();
                 break;
             case R.id.nav_sucGerarSolicitacaoTransporte :
                 fragment = new GerarSolicitacaoTransporteFragment();
                 break;

             // Transportador
             case R.id.nav_sucControlarDocumentos :
                 fragment = new DocumentsFragment();
                 break;
             case R.id.nav_sucConsultarSolicitacaoTransporte :
                 fragment = new ConsultarSolicitacaoTransporteFragment();
                 break;

             // Generics
             case R.id.nav_sair :
                 finish();
                 break;
             case R.id.nav_minha_conta :
                 fragment = new MinhaContaFragment();
                 break;
         }

         menuItem.setChecked(false);
         mDrawer.closeDrawers();

         setNewFragment(fragment);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,
                R.string.drawer_close);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
