package com.hujiang.library.demo.util;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;


/**
 * Description:加载图片工具类
 *
 * @author: guoyongping
 * @date: 2016/5/18 20:10
 */
public class ImageLoader {

    private static volatile ImageLoader sImageLoader;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (sImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (sImageLoader == null) {
                    sImageLoader = new ImageLoader();
                }
            }
        }
        return sImageLoader;
    }

    /**
     * 普通加载网络图片
     *
     * @param context  上下文
     * @param image  目标ImageView
     * @param url  图片url
     */
    public void loadImage(Context context, ImageView image, String url) {
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance()
                .displayImage(url, image);
    }

    /**
     * 普通加载网络图片
     *
     * @param context  上下文
     * @param image  目标ImageView
     * @param url  图片url
     */
    public void loadImage(Context context, ImageView image, String url, DisplayImageOptions displayImageOptions) {
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance()
                .displayImage(url, image, displayImageOptions);
    }

    /**
     * 从drawable中异步加载本地图片
     *
     * @param context  上下文
     * @param image  目标ImageView
     * @param resourceId  资源id
     */
    public void loadImage(Context context, ImageView image, int resourceId) {
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance()
                .displayImage("drawable://" + resourceId,image);
    }


    /**
     * 从内存卡中异步加载本地图片
     *
     * @param context   上下文
     * @param uri       本地文件路径
     * @param imageView 目标ImageView
     */
    public void loadImageFromSDCard(Context context, String uri, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance()
                .displayImage("file://" + uri, imageView);
    }

    /**
     * 从drawable中异步加载本地图片
     *
     * @param context   上下文
     * @param imageId
     * @param imageView
     */
    public void displayFromDrawable(Context context, int imageId, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance()
                .displayImage("drawable://" + imageId,imageView);
    }

    /**
     * 从内容提提供者中抓取图片
     *
     * @param context
     * @param uri
     * @param imageView
     */
    public void displayFromContent(Context context, String uri, ImageView imageView) {
        // String imageUri = "content://media/external/audio/albumart/13"; //
        // from content provider
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance()
                .displayImage("content://" + uri, imageView);
    }

}


