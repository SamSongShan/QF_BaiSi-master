package com.example.song.baisi.jinghua;

import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.song.baisi.CommonAdapter;
import com.example.song.baisi.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 11355 on 2016/12/4.
 */

public class CommentAdapter extends CommonAdapter<CommentListEntity.NormalEntity.ListEntityX> implements View.OnClickListener {

    private final Context mContext;
    private final List<CommentListEntity.NormalEntity.ListEntityX> mData;
    private List<Precmts1Entity.NormalEntity.ListEntity> mPrectsDatas;
    private final int[] mLayoutId;
    private PrecmtsAdapter mAdapter;

    public CommentAdapter(Context context, List<CommentListEntity.NormalEntity.ListEntityX> data, List<Precmts1Entity.NormalEntity.ListEntity> prectsDatas, int[] layoutId) {
        super(context, data, layoutId);
        mContext = context;
        mData = data;
        mPrectsDatas = prectsDatas;
        mLayoutId = layoutId;
    }



    @Override
    public void bindData(int position, viewHolder mHolder) {
        assignViews(mHolder.mView);
        initView(position);
    }

    private void initView(int position) {

        mSimpleHead.setImageURI(Uri.parse(mData.get(position).getUser().getProfile_image()));
        mTvRoomname.setText(mData.get(position).getUser().getUsername());
        mTvNum.setText(mData.get(position).getLike_count()+"");
        if ("text".equals(mData.get(position).getType())) {
            mTvCommentContext.setText(mData.get(position).getContent());
        }
        if ("m".equals(mData.get(position).getUser().getSex())) {
            mImgSex.setImageResource(R.drawable.personal_sex_men);
        } else {
            mImgSex.setImageResource(R.drawable.personal_sex_women);

        }
        mImgDianzan.setOnClickListener(this);
        mImgDianzan.setTag(position);
        mImgDianzan.setTag(-1-position,mTvNum);
        mImgDianzan.setTag(-2-position,mImgDianzan1);
        mImgDianzan.setClickable(true);
        mImgDianzan.setSelected(false);

        mAdapter = new PrecmtsAdapter(mContext, mPrectsDatas.get(position).getPrecmts(), R.layout.item_auther_comment);
        mLvanothercomment.setAdapter(mAdapter);
        setListViewHeightBasedOnChildren(mLvanothercomment);
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight() + listItem.getPaddingBottom() + listItem.getPaddingTop(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    private SimpleDraweeView mSimpleHead;
    private ImageView mImgSex;
    private TextView mTvRoomname;
    private TextView mTvNum;
    private ImageView mImgDianzan;
    private ListView mLvanothercomment;
    private ImageView mImgDianzan1;
    private TextView mTvCommentContext;

    private void assignViews(View view) {
        mSimpleHead = (SimpleDraweeView) view.findViewById(R.id.simple_head);
        mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        mTvRoomname = (TextView) view.findViewById(R.id.tv_roomname);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
        mImgDianzan = (ImageView) view.findViewById(R.id.img_dianzan);
        mImgDianzan1 = (ImageView) view.findViewById(R.id.img_dianzan1);
        mLvanothercomment = (ListView) view.findViewById(R.id.lv_anothercomment);
        mTvCommentContext = (TextView) view.findViewById(R.id.tv_comment_context);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_dianzan: {
                int tag2 = (int) v.getTag();
                TextView tag = (TextView) v.getTag(-1-tag2);
                final ImageView tag1 = (ImageView) v.getTag(-2-tag2);
                tag.setText(1+Integer.valueOf(String.valueOf(tag.getText()))+"");
                v.setSelected(true);
                v.setClickable(false);
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_dianzan);
                tag1.setAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        tag1.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        tag1.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
            break;
        }
    }
}
