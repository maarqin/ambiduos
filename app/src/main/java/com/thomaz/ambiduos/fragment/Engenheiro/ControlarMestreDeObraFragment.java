package com.thomaz.ambiduos.fragment.Engenheiro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.thomaz.ambiduos.EasyCreateRowActivity;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.adapter.SimpleDataAdapter;
import com.thomaz.ambiduos.dbs.DBHelperMestreObra;
import com.thomaz.ambiduos.to.CustomClick;
import com.thomaz.ambiduos.to.MestreDeObra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlarMestreDeObraFragment extends Fragment {

    private RecyclerView rvList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_simple_list_controlar, container, false);

        rvList = ((RecyclerView) v.findViewById(R.id.list_simple_view));

        rvList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);

        v.findViewById(R.id.multiple_actions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EasyCreateRowActivity.class);
                intent.putExtra(EasyCreateRowActivity.LAYOUT, R.layout.layout_activity_cadastro_mestre);

                ActionMestre am = new ActionMestre();
                ActionMestre.setActivity(getActivity());

                intent.putExtra(EasyCreateRowActivity.ACTION, am);

                startActivity(intent);
            }
        });


        return v;

    }

    @Override
    public void onResume() {
        super.onResume();



        final List<MestreDeObra> mestreDeObras = new ArrayList<>();

        DBHelperMestreObra dbHelperMestreObra = new DBHelperMestreObra(getContext());

        ArrayList<HashMap<String, String>> maps = dbHelperMestreObra.all();

        for (HashMap<String, String> map : maps) {
            mestreDeObras.add(new MestreDeObra(map.get(DBHelperMestreObra.NOME)));
        }

        rvList.setAdapter(new SimpleDataAdapter<>(mestreDeObras,
                R.layout.line_simple, rvList, getActivity()));
    }

    @Override
    public String toString() {
        return "Mestre de obra";
    }


    public static class ActionMestre implements Parcelable, CustomClick {

        private EditText et;
        static private Activity activity;

        public static void setActivity(Activity activity) {
            ActionMestre.activity = activity;
        }

        public ActionMestre() {
        }

        protected ActionMestre(Parcel in) {
        }

        public static final Creator<ActionMestre> CREATOR = new Creator<ActionMestre>() {
            @Override
            public ActionMestre createFromParcel(Parcel in) {
                return new ActionMestre(in);
            }

            @Override
            public ActionMestre[] newArray(int size) {
                return new ActionMestre[size];
            }
        };

        @Override
        public void onClick(View view) {
            DBHelperMestreObra helperMestreObra = new DBHelperMestreObra(activity);

            HashMap<String, String> map = new HashMap<>();

            map.put(DBHelperMestreObra.NOME, et.getText().toString());

            helperMestreObra.storeEach(map);

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
        }
    }
}
