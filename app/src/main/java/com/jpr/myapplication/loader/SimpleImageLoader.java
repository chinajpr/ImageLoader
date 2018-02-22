package com.jpr.myapplication.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.jpr.myapplication.config.DisplayConfig;
import com.jpr.myapplication.config.ImageLoaderConfig;
import com.jpr.myapplication.request.BitmapRequest;
import com.jpr.myapplication.request.RequestQueue;

/**
 * 类描述:
 * 创建日期:2018/2/22 on 15:57
 * 作者:JiaoPeiRong
 */

public class SimpleImageLoader {
    /**
     * 配置
     */
    private ImageLoaderConfig config;
    /**
     * 请求队列
     */
    private RequestQueue mRequestQueue;
    /**
     * 单例对象
     */
    private static volatile SimpleImageLoader mInstance;

    private SimpleImageLoader() {

    }

    private SimpleImageLoader(ImageLoaderConfig imageLoaderConfig) {
        this.config = imageLoaderConfig;
    }

    /**
     * 单例模式
     *
     * @param config
     * @return
     */
    private static SimpleImageLoader getInstance(ImageLoaderConfig config) {
        if (null == mInstance) {
            synchronized (SimpleImageLoader.class) {
                if (null == mInstance) {
                    mInstance = new SimpleImageLoader(config);
                }
            }
        }
        return mInstance;
    }

    /**
     * 第二次获取单例
     *
     * @return
     */
    public static SimpleImageLoader getInstance() {
        if (null == mInstance) {
            throw new UnsupportedOperationException("没有初始化");
        }
        return mInstance;
    }

    /**
     * 加载图片
     * @param imageView
     * @param uri http file 开头
     */
    public void displayImage(ImageView imageView, String uri) {
        displayImage(imageView , uri , null , null);
    }

    /**
     * 加载图片
     * @param imageView
     * @param uri
     * @param displayConfig
     * @param imageListener
     */
    public void displayImage(ImageView imageView, String uri, DisplayConfig displayConfig, ImageListener imageListener) {
        BitmapRequest bitmapRequest = new BitmapRequest();
    }

    public static interface ImageListener {
        void onComplete(ImageView imageView, Bitmap bitmap, String uri);
    }

    /**
     * 全局配置
     * @return
     */
    public ImageLoaderConfig getConfig() {
        return config;
    }
}
