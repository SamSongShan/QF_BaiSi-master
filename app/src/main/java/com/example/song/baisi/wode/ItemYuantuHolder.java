package com.example.song.baisi.wode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.song.baisi.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ItemYuantuHolder extends RecyclerView.ViewHolder {
    private SimpleDraweeView simple;
    private TextView tv;

    public ItemYuantuHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.item_yuantu, parent, false));
    }

    public ItemYuantuHolder(View view) {
        super(view);
        simple = (SimpleDraweeView) view.findViewById(R.id.simple);
        tv = (TextView) view.findViewById(R.id.tv);
    }

    public SimpleDraweeView getSimple() {
        return simple;
    }

    public TextView getTv() {
        return tv;
    }
}
