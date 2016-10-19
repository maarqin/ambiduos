package com.thomaz.ambiduos.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.to.IAdapter;

import java.util.List;

/**
 * Created by thomaz on 16/10/16.
 */

public class ResiduoAdapter<TPI extends IAdapter> extends BaseAdapter<TPI, ResiduoAdapter.ViewHolder> {


    public ResiduoAdapter(@NonNull List<TPI> tpis, @LayoutRes int line, RecyclerView rv, Activity a) {
        super(tpis, line, rv, a);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TPI tpi = tList.get(position);

        holder.classe.setText(tpi.getDescription());
        holder.material.setText(tpi.getName());
        holder.qtde.setText(tpi.getValue() + " UN");
        holder.id.setText(tpi.getIAdapter().getName());
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView classe;
        private TextView material;
        private TextView qtde;
        private TextView id;

        private ViewHolder(View v) {
            super(v);

            classe = ((TextView) v.findViewById(R.id.tv_classe));
            material = ((TextView) v.findViewById(R.id.tv_material_cacamba));
            qtde = ((TextView) v.findViewById(R.id.tv_quantidade_cacamba));
            id = ((TextView) v.findViewById(R.id.tv_id_cacamba));
        }
    }
}
