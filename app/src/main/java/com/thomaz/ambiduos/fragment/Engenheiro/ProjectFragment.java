package com.thomaz.ambiduos.fragment.Engenheiro;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.fragment.CustomFragment;

/**
 * Created by thomaz on 05/10/16.
 */
public class ProjectFragment extends CustomFragment {

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project, container, false);

        getActivity().setTitle(R.string.title_obra_aberta);

        ViewPager vpPager = (ViewPager) view.findViewById(R.id.vpPager);
        vpPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), getActivity()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabs.setViewPager(vpPager);

        return view;
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {

        private static int NUM_ITEMS = 3;
        private Activity activity;

        MyPagerAdapter(FragmentManager fragmentManager, FragmentActivity activity) {
            super(fragmentManager);
            this.activity = activity;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MaterialFragment();
                case 1:
                    return new ResiduoFragment();
                case 2:
                    return new CacambaFragment();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String[] titles = {
                    activity.getString(R.string.title_tab_aberta_material),
                    activity.getString(R.string.title_tab_aberta_residuo),
                    activity.getString(R.string.title_tab_aberta_cacamba)
            };

            return titles[position];
        }

    }

}
