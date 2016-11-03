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
 * Created by thomaz on 02/11/16.
 */
public class SimpleDataAdapter<TPI extends IAdapter> extends BaseAdapter<TPI, SimpleDataAdapter.ViewHolder> {


    public SimpleDataAdapter(@NonNull List<TPI> list, @LayoutRes int line, RecyclerView rv, Activity a) {
        super(list, line, rv, a);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TPI tpi = tList.get(position);

        holder.um.setText(tpi.getName());
        holder.dois.setText(tpi.getSubTitle());
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView um;
        private TextView dois;

        public ViewHolder(View v) {
            super(v);

            um = ((TextView) v.findViewById(R.id.tv_um));
            dois = ((TextView) v.findViewById(R.id.tv_dois));
        }
    }
}
