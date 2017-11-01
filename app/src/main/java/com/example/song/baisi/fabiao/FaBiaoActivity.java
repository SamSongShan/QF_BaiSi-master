package com.example.song.baisi.fabiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.song.baisi.R;


public class FaBiaoActivity extends AppCompatActivity {

    private ImageView mImgVideo;
    private ImageView mImgPhoto;
    private ImageView mImgText;
    private ImageView mImgVoice;
    private ImageView mImgLine;
    private ImageView mImgDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_biao);
        initView();

        anim();
    }

    private void anim() {
        TranslateAnimation myAnimation_Translate = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, -1,
                Animation.RELATIVE_TO_PARENT, 0);
        myAnimation_Translate.setDuration(1000);
        myAnimation_Translate.setInterpolator(AnimationUtils
                .loadInterpolator(FaBiaoActivity.this,
                        android.R.anim.accelerate_decelerate_interpolator));
        myAnimation_Translate.setInterpolator(new AnticipateOvershootInterpolator());
        mImgVideo.startAnimation(myAnimation_Translate);
    }


    private void initView() {
        mImgVideo = (ImageView) findViewById(R.id.img_video);
        mImgPhoto = (ImageView) findViewById(R.id.img_photo);
        mImgText = (ImageView) findViewById(R.id.img_text);
        mImgVoice = (ImageView) findViewById(R.id.img_voice);
        mImgLine = (ImageView) findViewById(R.id.img_line);
        mImgDownload = (ImageView) findViewById(R.id.img_download);
    }
}
