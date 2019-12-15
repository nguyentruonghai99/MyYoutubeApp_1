package com.example.myyoutubeapp.controller;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myyoutubeapp.R;
import com.example.myyoutubeapp.Utility.Util;
import com.example.myyoutubeapp.model.VideoModel;

import java.util.ArrayList;

public class VideoAdapter extends BaseAdapter {
    private ArrayList<VideoModel> arr = new ArrayList<>();
    private Context context;
    private DisplayMetrics metrics;

    public VideoAdapter(Context context, ArrayList<VideoModel> arr)
    {
        this.arr = arr;
        this.context = context;
        //check density of device
        metrics = context.getResources().getDisplayMetrics();
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.video_item, parent, false);
        //find views
        TextView lblName = (TextView) rowView.findViewById(R.id.lbl_name);
        TextView lblTimeView = (TextView) rowView.findViewById(R.id.lbl_time_view);
        ImageView imgThumb = (ImageView) rowView.findViewById(R.id.img_thumb);

        lblName.setText(arr.get(position).name);
        lblTimeView.setText(arr.get(position).uploadTime.substring(0, 10));

        //view thumbnail
        if(metrics.density <= 1.0f){
            Util.setBitmapToImage(arr.get(position).imgThumbDefault,imgThumb);
        }else{
            if(metrics.density <= 1.5f)
            {
                Util.setBitmapToImage(arr.get(position).imgThumbMedium,imgThumb);
            }else{
                Util.setBitmapToImage(arr.get(position).imgThumbHight, imgThumb);
            }
        }
        return rowView;
    }
}
