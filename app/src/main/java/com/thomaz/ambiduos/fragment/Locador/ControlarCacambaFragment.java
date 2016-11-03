package com.thomaz.ambiduos.fragment.Locador;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.SimpleViewActivity_;
import com.thomaz.ambiduos.adapter.ProjectAdapter;
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.support.RecyclerItemClickListener;
import com.thomaz.ambiduos.to.Cacamba;
import com.thomaz.ambiduos.to.Projetc;

import java.util.ArrayList;
import java.util.List;

import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.EXTRA;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.KEY;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.PROJECT;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlarCacambaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_simple_list_controlar, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Cacamba> cacambas = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            cacambas.add(new Cacamba("#A" + (int)i));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(cacambas, R.layout.line_cacamba_controlar, rvList, getActivity()));
        rvList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Cacamba projetc = cacambas.get(position);

                        Intent intent = new Intent(getActivity(), SimpleViewActivity_.class);
                        intent.putExtra(EXTRA, projetc);
                        intent.putExtra(KEY, PROJECT);

                        startActivity(intent);
                    }
                }));
        return v;

    }

    @Override
    public String toString() {
        return "Caçambas";
    }
}
