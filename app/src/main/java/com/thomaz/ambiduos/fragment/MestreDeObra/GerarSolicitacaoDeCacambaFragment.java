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
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.to.SolicitacaoCacamba;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GerarSolicitacaoDeCacambaFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gerar_solicitacao_de_cacamba, container, false);

        v.findViewById(R.id.next_step).setOnClickListener(this);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<SolicitacaoCacamba> solicitacaoCacambas = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            solicitacaoCacambas.add(new SolicitacaoCacamba((int) i, "Projeto novo brasil", "Rua Niteroi, 48"));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(solicitacaoCacambas, R.layout.line_solicitacao_cacamba, rvList, getActivity()));

        return v;
    }

    @Override
    public String toString() {
        return "Solicitação de caçamba";
    }

    @Override
    public void onClick(View view) {
        ((BaseActivity) getActivity()).setNewFragment(new InformarCacambaFragment());
    }
}
