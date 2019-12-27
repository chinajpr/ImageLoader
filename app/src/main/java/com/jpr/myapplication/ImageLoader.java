package com.jpr.myapplication;

import com.jpr.myapplication.config.ImageLoaderConfig;
import com.jpr.myapplication.loader.SimpleImageLoader;
import com.jpr.myapplication.request.RequestQueue;

/**
 * 类描述：
 * 创建日期：2019/7/31.
 * 作者：jiaopeirog
 */
public class ImageLoader {
    /**
     * 配置
     */
    private ImageLoaderConfig mConfig;
    /**
     * 请求队列
     */
    private RequestQueue requestQueue;
    /**
     * 本身的对象
     */
    private static ImageLoader mInstance;

    public ImageLoader() {
    }

    private ImageLoader(ImageLoaderConfig config) {

    }

    /**
     * 获取单例
     * @param config
     * @return
     */
    public static ImageLoader getInstance(ImageLoaderConfig config){
        if(mInstance == null){
            synchronized (ImageLoader.class) {
                if(mInstance == null){
                    mInstance = new ImageLoader(config);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取SimpleImageLoader的实例
     * @return 只有在SimpleImageLoader getInstance(ImageLoaderConfig config)调用过之后，才能返回一个实例化了的SimpleImageLoader对象
     */
    public static ImageLoader getObject(){
        if(mInstance == null){
            throw new UnsupportedOperationException("getInstance(ImageLoaderConfig config) 没有执行过！");
        }
        return mInstance;
    }
}
