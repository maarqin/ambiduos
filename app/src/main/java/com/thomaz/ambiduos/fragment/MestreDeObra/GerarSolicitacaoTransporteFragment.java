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

        getActivity().setTitle(R.string.title_solicitar_transporte);

        v.findViewById(R.id.next_step).setOnClickListener(this);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Cacamba> cacambas = new ArrayList<>();

        cacambas.add(new Cacamba("6234", new ClasseResiduo("Classe A"), 730));
        cacambas.add(new Cacamba("83478", new ClasseResiduo("Classe B"), 820));
        cacambas.add(new Cacamba("235", new ClasseResiduo("Classe IIA"), 130));
        cacambas.add(new Cacamba("946063", new ClasseResiduo("Classe B"), 110));
        cacambas.add(new Cacamba("235", new ClasseResiduo("Classe IIB"), 2030));
        cacambas.add(new Cacamba("78433", new ClasseResiduo("Classe B"), 100));

        rvList.setAdapter(new CacambaAdapter<>(cacambas, R.layout.line_solicitar_transporte_cacamba, rvList, getActivity()));

        return v;

    }

    @Override
    public void onClick(View view) {
        ((BaseActivity) getActivity()).setNewFragment(new InformarTransporteFragment());
    }
}
