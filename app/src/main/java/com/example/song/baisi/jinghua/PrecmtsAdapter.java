package com.example.song.baisi.jinghua;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.song.baisi.CommonAdapter;
import com.example.song.baisi.R;

import java.util.List;

/**
 * Created by 11355 on 2016/12/4.
 */

public class PrecmtsAdapter extends CommonAdapter<Precmts1Entity.NormalEntity.ListEntity.PrecmtsEntity> implements View.OnClickListener {

    private final Context mContext;
    private final List<Precmts1Entity.NormalEntity.ListEntity.PrecmtsEntity> mData;
    private final int[] mLayoutId;

    public PrecmtsAdapter(Context context, List<Precmts1Entity.NormalEntity.ListEntity.PrecmtsEntity> data, int... layoutId) {
        super(context, data, layoutId);
        mContext = context;
        mData = data;
        mLayoutId = layoutId;
    }

    @Override
    public void bindData(int position, viewHolder mHolder) {

        assignViews(mHolder.mView);
        initView(position);
    }

    private void initView(int position) {


        if (mData != null && mData.size() != 0) {
            mImgAnothercommentNum.setText(mData.get(position).getFloor() + "");
            mTvAnothercommentRoomname.setText(mData.get(position).getUser().getUsername());
            mTvAnothercommentNumDZ.setText(mData.get(position).getLike_count() + "");
            mTvAnothercommentComment.setText(mData.get(position).getContent());

            mImgAnothercommentDianzan.setSelected(false);

            mImgAnothercommentDianzan.setOnClickListener(this);
            mImgAnothercommentDianzan.setTag(-1-position,mImgAnothercommentDianzan1);
            mImgAnothercommentDianzan.setTag(-2-position,mTvAnothercommentNumDZ);
            mImgAnothercommentDianzan.setTag(position);

        }
    }

    private TextView mImgAnothercommentNum;
    private TextView mTvAnothercommentRoomname;
    private TextView mTvAnothercommentNumDZ;
    private ImageView mImgAnothercommentDianzan;
    private ImageView mImgAnothercommentDianzan1;
    private TextView mTvAnothercommentComment;

    private void assignViews(View view) {
        mImgAnothercommentNum = (TextView) view.findViewById(R.id.img_anothercomment_num);
        mTvAnothercommentRoomname = (TextView) view.findViewById(R.id.tv_anothercomment_roomname);
        mTvAnothercommentNumDZ = (TextView) view.findViewById(R.id.tv_anothercomment_numDZ);
        mImgAnothercommentDianzan = (ImageView) view.findViewById(R.id.img_anothercomment_dianzan);
        mImgAnothercommentDianzan1 = (ImageView) view.findViewById(R.id.img_anothercomment_dianzan1);
        mTvAnothercommentComment = (TextView) view.findViewById(R.id.tv_anothercomment_comment);

    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.img_anothercomment_dianzan: {
                mImgAnothercommentDianzan.setSelected(true);
                int tag = (int) v.getTag();
                final ImageView tag1 = (ImageView) v.getTag(-1 - tag);
                TextView tag2 = (TextView) v.getTag(-2 - tag);
                tag2.setText(Integer.parseInt(String.valueOf(tag2.getText()))+1+"");
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
