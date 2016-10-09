package com.thomaz.ambiduos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.TripPackageInnAdapter;
import com.thomaz.ambiduos.to.Inn;

import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomaz on 04/10/16.
 */
@EFragment
public class InnFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        List<Inn> inns = new ArrayList<>();

        for (float i = 0; i < 1000; i++) {
            inns.add(new Inn("Rj", "Brazil", i));
        }

        rvList.setAdapter(new TripPackageInnAdapter<>(inns, R.layout.line_inn));

        return v;
    }

}
