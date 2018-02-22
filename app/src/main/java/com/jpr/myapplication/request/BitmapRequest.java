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

    @Override
    public int compare(BitmapRequest bitmapRequest, BitmapRequest t1) {
        return 0;
    }
}
