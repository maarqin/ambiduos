package com.thomaz.ambiduos.fragment;

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
import com.thomaz.ambiduos.support.RecyclerItemClickListener;
import com.thomaz.ambiduos.to.Projetc;

import java.util.ArrayList;
import java.util.List;

import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.EXTRA;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.KEY;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.PROJECT;

/**
 * Created by thomaz on 15/10/16.
 */

public class ProjectsFragment extends CustomFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_list, container, false);

        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Projetc> projetcs = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            projetcs.add(new Projetc("Projeto novo brasil", "Rua Niteroi, 48"));
        }

        rvList.setAdapter(new ProjectAdapter<>(projetcs, R.layout.line_project, rvList, getActivity()));
        rvList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Projetc projetc = projetcs.get(position);

                        Intent intent = new Intent(getActivity(), SimpleViewActivity_.class);
                        intent.putExtra(EXTRA, projetc);
                        intent.putExtra(KEY, PROJECT);

                        startActivity(intent);
                    }
                }));
        return v;
    }
}
