package com.thomaz.ambiduos.fragment.Locador;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.SimpleViewActivity_;
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.support.RecyclerItemClickListener;
import com.thomaz.ambiduos.to.Locacao;

import java.util.ArrayList;
import java.util.List;

import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.EXTRA;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.KEY;
import static com.thomaz.ambiduos.to.TypeCallForSimpleActivity.PROJECT;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarLocacoesFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_consultar_locacoes, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        RecyclerView rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final List<Locacao> locacoes = new ArrayList<>();

        for (float i = 0; i < 10; i++) {
            locacoes.add(new Locacao("" + (int)i, "#A" + (int)i));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(locacoes, R.layout.line_simple, rvList, getActivity()));
        rvList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Locacao projetc = locacoes.get(position);

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
        return "Locações";
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng p1 = new LatLng(-23.3044631, -51.1695957);

        LatLng p2 = new LatLng(-23.302870, -51.187125);
        LatLng p3 = new LatLng(-23.312377, -51.180093);
        LatLng p4 = new LatLng(-23.310685, -51.166755);
        LatLng p5 = new LatLng(-23.305368, -51.162378);
        LatLng p6 = new LatLng(-23.303340, -51.158600);
        LatLng p7 = new LatLng(-23.296490, -51.155763);
        LatLng p8 = new LatLng(-23.293021, -51.161149);
        LatLng p9 = new LatLng(-23.291021, -51.153714);
        LatLng p10 = new LatLng(-23.296454, -51.147380);
        mMap.addMarker(new MarkerOptions().position(p1));
        mMap.addMarker(new MarkerOptions().position(p2));
        mMap.addMarker(new MarkerOptions().position(p3));
        mMap.addMarker(new MarkerOptions().position(p4));
        mMap.addMarker(new MarkerOptions().position(p5));
        mMap.addMarker(new MarkerOptions().position(p6));
        mMap.addMarker(new MarkerOptions().position(p7));
        mMap.addMarker(new MarkerOptions().position(p8));
        mMap.addMarker(new MarkerOptions().position(p9));
        mMap.addMarker(new MarkerOptions().position(p10));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(p1)      // Sets the center of the map to Mountain View
                .zoom(12)                   // Sets the zoom
                .tilt(10)                   // Sets the tilt of the camera to 30 degrees
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(p1));
    }
}
