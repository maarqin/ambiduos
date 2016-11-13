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
import com.thomaz.ambiduos.support.UserDialog;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformarCacambaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_informar_cacamba, container, false);

        getActivity().setTitle(R.string.title_informar_local);

        final EditText text = ((EditText) v.findViewById(R.id.et_locadora));

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDialog dialog = UserDialog.getInstance();
                dialog.setItems(new CharSequence[]{"Mujica", "Emoclew", "Lareg"});
                dialog.setText(text);

                dialog.show(getActivity());

                dialog.setClean();
            }
        });

        final EditText qtde = ((EditText) v.findViewById(R.id.et_qtde));

        v.findViewById(R.id.bt_enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelperSolicitacaoCacamba helperSolicitacaoCacamba = new DBHelperSolicitacaoCacamba(getActivity());
                HashMap<String, String> map = new HashMap<>();

                map.put(DBHelperSolicitacaoCacamba.OBRA, "-1");
                map.put(DBHelperSolicitacaoCacamba.LOCADORA, text.getText().toString());
                map.put(DBHelperSolicitacaoCacamba.QTDE_CACAMBA, qtde.getText().toString());

                helperSolicitacaoCacamba.storeEach(map);

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

}
