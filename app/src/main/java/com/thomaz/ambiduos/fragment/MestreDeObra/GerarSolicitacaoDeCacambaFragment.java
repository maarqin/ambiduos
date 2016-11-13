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
import com.thomaz.ambiduos.to.Projetc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GerarSolicitacaoDeCacambaFragment extends Fragment implements View.OnClickListener {

    private SimpleDataAdapter<Projetc> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gerar_solicitacao_de_cacamba, container, false);

        getActivity().setTitle(R.string.title_solicitar_cacamba);

        v.findViewById(R.id.next_step).setOnClickListener(this);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Projetc> projetcs = new ArrayList<>();

        projetcs.add(new Projetc("ALAMEDA ECO RESORT & RESIDENCE", "Rua Tereza Zanette Lopes, 203, Gleba Palhano - Londrina, PR"));
        projetcs.add(new Projetc("CHAMPS ÉLYSÉES RESIDENCE", "Rua Ernani Lacerda de Athayde, 930, Gleba Palhano - Londrina, PR"));
        projetcs.add(new Projetc("ÉLÉGANCE", "Rua Paranaguá, 410, Centro - Londrina, PR"));
        projetcs.add(new Projetc("LE BLANC", "R. João Huss, 855, Gleba Palhano - Londrina, PR"));
        projetcs.add(new Projetc("PARC ROCHER", "Alameda Pé Vermelho, 180, Gleba Palhano - Londrina, PR"));
        projetcs.add(new Projetc("PRIME PARANAGUÁ", "Rua João Huss, 881, Gleba Palhano - Londrina, PR"));
        projetcs.add(new Projetc("TRÉSOR RESIDENCE", "Rua Gleba Palhano, 48"));
        projetcs.add(new Projetc("VERT RESIDENCE", "Rua Quintino Niteroi, 48"));
        projetcs.add(new Projetc("ARQUITETO VILANOVA ARTIGAS", "Rua Niteroi, 48"));
        projetcs.add(new Projetc("AUGUSTE RODIN", "Rua Niteroi, 48"));
        projetcs.add(new Projetc("CHAMPS ÉLYSÉES RESIDENCE", "Rua Niteroi, 48"));
        projetcs.add(new Projetc("COLLORI", "Rua Quintino Bocaiúva, 298, Zona 07 - Maringá, PR"));


        adapter = new SimpleDataAdapter<>(projetcs, R.layout.line_solicitacao_cacamba, rvList, getActivity());
        rvList.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClick(View view) {
        ((BaseActivity) getActivity()).setNewFragment(new InformarCacambaFragment());
    }

    @Override
    public void onStart() {
        super.onStart();

        adapter.notifyDataSetChanged();
    }
}
