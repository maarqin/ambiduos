package com.thomaz.ambiduos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.SimpleViewActivity_;
import com.thomaz.ambiduos.adapter.TripPackageInnAdapter;
import com.thomaz.ambiduos.support.RecyclerItemClickListener;
import com.thomaz.ambiduos.to.TripPackage;

import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomaz on 04/10/16.
 */
@EFragment
public class TripPackageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        List<TripPackage> tripPackages = new ArrayList<>();

        for (float i = 0; i < 100; i++) {
            tripPackages.add(new TripPackage("Rj", "Brazil", i));
        }

        rvList.setAdapter(new TripPackageInnAdapter<>(tripPackages, R.layout.line_trip_package));
        rvList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SimpleViewActivity_.intent(getActivity()).start();
            }
        }));
        return v;
    }

}
