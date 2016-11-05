package com.thomaz.ambiduos.fragment.Cooperativa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.to.SolicitacaoCacamba;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarDespachoResiduoCooperativaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<SolicitacaoCacamba> solicitacaoCacambas = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            solicitacaoCacambas.add(new SolicitacaoCacamba((int)i, "Obra " + (int)i, "Classe A"));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(solicitacaoCacambas, R.layout.line_controlar_despacho_cooperaiva, rvList, getActivity()));

        return v;

    }


    @Override
    public String toString() {
        return "Despacho de resíduo";
    }
}
