package com.example.song.baisi.xintie;


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
import com.example.song.baisi.jinghua.QuanBuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class XinTieFragment extends Fragment {


    public XinTieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xin_tie, container, false);
        assignViews(view);
        return view;
    }

    private TabLayout mTab;
    private ViewPager mViewpager;

    private void assignViews(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);

        initView();
    }

    private void initView() {
        final String[] titles = new String[]{"全部", "视频", "图片", "段子", "美女","冷知识","游戏","网红"};
        final List<Fragment> fragments = new ArrayList<>();
        final String[] baseUrl=new String[]{IApiService.NEW_ZX_PATH,IApiService.NEW_SP_PATH,IApiService.NEW_TP_PATH,IApiService.NEW_DZ_PATH,IApiService.NEW_MN_PATH,IApiService.NEW_LZS_PATH,IApiService.NEW_YX_PATH,IApiService.NEW_WH_PATH};
        for (int i = 0; i < titles.length; i++) {
            TuiJianFragment fragment = new TuiJianFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("part",2);
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
