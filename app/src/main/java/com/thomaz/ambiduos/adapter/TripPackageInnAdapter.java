package com.thomaz.ambiduos.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.to.IAdapter;

import java.util.List;

/**
 * Created by thomaz on 04/10/16.
 */
public class TripPackageInnAdapter<TPI extends IAdapter> extends BaseAdapter<TPI, TripPackageInnAdapter.ViewHolder> {

    public TripPackageInnAdapter(@NonNull List<TPI> tpis, @LayoutRes int line) {
        super(tpis, line);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TPI tripPackage = tList.get(position);

        holder.city.setText(tripPackage.getName());
        holder.country.setText(tripPackage.getSubTitle());
        holder.value.setText(String.valueOf(tripPackage.getValue()));
        holder.ivBg.setColorFilter(Color.rgb(183, 183, 183), PorterDuff.Mode.MULTIPLY);
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivBg;
        private TextView city;
        private TextView country;
        private TextView value;

        private ViewHolder(View v) {
            super(v);

            ivBg = ((ImageView) v.findViewById(R.id.iv_bg_destino));
            city = ((TextView) v.findViewById(R.id.tv_cidade_destino));
            country = ((TextView) v.findViewById(R.id.tv_pais_destino));
            value = ((TextView) v.findViewById(R.id.tv_valor_destino));
        }
    }
}
