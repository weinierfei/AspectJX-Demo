/*
 * AOPActivity      2016-03-28
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */
package com.hujiang.library.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class description here
 *
 * @author simon
 * @version 1.0.0
 * @since 2016-03-28
 */
public class AOPActivity extends Activity {

    private static final String TAG = "AOPActivity";

    Button mButton;
    private ListView listView;

    private List<Map> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.aop_activity_layout);
        mButton = (Button) findViewById(R.id.btn_test1);
        ImageView imageView = (ImageView) findViewById(R.id.img_t);
        String url = "http://cichang.hujiang.com/images/friendquan_share.png";
        imageView.setTag(url);
        ImageLoader.getInstance().displayImage(url, imageView);


        TextView tv_test_click = (TextView) findViewById(R.id.tv_test_click);
        tv_test_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AOPActivity.this,FragmentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("TEST",false);
                bundle.putString("name","张三");
                bundle.putString("first","李四");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        getDatas(1, "ceshi", "123");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "mButton被点击了");
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "图片被点击了");
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        Map map = null;
        for (int i = 0; i < 10; i++) {

            map = new HashMap();
            map.put("name","我是测试item"+i);
            map.put("title","标题"+i);
            datas.add(map);
        }

        CommonAdapter<Map> adapter = new CommonAdapter<Map>(this,R.layout.aop_item,datas) {
            @Override
            public void convert(ViewHolder holder, Map o) {
                holder.setText(R.id.tv_title, (String) o.get("title"));
                holder.setText(R.id.tv_name, (String) o.get("name"));
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


    private void getDatas(int i, String ceshi, String s) {
        Log.i(TAG, "getdatas");
    }

    @Override
    protected void onResume() {
        super.onResume();

        new AspectJavaDemo().work();
    }
}