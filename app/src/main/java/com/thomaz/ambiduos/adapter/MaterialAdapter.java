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

public class MaterialAdapter<TPI extends IAdapter> extends BaseAdapter<TPI, MaterialAdapter.ViewHolder> {


    public MaterialAdapter(@NonNull List<TPI> tpis, @LayoutRes int line, RecyclerView rv, Activity a) {
        super(tpis, line, rv, a);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TPI tpi = tList.get(position);

        holder.material.setText(tpi.getName());
        holder.un.setText(tpi.getValue() + " " + tpi.getIAdapter().getName());
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView material;
        private TextView un;

        private ViewHolder(View v) {
            super(v);

            material = ((TextView) v.findViewById(R.id.tv_material_nome));
            un = ((TextView) v.findViewById(R.id.tv_un_material));
        }
    }
}
