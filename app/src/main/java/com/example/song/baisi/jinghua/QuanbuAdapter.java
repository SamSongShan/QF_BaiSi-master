package com.example.song.baisi.jinghua;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.song.baisi.CommonAdapter;
import com.example.song.baisi.R;
import com.example.song.baisi.widget.MixtureTextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletionService;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import retrofit2.Callback;

/**
 * Created by 11355 on 2016/11/28.
 */

public class QuanbuAdapter extends CommonAdapter<QuanBuEntity.ListEntity> implements View.OnClickListener, MediaPlayer.OnPreparedListener, SurfaceHolder.Callback {


    public static final int TYPE_VIDEO = 0;
    public static final int TYPE_GIF = 1;
    public static final int TYPE_PHOTO = 2;
    public static final int TYPE_TEXT = 3;
    public static final int TYPE_HTML = 4;
    private final Context mContext;
    private final List<QuanBuEntity.ListEntity> mData;
    private final int[] mLayoutId;
    private MediaPlayer mMediaPlayer;
    private SimpleDraweeView mSimplePlay;
    private RelativeLayout mRelatPlay;
    private SimpleDraweeView mSimpleDraweeView;
    private TextView mTvContent;
    private LinearLayout mLineContent;
    private TextView mTvCommentName;
    private TextView mTvCommentcontext;
    private ImageView mImgUnDianZan1;
    private ImageView mImgDianZan1;
    private ImageView mDianzan1;
    private TextView mTv;
    private ImageView mDaizan;
    private ImageView mUnDianzan1;
    private TextView mUnTV;
    private ImageView mUnDaizan;

    public QuanbuAdapter(Context context, List<QuanBuEntity.ListEntity> data, int... layoutId) {
        super(context, data, layoutId);
        mContext = context;
        mData = data;
        mLayoutId = layoutId;
        ShareSDK.initSDK(mContext, "19a24e5b173ac");
    }

    @Override
    public void bindData(int position, viewHolder mHolder) {
        switch (getItemViewType(position)) {
            case TYPE_VIDEO:
                assignViewsVedio(mHolder);
                initViewVedio(position);
                break;
            case TYPE_GIF:
                break;
            case TYPE_PHOTO:
                break;
            case TYPE_TEXT:
                break;
            case TYPE_HTML:
                break;
        }
    }

    private SimpleDraweeView mSimpleHaed;
    private TextView mTvRoomname;
    private TextView mTvTime;
    private TextView mTvText;
    private SurfaceView mSf;
    private RelativeLayout mLineDainzan;
    private ImageView mImgDianzan;
    private TextView mTvDianzan;
    private RelativeLayout mLineUndianzan;
    private ImageView mImgUndianzan;
    private TextView mTvUndianzan;
    private RelativeLayout mLineFenxiang;
    private ImageView mImgFenxiang;
    private TextView mTvFenxiang;
    private RelativeLayout mLinePinglun;
    private ImageView mImgPinglun;
    private TextView mTvPinglun;
    private ListView mLv;
    private ImageView mImgPlay;

    private void assignViewsVedio(viewHolder view) {

        mRelatPlay = (RelativeLayout) view.mView.findViewById(R.id.relat_play);

        mSimplePlay = (SimpleDraweeView) view.mView.findViewById(R.id.simple_Play);
        mSimpleHaed = (SimpleDraweeView) view.mView.findViewById(R.id.simple_head);
        mTvRoomname = (TextView) view.mView.findViewById(R.id.tv_roomname);
        mTvTime = (TextView) view.mView.findViewById(R.id.tv_time);
        mTvText = (TextView) view.mView.findViewById(R.id.tv_text);
        mSf = (SurfaceView) view.mView.findViewById(R.id.sf);
        mLineDainzan = (RelativeLayout) view.mView.findViewById(R.id.line_dainzan);
        mImgDianzan = (ImageView) view.mView.findViewById(R.id.img_dianzan);
        mTvDianzan = (TextView) view.mView.findViewById(R.id.tv_dianzan);
        mLineUndianzan = (RelativeLayout) view.mView.findViewById(R.id.line_undianzan);
        mImgUndianzan = (ImageView) view.mView.findViewById(R.id.img_undianzan);
        mTvUndianzan = (TextView) view.mView.findViewById(R.id.tv_undianzan);
        mLineFenxiang = (RelativeLayout) view.mView.findViewById(R.id.line_fenxiang);
        mImgFenxiang = (ImageView) view.mView.findViewById(R.id.img_fenxiang);
        mTvFenxiang = (TextView) view.mView.findViewById(R.id.tv_fenxiang);
        mLinePinglun = (RelativeLayout) view.mView.findViewById(R.id.line_pinglun);
        mImgPinglun = (ImageView) view.mView.findViewById(R.id.img_pinglun);
        mTvPinglun = (TextView) view.mView.findViewById(R.id.tv_pinglun);
        mLv = (ListView) view.mView.findViewById(R.id.lv);
        mImgPlay = (ImageView) view.mView.findViewById(R.id.img_play);
        mTvContent = (TextView) view.mView.findViewById(R.id.tv_content);
        mLineContent = (LinearLayout) view.mView.findViewById(R.id.line_content);
        mImgDianZan1 = (ImageView) view.mView.findViewById(R.id.img_dianzan_1);
        mImgUnDianZan1 = (ImageView) view.mView.findViewById(R.id.img_undianzan_1);
    }

    public int oldPosition = -1;
    int num = 0;

    private void initViewVedio(int position) {
        final RelativeLayout.LayoutParams paramsAll = (RelativeLayout.LayoutParams) mSf.getLayoutParams();
        paramsAll.width = 0;
        paramsAll.height = 0;
        mSf.setLayoutParams(paramsAll);

        //视频设置
        if (mData.get(position).getType().equals("video")) {
            mTvContent.setVisibility(View.GONE);
            mImgPlay.setVisibility(View.VISIBLE);
            mSimplePlay.setVisibility(View.VISIBLE);
            //设置视宽高
            int height = mData.get(position).getVideo().getHeight();
            int width = mData.get(position).getVideo().getWidth();
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mSf.getLayoutParams();
            params.width = mContext.getResources().getDisplayMetrics().widthPixels;
            if (mContext.getResources().getDisplayMetrics().widthPixels * height / width < 1000) {
                params.height = mContext.getResources().getDisplayMetrics().widthPixels * height / width;
            } else {
                params.height = 1000;
            }
            mSf.setLayoutParams(params);
            //设置遮挡图片宽高
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) mSimplePlay.getLayoutParams();
            params1.width = mContext.getResources().getDisplayMetrics().widthPixels;
            if (mContext.getResources().getDisplayMetrics().widthPixels * height / width < 1000) {
                params1.height = mContext.getResources().getDisplayMetrics().widthPixels * height / width;
            } else {
                params1.height = 1000;
            }
            mSimplePlay.setLayoutParams(params1);
            mSimplePlay.setImageURI(Uri.parse(mData.get(position).getVideo().getThumbnail().get(0)));
            String url = mData.get(position).getVideo().getVideo().get(0);
            if (position == oldPosition) {
                if (mData.get(position).getType().equals("video")) {
                    if (isfirst) {
                        if (mMediaPlayer != null) {
                            mMediaPlayer.stop();
                            mMediaPlayer.release();
                        }
                        mMediaPlayer = new MediaPlayer();
                        mMediaPlayer.setOnPreparedListener(this);
                        SurfaceHolder holder = mSf.getHolder();
                        holder.addCallback(this);


                        try {
                            mMediaPlayer.setDataSource(mContext, Uri.parse(url));
                            mMediaPlayer.prepareAsync();
                            mSf.setVisibility(View.VISIBLE);
                            mImgPlay.setVisibility(View.GONE);
                            mSimplePlay.setVisibility(View.GONE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (mMediaPlayer.isPlaying()) {
                            mMediaPlayer.start();
                        } else {
                            mMediaPlayer.start();
                            mImgPlay.setVisibility(View.GONE);
                            mSimplePlay.setVisibility(View.GONE);
                        }
                    }
                } else {
                    if (mMediaPlayer != null) {
                        mMediaPlayer.start();
                        isfirst = true;
                    }
                }


            } else {
                mSf.setVisibility(View.INVISIBLE);
                mImgPlay.setVisibility(View.VISIBLE);
                mSimplePlay.setVisibility(View.VISIBLE);
            }
            mImgPlay.setTag(position);
            mRelatPlay.setOnClickListener(this);
            mRelatPlay.setTag(-2, mImgPlay);
            mRelatPlay.setTag(-1, mData.get(position).getType());
            mImgPlay.setOnClickListener(this);
        }
        //文字部分
        if (mData.get(position).getType().equals("text")) {

            mImgPlay.setVisibility(View.GONE);
            mSimplePlay.setVisibility(View.GONE);
            mTvContent.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mLineContent.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            mLineContent.setBackgroundColor(Color.parseColor("#ffffff"));
            mLineContent.setAlpha(1f);
            mLineContent.setLayoutParams(layoutParams);
            String text = mData.get(position).getText();
            //mTvContent.setText(text);
        } else {

        }
        //GIF部分
        if (mData.get(position).getType().equals("gif")) {
            mImgPlay.setVisibility(View.GONE);
            mTvContent.setVisibility(View.GONE);
            mSimplePlay.setVisibility(View.VISIBLE);
            mSimplePlay.setImageURI(Uri.parse(mData.get(position).getGif().getGif_thumbnail().get(0)));
            DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                    .setAutoPlayAnimations(true)
                    //加载drawable里的一张gif图
                    .setUri(Uri.parse(mData.get(position).getGif().getImages().get(0)))//设置uri
                    .build();
            //设置Controller
            mSimplePlay.setController(mDraweeController);

        } else {
        }
        if (mData.get(position).getType().equals("image")) {
            mImgPlay.setVisibility(View.GONE);
            mSimplePlay.setVisibility(View.VISIBLE);

            mTvContent.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mLineContent.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            mLineContent.setBackgroundColor(Color.parseColor("#FFDE5F0A"));
            mLineContent.setAlpha(0.8f);
            mLineContent.setLayoutParams(layoutParams);
            mTvContent.setText("    点击查看详情");
            int height = mData.get(position).getImage().getHeight();
            int width = mData.get(position).getImage().getWidth();
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) mSimplePlay.getLayoutParams();
            params1.width = mContext.getResources().getDisplayMetrics().widthPixels;
            if (mContext.getResources().getDisplayMetrics().widthPixels * height / width < 1500) {
                params1.height = mContext.getResources().getDisplayMetrics().widthPixels * height / width;
            } else {
                params1.height = 1500;
            }
            mSimplePlay.setLayoutParams(params1);
            GenericDraweeHierarchy hierarchy = mSimplePlay.getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
            hierarchy.setActualImageFocusPoint(new PointF(0, 0));

            mLineContent.setOnClickListener(this);
            mLineContent.setTag(position);
            mSimplePlay.setImageURI(Uri.parse(mData.get(position).getImage().getBig().get(0)));
        } else {
        }

        mSimpleHaed.setImageURI(Uri.parse(mData.get(position).getU().getHeader().get(0)));
        mTvRoomname.setText(mData.get(position).getU().getRoom_name());
        mTvTime.setText(mData.get(position).getPasstime());
        mTvText.setText(mData.get(position).getText());
        mTvDianzan.setText(mData.get(position).getUp() + "");
        mTvDianzan.setTextColor(Color.parseColor("#434141"));
        mTvUndianzan.setText(mData.get(position).getDown() + "");
        mTvUndianzan.setTextColor(Color.parseColor("#434141"));
        mTvFenxiang.setText(mData.get(position).getForward() + "");
        mTvPinglun.setText(mData.get(position).getComment() + "");
        final List<QuanBuEntity.ListEntity.TopCommentsEntity> top_comments = mData.get(position).getTop_comments();
        if (top_comments != null) {
            mLv.setAdapter(new CommonAdapter<QuanBuEntity.ListEntity.TopCommentsEntity>(mContext, top_comments, R.layout.item_shipin_comment) {
                @Override
                public void bindData(int position, viewHolder mHolder) {
                    View view = mHolder.mView;
                    assignViews(view);
                    initView(position);
                }

                private TextView mTvCommentName;
                private TextView mTvCommentContext;

                private void assignViews(View view) {
                    mTvCommentName = (TextView) view.findViewById(R.id.tv_comment_name);
                    mTvCommentContext = (TextView) view.findViewById(R.id.tv_comment_context);

                }

                private void initView(int position) {

                    mTvCommentName.setText(Html.fromHtml(String.format(mContext.getString(R.string.text), top_comments.get(position).getU().getName(), "  :     " + top_comments.get(position).getContent())));

                }

            });
            setListViewHeightBasedOnChildren(mLv);
        }
        mImgDianzan.setTag(-1, mImgDianZan1);
        mImgDianzan.setTag(-2, mTvDianzan);
        mImgDianzan.setTag(-3, mImgUndianzan);

        mImgUndianzan.setTag(-1, mImgUnDianZan1);
        mImgUndianzan.setTag(-2, mTvUndianzan);
        mImgUndianzan.setTag(-3, mImgDianzan);

        mImgDianzan.setOnClickListener(this);
        mImgUndianzan.setOnClickListener(this);

        mImgFenxiang.setOnClickListener(this);
        mImgFenxiang.setTag(position);

        mImgPinglun.setOnClickListener(this);
        mImgPinglun.setTag(position);

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

    @Override
    public int getItemViewType(int position) {

        switch (mData.get(position).getType()) {
            case "video":
                return TYPE_VIDEO;
            case "gif":
                return TYPE_VIDEO;
            case "image":
                return TYPE_VIDEO;
            case "text":
                return TYPE_VIDEO;
            case "html":
                return TYPE_HTML;
        }

        return -1;
    }

    String oldurl = "_1";
    boolean isfirst = false;
    boolean isvideo = false;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.img_play: {
                int tag = (int) v.getTag();
                if (mData.get(tag).getType().equals("video")) {

                    if (oldPosition == tag) {
                        isfirst = false;
                    } else {
                        isfirst = true;
                    }
                } else {
                    isfirst = false;
                }

                oldPosition = tag;
                notifyDataSetChanged();
            }
            break;
            case R.id.relat_play: {
                String type = (String) v.getTag(-1);
                if ("video".equals(type)) {
                    if (mMediaPlayer != null) {
                        if (mMediaPlayer.isPlaying()) {

                            ImageView imgPlay = (ImageView) v.getTag(-2);
                            imgPlay.setVisibility(View.VISIBLE);
                            mMediaPlayer.pause();

                        }
                    }
                }


            }
            break;
            case R.id.img_dianzan: {
                mDianzan1 = (ImageView) v.getTag(-1);
                mTv = (TextView) v.getTag(-2);
                mUnDaizan = (ImageView) v.getTag(-3);
                v.setClickable(false);
                mUnDaizan.setClickable(false);
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_dianzan);
                mDianzan1.setAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mDianzan1.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mDianzan1.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                String s = String.valueOf(mTv.getText());
                int i = Integer.parseInt(s);
                mTv.setText(i + 1 + "");
                mTv.setTextColor(Color.parseColor("#d9181e"));

            }
            break;
            case R.id.img_undianzan: {
                mUnDianzan1 = (ImageView) v.getTag(-1);
                mUnTV = (TextView) v.getTag(-2);
                mDaizan = (ImageView) v.getTag(-3);
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_dianzan);

                mUnDianzan1.setAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mUnDianzan1.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mUnDianzan1.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                String s = String.valueOf(mUnTV.getText());
                int i = Integer.parseInt(s);
                mUnTV.setText(i + 1 + "");
                mUnTV.setTextColor(Color.parseColor("#d9181e"));
                v.setClickable(false);
                mDaizan.setClickable(false);
            }
            break;
            case R.id.img_fenxiang: {
                int tag = (int) v.getTag();
                QuanBuEntity.ListEntity entity = mData.get(tag);
                showShare(entity.getU().getHeader().get(0), entity.getText(), entity.getShare_url(), entity.getComment());
            }
            break;
            case R.id.img_pinglun: {
                int tag = (int) v.getTag();
                Intent intent = new Intent(mContext, CommentActivity.class);
                intent.putExtra("bean", mData.get(tag));
                mContext.startActivity(intent);
            }
            break;
            case R.id.line_content:
                int tag = (int) v.getTag();
                Intent intent = new Intent(mContext, CommentActivity.class);
                intent.putExtra("bean", mData.get(tag));
                mContext.startActivity(intent);
        }

    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mMediaPlayer.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void onScroll() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        oldPosition = -1;
        isfirst = false;
        isvideo = false;
    }

    private void showShare(String title, String textcontent, String url, String comment) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(textcontent);
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(url);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(comment);
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("百思不得姐");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://www.budejie.com/");

        // 启动分享GUI
        oks.show(mContext);
    }
}
