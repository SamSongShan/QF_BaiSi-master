package com.example.song.baisi.wode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.song.baisi.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ItemDingyueHolder extends RecyclerView.ViewHolder {
    private SimpleDraweeView simpleHead;
    private TextView tvType;
    private TextView tvNum;
    private ImageView imgGuanzhu;

    public ItemDingyueHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.item_dingyue, parent, false));
    }

    public ItemDingyueHolder(View view) {
        super(view);
        simpleHead = (SimpleDraweeView) view.findViewById(R.id.simple_head);
        tvType = (TextView) view.findViewById(R.id.tv_type);
        tvNum = (TextView) view.findViewById(R.id.tv_num);
        imgGuanzhu = (ImageView) view.findViewById(R.id.img_guanzhu);
    }

    public TextView getTvType() {
        return tvType;
    }

    public ImageView getImgGuanzhu() {
        return imgGuanzhu;
    }

    public TextView getTvNum() {
        return tvNum;
    }

    public SimpleDraweeView getSimpleHead() {
        return simpleHead;
    }
}
