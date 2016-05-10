package com.hujiang.library.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle

open class MainActivity : Activity() {

    override open fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.aop_activity).setOnClickListener {
            startActivity(Intent(this@MainActivity, AOPActivity::class.java))
        }
        findViewById(R.id.aop_fragment).setOnClickListener {
            startActivity(Intent(this@MainActivity, FragmentActivity::class.java))
        }
        findViewById(R.id.aop_kotlin).setOnClickListener {
            Greeter().greet()
        }
        findViewById(R.id.aop_normal_class).setOnClickListener {
            NormalClass("normalClass").work()
        }

        //        var img : ImageView = findViewById(R.id.img_t) as ImageView

        //http://cichang.hujiang.com/images/friendquan_share.png
        //        ImageLoader.getInstance().displayImage("http://cichang.hujiang.com/images/friendquan_share.png", img)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
