package com.thomaz.ambiduos.fragment.Engenheiro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.CacambaAdapter;
import com.thomaz.ambiduos.fragment.CustomFragment;
import com.thomaz.ambiduos.to.Cacamba;
import com.thomaz.ambiduos.to.ClasseResiduo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CacambaFragment extends CustomFragment {

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Cacamba> materials = new ArrayList<>();

        materials.add(new Cacamba("6234", new ClasseResiduo("Classe A"), 730));
        materials.add(new Cacamba("83478", new ClasseResiduo("Classe B"), 820));
        materials.add(new Cacamba("235", new ClasseResiduo("Classe IIA"), 130));
        materials.add(new Cacamba("946063", new ClasseResiduo("Classe B"), 110));
        materials.add(new Cacamba("235", new ClasseResiduo("Classe IIB"), 2030));
        materials.add(new Cacamba("78433", new ClasseResiduo("Classe B"), 100));


        rvList.setAdapter(new CacambaAdapter<>(materials, R.layout.line_cacamba, rvList, getActivity()));

        return v;
    }

}
