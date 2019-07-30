package com.jpr.myapplication.request;

import com.jpr.myapplication.loader.SimpleImageLoader;
import com.jpr.myapplication.policy.LoaderPolicy;

import java.util.Comparator;

/**
 * 类描述:
 * 创建日期:2018/2/22 on 15:58
 * 作者:JiaoPeiRong
 */

public class BitmapRequest implements Comparator<BitmapRequest>{
    /**
     * 加载策略
     */
    private LoaderPolicy loaderPolicy = SimpleImageLoader.getInstance().getConfig().getLoaderPolicy();
    /**
     * 图片路径
     */
    private String imageUri;
    /**
     * md5加密的图片路径
     */
    private String imageUriMd5;

    @Override
    public int compare(BitmapRequest bitmapRequest, BitmapRequest t1) {
        return 0;
    }

    public LoaderPolicy getLoaderPolicy() {
        return loaderPolicy;
    }

    public void setLoaderPolicy(LoaderPolicy loaderPolicy) {
        this.loaderPolicy = loaderPolicy;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getImageUriMd5() {
        return imageUriMd5;
    }

    public void setImageUriMd5(String imageUriMd5) {
        this.imageUriMd5 = imageUriMd5;
    }
}
