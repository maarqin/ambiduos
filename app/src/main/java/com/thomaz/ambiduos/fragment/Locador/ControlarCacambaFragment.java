package com.thomaz.ambiduos.fragment.Locador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.thomaz.ambiduos.EasyCreateRowActivity;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.dbs.DBHelperCacamba;
import com.thomaz.ambiduos.to.Cacamba;
import com.thomaz.ambiduos.to.StrategyOnClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlarCacambaFragment extends Fragment {

    private RecyclerView rvList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_simple_list_controlar, container, false);

        getActivity().setTitle(R.string.title_controlar_cacamba);

        rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        final EditText et_search = ((EditText) v.findViewById(R.id.et_search));
        et_search.setHint(R.string.hint_digite_buscar_cacamba);
        et_search.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

        v.findViewById(R.id.multiple_actions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EasyCreateRowActivity.class);
                intent.putExtra(EasyCreateRowActivity.LAYOUT, R.layout.layout_activity_cadastro);

                ActionCacamba am = new ActionCacamba();
                ActionCacamba.setActivity(getActivity());

                intent.putExtra(EasyCreateRowActivity.ACTION, am);

                startActivity(intent);
            }
        });


        v.findViewById(R.id.bt_buscar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( et_search.getText().toString().equals("") ) return;

                int id = Integer.parseInt(et_search.getText().toString());

                Cacamba c = ConsultarLocacoesFragment.buscarCacamba(id, getActivity());

                if( c.getId() < 0 ) {
                    Toast.makeText(getActivity(), getString(R.string.search_cacamba_nao_achada), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();

        final List<Cacamba> cacambas = new ArrayList<>();

        DBHelperCacamba helperCacamba = new DBHelperCacamba(getContext());

        ArrayList<HashMap<String, String>> maps = helperCacamba.all();

        for (HashMap<String, String> map : maps) {
            cacambas.add(new Cacamba(
                    Integer.parseInt(map.get(DBHelperCacamba.ID)),
                    map.get(DBHelperCacamba.NOME)
                    ));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(cacambas,
                R.layout.line_cacamba_controlar, rvList, getActivity()));
    }

    public static class ActionCacamba implements Parcelable, StrategyOnClick {

        private EditText et;
        static private Activity activity;

        protected ActionCacamba(Parcel in) {
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ActionCacamba> CREATOR = new Creator<ActionCacamba>() {
            @Override
            public ActionCacamba createFromParcel(Parcel in) {
                return new ActionCacamba(in);
            }

            @Override
            public ActionCacamba[] newArray(int size) {
                return new ActionCacamba[size];
            }
        };

        public static void setActivity(Activity activity) {
            ControlarCacambaFragment.ActionCacamba.activity = activity;
        }

        public ActionCacamba() {

        }

        @Override
        public void onClick(View view) {
            DBHelperCacamba helperCacamba = new DBHelperCacamba(activity);

            HashMap<String, String> map = new HashMap<>();

            map.put(DBHelperCacamba.NOME, et.getText().toString());

            helperCacamba.storeEach(map);

            activityClose.finish();
        }

        @Override
        public void setData(EditText et) {
            this.et = et;
        }

        static private Activity activityClose;

        @Override
        public void setToClose(Activity activity) {
            activityClose = activity;
        }


    }
}
