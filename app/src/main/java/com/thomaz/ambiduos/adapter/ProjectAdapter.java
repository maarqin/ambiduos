package com.thomaz.ambiduos.adapter;

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

public class ProjectAdapter <TPI extends IAdapter> extends BaseAdapter<TPI, ProjectAdapter.ViewHolder> {

    public ProjectAdapter(@NonNull List<TPI> tpis, @LayoutRes int line) {
        super(tpis, line);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TPI project = tList.get(position);

        holder.nome.setText(project.getName());
        holder.endereco.setText(project.getSubTitle());
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private TextView endereco;

        private ViewHolder(View v) {
            super(v);

            nome = ((TextView) v.findViewById(R.id.tv_name_project));
            endereco = ((TextView) v.findViewById(R.id.tv_address_project));
        }
    }
}
