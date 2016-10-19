package com.thomaz.ambiduos.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.thomaz.ambiduos.R;
import com.thomaz.ambiduos.to.IAdapter;

import java.util.List;

/**
 * Created by thomaz on 04/10/16.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> tList;
    private int line;

    public BaseAdapter(@NonNull List<T> tList, @LayoutRes int line, RecyclerView rv, Activity a) {
        this.tList = tList;
        this.line = line;

        Drawable dividerDrawable = ContextCompat.getDrawable(a, R.drawable.divider_line);
        rv.addItemDecoration(new DividerItemDecoration(dividerDrawable));
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(line, parent, false);

        return getViewHolder(v);
    }

    @Override
    public abstract void onBindViewHolder(VH holder, int position);

    @Override
    public int getItemCount() {
        return tList.size();
    }

    /**
     * @param v View
     * @return VH
     */
    protected abstract VH getViewHolder(View v);

}
