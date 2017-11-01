package com.example.song.baisi;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;

/**
 * Created by 11355 on 2016/11/28.
 */

public class MyAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
