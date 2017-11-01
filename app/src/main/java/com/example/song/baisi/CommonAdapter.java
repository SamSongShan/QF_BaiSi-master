package com.example.song.baisi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.song.baisi.jinghua.CommentActivity;
import com.example.song.baisi.jinghua.CommentListEntity;
import com.example.song.baisi.jinghua.Precmts1Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter {
    List<T> data;
    LayoutInflater mLayoutInflater;
    int[] layoutId;
    Context context;
    private viewHolder mHolder;

    public CommonAdapter(Context context,List<T> data, int... layoutId) {
        this.data = data;
        this.layoutId = layoutId;
        this.context=context;
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(layoutId[getItemViewType(position)],parent,false);
            mHolder = new viewHolder(convertView);
            convertView.setTag(mHolder);
        }else {
            mHolder = (viewHolder) convertView.getTag();
        }

        bindData(position,mHolder);
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return layoutId.length;
    }


    public class viewHolder{
        public View mView;

        public viewHolder(View view) {
            mView = view;
        }
    }

    public abstract void bindData(int position, viewHolder mHolder);
}