package com.thomaz.ambiduos.fragment.MestreDeObra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.BaseActivity;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.CacambaAdapter;
import com.thomaz.ambiduos.to.Cacamba;
import com.thomaz.ambiduos.to.ClasseResiduo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GerarSolicitacaoTransporteFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gerar_solicitacao_transporte, container, false);

        v.findViewById(R.id.next_step).setOnClickListener(this);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Cacamba> cacambas = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            cacambas.add(new Cacamba("21441", new ClasseResiduo("Classe X"), 10));
        }

        rvList.setAdapter(new CacambaAdapter<>(cacambas, R.layout.line_solicitar_transporte_cacamba, rvList, getActivity()));

        return v;

    }

    @Override
    public String toString() {
        return "Solicitação de transporte";
    }

    @Override
    public void onClick(View view) {
        ((BaseActivity) getActivity()).setNewFragment(new InformarTransporteFragment());
    }
}
