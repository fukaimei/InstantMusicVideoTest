package com.example.instantmusicvideotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.instantmusicvideotest.adapter.ViewPagerAdapter;
import com.example.instantmusicvideotest.entity.ShortVideoInfo;
import com.example.instantmusicvideotest.holder.RecyclerItemNormalHolder;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager2)
    ViewPager2 viewPager2;

    private List<ShortVideoInfo> mList = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {

        setData();
        viewPagerAdapter = new ViewPagerAdapter(this, mList);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(viewPagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // 大于0说明有播放
                int playPosition = GSYVideoManager.instance().getPlayPosition();
                if (playPosition >= 0) {
                    // 对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(RecyclerItemNormalHolder.TAG)
                            && (position != playPosition)) {
                        playPosition(position);
                    }
                }
            }
        });
        viewPager2.post(new Runnable() {
            @Override
            public void run() {
                playPosition(0);
            }
        });

    }

    private void playPosition(int position) {
        RecyclerView.ViewHolder viewHolder = ((RecyclerView) viewPager2.getChildAt(0)).findViewHolderForAdapterPosition(position);
        if (viewHolder != null) {
            RecyclerItemNormalHolder recyclerItemNormalHolder = (RecyclerItemNormalHolder) viewHolder;
            recyclerItemNormalHolder.getPlayer().startPlayLogic();
        }
    }

    /**
     * 模拟数据
     */
    private void setData() {

        ShortVideoInfo data1 = new ShortVideoInfo();
        data1.setTextContent("蜂鸟计划 中国预告片：速度与金钱版 (中文字幕)");
        data1.setVideoCover("https://img3.doubanio.com/img/trailer/medium/2631410731.jpg?1611566097");
        data1.setVideoUrl("https://vt1.doubanio.com/202102020903/722442386dcd5076fd70c4ac2bf093bb/view/movie/M/402710160.mp4");
        mList.add(data1);

        ShortVideoInfo data2 = new ShortVideoInfo();
        data2.setTextContent("旺达幻视 预告片");
        data2.setVideoCover("https://img1.doubanio.com/img/trailer/medium/2628042057.jpg?");
        data2.setVideoUrl("https://vt1.doubanio.com/202102011621/94e560ba4d88c562e0768f6339822d99/view/movie/M/402690624.mp4");
        mList.add(data2);

        ShortVideoInfo data3 = new ShortVideoInfo();
        data3.setTextContent("无耻之徒(美版) 第十一季 预告片");
        data3.setVideoCover("https://img1.doubanio.com/img/trailer/medium/2626877508.jpg?");
        data3.setVideoUrl("https://vt1.doubanio.com/202101120940/a3e7ae32c21341710eaceba2d2e56039/view/movie/M/402680931.mp4");
        mList.add(data3);

        ShortVideoInfo data4 = new ShortVideoInfo();
        data4.setTextContent("发现女巫 第二季 预告片");
        data4.setVideoCover("https://img9.doubanio.com/img/trailer/medium/2628112124.jpg?");
        data4.setVideoUrl("https://vt1.doubanio.com/202101120938/d05ce0af6cefa6b88dd699e1f8150f2f/view/movie/M/402690672.mp4");
        mList.add(data4);

        ShortVideoInfo data5 = new ShortVideoInfo();
        data5.setTextContent("天国与地狱 预告片");
        data5.setVideoCover("https://img2.doubanio.com/img/trailer/medium/2628313153.jpg?");
        data5.setVideoUrl("https://vt1.doubanio.com/202102051113/07846ae6e7dd67089ff46a4d070b5f5d/view/movie/M/402690752.mp4");
        mList.add(data5);

    }

}