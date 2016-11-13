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
import com.thomaz.ambiduos.dbs.DBHelperSolicitacaoCacamba;
import com.thomaz.ambiduos.to.SolicitacaoCacamba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarDespachoResiduoCooperativaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(R.string.title_despacho_residuo);

        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        DBHelperSolicitacaoCacamba helperSolicitacaoCacamba = new DBHelperSolicitacaoCacamba(getActivity());

        List<HashMap<String, String>> maps = helperSolicitacaoCacamba.all();

        final List<SolicitacaoCacamba> solicitacaoCacambas = new ArrayList<>();

        for (HashMap<String, String> map : maps) {
            solicitacaoCacambas.add(new SolicitacaoCacamba(
                    Integer.parseInt(map.get(DBHelperSolicitacaoCacamba.ID)),
                    map.get(DBHelperSolicitacaoCacamba.OBRA),
                    map.get(DBHelperSolicitacaoCacamba.LOCADORA)
            ));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(solicitacaoCacambas, R.layout.line_controlar_despacho_cooperaiva, rvList, getActivity()));

        return v;

    }

}
