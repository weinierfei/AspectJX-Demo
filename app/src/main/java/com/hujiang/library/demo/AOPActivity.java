/*
 * AOPActivity      2016-03-28
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */
package com.hujiang.library.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * class description here
 *
 * @author simon
 * @version 1.0.0
 * @since 2016-03-28
 */
public class AOPActivity extends Activity {

    private ListView listView;

    private List<String> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.aop_activity_layout);
        ImageView imageView = (ImageView)findViewById(R.id.img_t);
        ImageLoader.getInstance().displayImage("http://cichang.hujiang.com/images/friendquan_share.png", imageView);
        listView = (ListView) findViewById(R.id.listView);

        for (int i = 0; i < 10; i++) {

            datas.add("我是测试item"+i);
        }

        CommonAdapter<String> adapter = new CommonAdapter<String>(this,R.layout.aop_item,datas) {
            @Override
            public void convert(ViewHolder holder, String o) {

                holder.setText(R.id.textView,o);
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AOPActivity.this, "dianji "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        new AspectJavaDemo().work();
    }
}