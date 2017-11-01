package com.example.song.baisi.wode;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.song.baisi.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * A simple {@link Fragment} subclass.
 */
public  class WoDeFragment extends Fragment {


    public WoDeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wo_de, container, false);
        assignViews(view);
        initView();
        return view;
    }

    private void initView() {
    }

    private SimpleDraweeView mRlHead;
    private RecyclerView mRvYuantu;
    private ImageView mImg1;
    private TextView mTv;
    private ImageView mImg2;
    private RecyclerView mRvDingyue;

    private void assignViews(View view) {
        mRlHead = (SimpleDraweeView) view.findViewById(R.id.rl_head);
        mRvYuantu = (RecyclerView) view.findViewById(R.id.rv_yuantu);
        mImg1 = (ImageView) view.findViewById(R.id.img_1);
        mTv = (TextView) view.findViewById(R.id.tv);
        mImg2 = (ImageView) view.findViewById(R.id.img_2);
        mRvDingyue = (RecyclerView) view.findViewById(R.id.rv_dingyue);
    }


}
