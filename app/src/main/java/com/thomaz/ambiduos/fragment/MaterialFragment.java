package com.thomaz.ambiduos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.SimpleViewActivity_;
import com.thomaz.ambiduos.adapter.MaterialAdapter;
import com.thomaz.ambiduos.adapter.ProjectAdapter;
import com.thomaz.ambiduos.support.RecyclerItemClickListener;
import com.thomaz.ambiduos.to.Material;
import com.thomaz.ambiduos.to.Projetc;
import com.thomaz.ambiduos.to.UnidadeMedida;

import java.util.ArrayList;
import java.util.List;

import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.EXTRA;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.KEY;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.PROJECT;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialFragment extends Fragment {

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

        for (float i = 0; i < 10; i++) {
            materials.add(new Material("Tijolo", new UnidadeMedida("UN"), 100));
        }

        rvList.setAdapter(new MaterialAdapter<>(materials, R.layout.line_material));
        rvList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                }));

        return v;
    }




}
