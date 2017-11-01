package com.example.song.baisi.jinghua;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.song.baisi.IApiService;
import com.example.song.baisi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JingHuaFragment extends Fragment {


    private View mView;

    public JingHuaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mView==null){
            mView = inflater.inflate(R.layout.fragment_jing_hua, container, false);
            assignViews(mView);

        }
        return mView;
    }

    private TabLayout mTab;
    private ViewPager mViewpager;

    private void assignViews(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);

        initView();
    }

    private void initView() {
        final String[] titles = new String[]{"推荐", "视频", "图片", "段子", "排行","社会","美女","冷知识","游戏","网红"};
        final List<Fragment> fragments = new ArrayList<>();
        final String[] baseUrl=new String[]{IApiService.TJ_PATH,IApiService.SP_PATH,IApiService.TP_PATH,IApiService.DZ_PATH,IApiService.PH_PATH,IApiService.SH_PATH,IApiService.MN_PATH,IApiService.LZS_PATH,IApiService.YX_PATH,IApiService.WH_PATH};
        for (int i = 0; i < titles.length; i++) {
            QuanBuFragment fragment = new QuanBuFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("part",1);
            bundle.putString("baseUrl",baseUrl[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        mViewpager.setAdapter(new MyViewpagerAdapter(getChildFragmentManager(),fragments,titles));
        mTab.setupWithViewPager(mViewpager);
    }
    class MyViewpagerAdapter extends FragmentStatePagerAdapter{

        private final FragmentManager mFm;
        private final List<Fragment> mFragments;
        private final String[] mTitles;

        public MyViewpagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
            super(fm);
            mFm = fm;
            mFragments = fragments;
            mTitles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

}
