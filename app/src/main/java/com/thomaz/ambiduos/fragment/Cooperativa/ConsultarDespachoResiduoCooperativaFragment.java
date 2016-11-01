package com.thomaz.ambiduos.fragment.Cooperativa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.ambiduos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarDespachoResiduoCooperativaFragment extends Fragment {


    public ConsultarDespachoResiduoCooperativaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consultar_despacho_residuo_cooperativa, container, false);
    }


    @Override
    public String toString() {
        return "Despacho de resíduo";
    }
}
