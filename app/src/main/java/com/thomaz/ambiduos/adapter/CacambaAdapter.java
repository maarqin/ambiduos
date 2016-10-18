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

public class CacambaAdapter<TPI extends IAdapter> extends BaseAdapter<TPI, CacambaAdapter.ViewHolder> {

    public CacambaAdapter(@NonNull List<TPI> tpis, @LayoutRes int line) {
        super(tpis, line);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TPI tpi = tList.get(position);

        holder.nome.setText(tpi.getName());
        holder.classe.setText(tpi.getIAdapter().getName());
        holder.total.setText(tpi.getValue() + " resíduos");
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private TextView classe;
        private TextView total;

        private ViewHolder(View v) {
            super(v);

            nome = ((TextView) v.findViewById(R.id.tv_nome_cacamba));
            classe = ((TextView) v.findViewById(R.id.tv_classe_cacamba));
            total = ((TextView) v.findViewById(R.id.tv_total_itens_cacamba));
        }
    }
}
