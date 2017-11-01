package com.example.song.baisi.jinghua;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.song.baisi.ApiManger;
import com.example.song.baisi.IApiService;
import com.example.song.baisi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuanBuFragment extends Fragment implements AbsListView.OnScrollListener, SwipeRefreshLayout.OnRefreshListener {


    private static final String TAG = "tag";
    private QuanbuAdapter mAdapter;
    private SwipeRefreshLayout mSwRefresh;
    private String mBaseUrl;
    private int mPart;
    private Call<QuanBuEntity> mTuijian;
    private Call<QuanBuEntity> mTuijian1;

    public QuanBuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quan_bu, container, false);
        Bundle bundle = getArguments();
        mBaseUrl = bundle.getString("baseUrl");
        mPart = bundle.getInt("part");
        assignViews(view);
        return view;
    }

    private ListView mLv;
    private List<QuanBuEntity.ListEntity> datas = new ArrayList<>();

    private void assignViews(View view) {
        mLv = (ListView) view.findViewById(R.id.lv);
        mSwRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swRefresh);


        initView();
    }

    private void initView() {
        mAdapter = new QuanbuAdapter(getContext(), datas, R.layout.item_shipin, R.layout.itme_gif, R.layout.item_photo, R.layout.item_shipin, R.layout.itme_html);

        mLv.setAdapter(mAdapter);
        mSwRefresh.setOnRefreshListener(this);
        mLv.setOnScrollListener(this);
        mSwRefresh.post(new Runnable() {
            @Override
            public void run() {
                mSwRefresh.setRefreshing(true);
                downLoadData();
            }
        });

    }

    private int json = 5;

    private void downLoadData() {
        IApiService iApiService = ApiManger.creatApi(mBaseUrl);
        if (mPart==1){
            mTuijian = iApiService.getTuijian(json+"");

        }else {
            mTuijian =iApiService.getTuijian(json+"");
        }
        mTuijian1 = mTuijian;
        mTuijian1.enqueue(new Callback<QuanBuEntity>() {
            @Override
            public void onResponse(Call<QuanBuEntity> call, Response<QuanBuEntity> response) {
                List<QuanBuEntity.ListEntity> list = response.body().getList();
                if (isRefresh && list.size() != 0) {
                    datas.clear();

                    isRefresh = false;

                }

                for (int i =list.size()-5; i < list.size(); i++) {
                    datas.add(list.get(i));
                }

                mAdapter.notifyDataSetChanged();
                mSwRefresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<QuanBuEntity> call, Throwable t) {
                Toast.makeText(getContext(), "加载失败,网络异常", Toast.LENGTH_SHORT).show();
                mSwRefresh.setRefreshing(false);

            }
        });
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (isButton && scrollState == SCROLL_STATE_IDLE) {
            isButton = false;
            json = json+5;
            downLoadData();
        }

    }

    private boolean isButton = false;

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mAdapter.oldPosition != -1) {
            if (firstVisibleItem > mAdapter.oldPosition || firstVisibleItem + visibleItemCount < mAdapter.oldPosition) {
                mAdapter.onScroll();
            }
        }
        if (firstVisibleItem + visibleItemCount == totalItemCount) {
            isButton = true;
        }

    }

    private boolean isRefresh = false;

    @Override
    public void onRefresh() {
        isRefresh = true;
        json = 5;
        downLoadData();
    }


}
