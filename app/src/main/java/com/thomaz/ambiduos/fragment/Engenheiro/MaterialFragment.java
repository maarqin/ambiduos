package com.thomaz.ambiduos.fragment.Engenheiro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.MaterialAdapter;
import com.thomaz.ambiduos.fragment.CustomFragment;
import com.thomaz.ambiduos.to.Material;
import com.thomaz.ambiduos.to.UnidadeMedida;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialFragment extends CustomFragment {

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Material> materials = new ArrayList<>();

        materials.add(new Material("Areia", new UnidadeMedida("M2"), 1250));
        materials.add(new Material("Mosaico Mosarte Mondrian Bege", new UnidadeMedida("M2"), 50));
        materials.add(new Material("Argamassa ACI Cerâmica Interna Cinza", new UnidadeMedida("KG"), 250));
        materials.add(new Material("Bloco Cerâmico Vedação 9x19x19cm", new UnidadeMedida("M2"), 10250));
        materials.add(new Material("Elemento Vazado Linha Vintage 24cmx24cmx7cm", new UnidadeMedida("UN"), 20250));
        materials.add(new Material("Louça Esmaltado Folha Amarelo 25cmx25cmx7,5cm", new UnidadeMedida("UN"), 1250));
        materials.add(new Material("Vazado Rústico Reto Quadrado", new UnidadeMedida("UN"), 250));
        materials.add(new Material("Ripa Eucalipto Aplainada 3x220cm", new UnidadeMedida("M"), 1250));
        materials.add(new Material("Ripa Eucalipto Natural Bruto", new UnidadeMedida("M"), 405));
        materials.add(new Material("Ripa Teca Aplainada 3x210cm", new UnidadeMedida("M"), 125));
        materials.add(new Material("Pedra", new UnidadeMedida("M"), 1250));
        materials.add(new Material("Tinta verde-agua", new UnidadeMedida("L"), 800));

        rvList.setAdapter(new MaterialAdapter<>(materials, R.layout.line_material, rvList, getActivity()));

        return v;
    }




}
