package com.thomaz.ambiduos.fragment.Engenheiro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.ResiduoAdapter;
import com.thomaz.ambiduos.fragment.CustomFragment;
import com.thomaz.ambiduos.to.Cacamba;
import com.thomaz.ambiduos.to.ClasseResiduo;
import com.thomaz.ambiduos.to.Residuo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResiduoFragment extends CustomFragment {

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Residuo> residuos = new ArrayList<>();

        residuos.add(new Residuo("Tijolos", "IIA", 33, new Cacamba("6234", new ClasseResiduo("Classe IIA"), 730)));
        residuos.add(new Residuo("Tijolos", "IIA", 33, new Cacamba("833", new ClasseResiduo("Classe IIA"), 730)));
        residuos.add(new Residuo("Tijolos", "IB", 33, new Cacamba("34", new ClasseResiduo("Classe IB"), 730)));
        residuos.add(new Residuo("Tijolos", "A", 33, new Cacamba("83442", new ClasseResiduo("Classe A"), 730)));
        residuos.add(new Residuo("Tijolos", "B", 33, new Cacamba("12", new ClasseResiduo("Classe B"), 730)));
        residuos.add(new Residuo("Tijolos", "IA", 33, new Cacamba("33", new ClasseResiduo("Classe IA"), 730)));
        residuos.add(new Residuo("Tijolos", "IIA", 33, new Cacamba("944", new ClasseResiduo("Classe IIA"), 730)));

        rvList.setAdapter(new ResiduoAdapter<>(residuos, R.layout.line_residuo, rvList, getActivity()));

        return v;
    }

}
