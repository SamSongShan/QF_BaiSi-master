package com.example.song.baisi.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.song.baisi.R;
import com.example.song.baisi.fabiao.FaBiaoActivity;
import com.example.song.baisi.guanzhu.GuanZhuFragment;
import com.example.song.baisi.jinghua.JingHuaFragment;
import com.example.song.baisi.wode.WoDeFragment;
import com.example.song.baisi.xintie.XinTieFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }


    private LinearLayout mActivityMain;
    private FrameLayout mFrame;
    private RelativeLayout mRelatJinghua;
    private ImageView mImgJinghua;
    private TextView mTvJinghua;
    private RelativeLayout mRelatXintie;
    private ImageView mImgXintie;
    private TextView mTvXintie;
    private ImageView mImgFabiao;
    private RelativeLayout mRelatGuanzhu;
    private ImageView mImgGuanzhu;
    private TextView mTvGuanzhu;
    private RelativeLayout mRelatWode;
    private ImageView mImgWode;
    private TextView mTvWode;

    private void assignViews() {
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mRelatJinghua = (RelativeLayout) findViewById(R.id.relat_jinghua);
        mImgJinghua = (ImageView) findViewById(R.id.img_jinghua);
        mTvJinghua = (TextView) findViewById(R.id.tv_jinghua);
        mRelatXintie = (RelativeLayout) findViewById(R.id.relat_xintie);
        mImgXintie = (ImageView) findViewById(R.id.img_xintie);
        mTvXintie = (TextView) findViewById(R.id.tv_xintie);
        mImgFabiao = (ImageView) findViewById(R.id.img_fabiao);
        mRelatGuanzhu = (RelativeLayout) findViewById(R.id.relat_guanzhu);
        mImgGuanzhu = (ImageView) findViewById(R.id.img_guanzhu);
        mTvGuanzhu = (TextView) findViewById(R.id.tv_guanzhu);
        mRelatWode = (RelativeLayout) findViewById(R.id.relat_wode);
        mImgWode = (ImageView) findViewById(R.id.img_wode);
        mTvWode = (TextView) findViewById(R.id.tv_wode);
        mImgFabiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FaBiaoActivity.class));
            }
        });
        initView();
    }


    private void initView() {
        mImgJinghua.setSelected(true);
        mTvJinghua.setSelected(true);
        mRelatJinghua.setOnClickListener(this);
        mRelatJinghua.setTag(0);
        mRelatXintie.setOnClickListener(this);
        mRelatXintie.setTag(1);
        mRelatGuanzhu.setOnClickListener(this);
        mRelatGuanzhu.setTag(2);
        mRelatWode.setOnClickListener(this);
        mRelatWode.setTag(3);
        mFragments = new ArrayList<>();
        mFragments.add(new JingHuaFragment());
        mFragments.add(new XinTieFragment());
        mFragments.add(new GuanZhuFragment());
        mFragments.add(new WoDeFragment());
        //getSupportFragmentManager().beginTransaction().replace(R.id.frame, new JingHuaFragment()).commit();
        changeTab(0);
    }

    private Fragment mCurrentFrgment;
    private int currentIndex = 0;

    private void changeTab(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentFrgment != null) {
            fragmentTransaction.hide(mCurrentFrgment);
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(mFragments.get(i).getClass().getName());
        if (fragment == null) {
            fragment = mFragments.get(i);
        }
        mCurrentFrgment = fragment;
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.frame, fragment, fragment.getClass().getName());
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        setUnselect();
        int tag = (int) v.getTag();

        switch (v.getId()) {
            case R.id.relat_jinghua:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new JingHuaFragment()).commit();
                mImgJinghua.setSelected(true);
                mTvJinghua.setSelected(true);
                break;
            case R.id.relat_xintie:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new XinTieFragment()).commit();

                mImgXintie.setSelected(true);
                mTvXintie.setSelected(true);
                break;
            case R.id.relat_guanzhu:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new GuanZhuFragment()).commit();

                mImgGuanzhu.setSelected(true);
                mTvGuanzhu.setSelected(true);
                break;

            case R.id.relat_wode:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new WoDeFragment()).commit();

                mImgWode.setSelected(true);
                mTvWode.setSelected(true);
                break;
        }
        changeTab(tag);
    }

    private void setUnselect() {
        mImgJinghua.setSelected(false);
        mImgXintie.setSelected(false);
        mImgGuanzhu.setSelected(false);
        mImgWode.setSelected(false);

        mTvJinghua.setSelected(false);
        mTvXintie.setSelected(false);
        mTvGuanzhu.setSelected(false);
        mTvWode.setSelected(false);


    }
}
