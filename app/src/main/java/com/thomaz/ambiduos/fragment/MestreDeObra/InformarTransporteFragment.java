package com.thomaz.ambiduos.fragment.MestreDeObra;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.dbs.DBHelperSolicitacaoCacamba;
import com.thomaz.ambiduos.dbs.DBHelperSolicitacaoTransporte;
import com.thomaz.ambiduos.support.UserDialog;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformarTransporteFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_informar_transporte, container, false);

        final EditText transp = ((EditText) v.findViewById(R.id.et_transp));
        transp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDialog dialog = UserDialog.getInstance();
                dialog.setItems(new CharSequence[]{"Transportes Silva", "Guanabara Caçambas", "Copag 021"});
                dialog.setText(transp);

                dialog.show(getActivity());

                dialog.setClean();
            }
        });

        v.findViewById(R.id.bt_enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelperSolicitacaoTransporte solicitacaoTransporte = new DBHelperSolicitacaoTransporte(getActivity());
                HashMap<String, String> map = new HashMap<>();

                map.put(DBHelperSolicitacaoTransporte.CACAMBA_ID, "-1");
                map.put(DBHelperSolicitacaoTransporte.COOPERATIVA, transp.getText().toString());

                solicitacaoTransporte.storeEach(map);

                UserDialog dialog = UserDialog.getInstance();

                dialog.setMessage("Solicitação enviada com sucesso!");
                dialog.setClickOkListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if( getActivity() != null ) getActivity().onBackPressed();
                    }
                });
                dialog.show(getActivity());

                dialog.setClean();
            }
        });


        return v;
    }


    @Override
    public String toString() {
        return "Informar transportadora";
    }
}
