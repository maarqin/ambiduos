package com.thomaz.ambiduos.fragment.Engenheiro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.to.MestreDeObra;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlarMestreDeObraFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_simple_list_controlar, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<MestreDeObra> mestreDeObras = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            mestreDeObras.add(new MestreDeObra("Fulano de tal " + (int) i));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(mestreDeObras, R.layout.line_simple, rvList, getActivity()));
        return v;

    }

    @Override
    public String toString() {
        return "Mestre de obra";
    }
}
