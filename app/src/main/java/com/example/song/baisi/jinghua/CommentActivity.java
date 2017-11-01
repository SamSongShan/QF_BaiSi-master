package com.example.song.baisi.jinghua;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.song.baisi.ApiManger;
import com.example.song.baisi.IApiService;
import com.example.song.baisi.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class CommentActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private QuanBuEntity.ListEntity mBean;
    private CommentAdapter mAdapter;
    private String mId;
    private String mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent intent = getIntent();
        mBean = intent.getParcelableExtra("bean");
        mId = mBean.getId();
        mType = mBean.getType();
        assignViews();
        mSwRefresh.post(new Runnable() {
            @Override
            public void run() {
                mSwRefresh.setRefreshing(true);
                downLoadData();
            }
        });
        initView();
    }

    private LinearLayout mActivityComment;
    private SwipeRefreshLayout mSwRefresh;
    private ListView mLvComment;

    private void assignViews() {
        mActivityComment = (LinearLayout) findViewById(R.id.activity_comment);
        mSwRefresh = (SwipeRefreshLayout) findViewById(R.id.swRefresh);
        mLvComment = (ListView) findViewById(R.id.lv_comment);
        View view = LayoutInflater.from(this).inflate(R.layout.head_comment_lv, null, false);
        mLvComment.addHeaderView(view);
        assignViewsHead(view);
        initViewHead();
    }

    private void initViewHead() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mSimplePlay.getLayoutParams();

        layoutParams.width = getResources().getDisplayMetrics().widthPixels;

        if ("video".equals(mBean.getType())) {
            int width = mBean.getVideo().getWidth();
            int height = mBean.getVideo().getHeight();
            layoutParams.height = layoutParams.width * height / width;
            mSimplePlay.requestLayout();
            mSimplePlay.setLayoutParams(layoutParams);
            mSimplePlay.setImageURI(Uri.parse(mBean.getVideo().getThumbnail().get(0)));
            mLineContent.setVisibility(View.GONE);
        }else if ("text".equals(mBean.getType())){
            mImgPlay.setVisibility(View.GONE);
            mSimplePlay.setVisibility(View.GONE);
            mTvContent.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) mLineContent.getLayoutParams();
            Params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            mLineContent.setBackgroundColor(Color.parseColor("#ffffff"));
            mLineContent.setAlpha(1f);
            mLineContent.setLayoutParams(Params);
            String text = mBean.getText();
            mTvContent.setText(text);
        }else if ("gif".equals(mBean.getType())){
            int width = mBean.getGif().getWidth();
            int height = mBean.getGif().getHeight();
            layoutParams.height = layoutParams.width * height / width;
            mSimplePlay.requestLayout();
            mImgPlay.setVisibility(View.GONE);
            mTvContent.setVisibility(View.GONE);
            mSimplePlay.setVisibility(View.VISIBLE);
            mSimplePlay.setImageURI(Uri.parse(mBean.getGif().getGif_thumbnail().get(0)));
            DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                    .setAutoPlayAnimations(true)
                    //加载drawable里的一张gif图
                    .setUri(Uri.parse(mBean.getGif().getImages().get(0)))//设置uri
                    .build();
            //设置Controller
            mSimplePlay.setController(mDraweeController);
        }else if ("image".equals(mBean.getType())){
            mImgPlay.setVisibility(View.GONE);
            mSimplePlay.setVisibility(View.VISIBLE);

            mTvContent.setVisibility(View.GONE);

            int height = mBean.getImage().getHeight();
            int width = mBean.getImage().getWidth();
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) mSimplePlay.getLayoutParams();
            params1.width = getResources().getDisplayMetrics().widthPixels;

                params1.height = getResources().getDisplayMetrics().widthPixels * height / width;

            mSimplePlay.setLayoutParams(params1);
            GenericDraweeHierarchy hierarchy = mSimplePlay.getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
            hierarchy.setActualImageFocusPoint(new PointF(0, 0));


            mSimplePlay.setImageURI(Uri.parse(mBean.getImage().getBig().get(0)));
        }
        mSimpleHead.setImageURI(Uri.parse(mBean.getU().getHeader().get(0)));
        mTvRoomname.setText(mBean.getU().getName());
        mTvTime.setText(mBean.getPasstime());

    }

    private SimpleDraweeView mSimpleHead;
    private TextView mTvRoomname;
    private TextView mTvTime;
    private TextView mTvText;
    private RelativeLayout mRelatPlay;
    private SurfaceView mSf;
    private SimpleDraweeView mSimplePlay;
    private ImageView mImgPlay;
    private LinearLayout mLineContent;
    private TextView mTvContent;
    private RelativeLayout mLineDainzan;
    private ImageView mImgDianzan;
    private ImageView mImgDianzan1;
    private TextView mTvDianzan;
    private RelativeLayout mLineUndianzan;
    private ImageView mImgUndianzan;
    private ImageView mImgUndianzan1;
    private TextView mTvUndianzan;
    private RelativeLayout mLineFenxiang;
    private ImageView mImgFenxiang;
    private TextView mTvFenxiang;
    private RelativeLayout mLinePinglun;
    private ImageView mImgPinglun;
    private TextView mTvPinglun;

    private void assignViewsHead(View view) {
        mSimpleHead = (SimpleDraweeView) view.findViewById(R.id.simple_head);
        mTvRoomname = (TextView) view.findViewById(R.id.tv_roomname);
        mTvTime = (TextView) view.findViewById(R.id.tv_time);
        mTvText = (TextView) view.findViewById(R.id.tv_text);
        mRelatPlay = (RelativeLayout) view.findViewById(R.id.relat_play);
        mSf = (SurfaceView) view.findViewById(R.id.sf);
        mSimplePlay = (SimpleDraweeView) view.findViewById(R.id.simple_Play);
        mImgPlay = (ImageView) view.findViewById(R.id.img_play);
        mLineContent = (LinearLayout) view.findViewById(R.id.line_content);
        mTvContent = (TextView) view.findViewById(R.id.tv_content);
        mLineDainzan = (RelativeLayout) view.findViewById(R.id.line_dainzan);
        mImgDianzan = (ImageView) view.findViewById(R.id.img_dianzan);
        mImgDianzan1 = (ImageView) view.findViewById(R.id.img_dianzan_1);
        mTvDianzan = (TextView) view.findViewById(R.id.tv_dianzan);
        mLineUndianzan = (RelativeLayout) view.findViewById(R.id.line_undianzan);
        mImgUndianzan = (ImageView) view.findViewById(R.id.img_undianzan);
        mImgUndianzan1 = (ImageView) view.findViewById(R.id.img_undianzan_1);
        mTvUndianzan = (TextView) view.findViewById(R.id.tv_undianzan);
        mLineFenxiang = (RelativeLayout) view.findViewById(R.id.line_fenxiang);
        mImgFenxiang = (ImageView) view.findViewById(R.id.img_fenxiang);
        mTvFenxiang = (TextView) view.findViewById(R.id.tv_fenxiang);
        mLinePinglun = (RelativeLayout) view.findViewById(R.id.line_pinglun);
        mImgPinglun = (ImageView) view.findViewById(R.id.img_pinglun);
        mTvPinglun = (TextView) view.findViewById(R.id.tv_pinglun);
    }


    private void initView() {
        int[] lays = new int[]{R.layout.item_comment};
        mAdapter = new CommentAdapter(this, datas, prectsDatas, lays);
        mLvComment.setAdapter(mAdapter);
        mSwRefresh.setOnRefreshListener(this);
    }

    List<CommentListEntity.NormalEntity.ListEntityX> datas = new ArrayList<>();
    List<Precmts1Entity.NormalEntity.ListEntity> prectsDatas = new ArrayList<>();

    private void downLoadData() {
        IApiService api = ApiManger.creatStringApi(IApiService.COMMENT_BASE_URL);
        Call<String> commentTuiJian = api.getCommentTuiJian(mId);

        commentTuiJian.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body().toString();
                Gson gson = new Gson();
                CommentListEntity commentListEntity = gson.fromJson(s, CommentListEntity.class);
                List<CommentListEntity.NormalEntity.ListEntityX> list = commentListEntity.getNormal().getList();
                Precmts1Entity precmts1Entity = gson.fromJson(s, Precmts1Entity.class);
                List<Precmts1Entity.NormalEntity.ListEntity> list1 = precmts1Entity.getNormal().getList();

                if (list != null) {
                    if (isRefresh) {
                        prectsDatas.clear();
                        datas.clear();
                    }
                    datas.addAll(list);
                    prectsDatas.addAll(list1);
                    mAdapter.notifyDataSetChanged();
                    mSwRefresh.setRefreshing(false);
                    if (!"image".equals(mType)) {
                        mLvComment.setSelection(1);
                    }
                    isRefresh = false;
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                isRefresh = false;
                Toast.makeText(getBaseContext(), "网络错误,重新加载", Toast.LENGTH_SHORT).show();
                mSwRefresh.setRefreshing(false);

            }
        });
    }

    boolean isRefresh = false;

    @Override
    public void onRefresh() {
        isRefresh = true;
        downLoadData();
    }
}
