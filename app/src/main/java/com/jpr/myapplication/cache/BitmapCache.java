package com.jpr.myapplication.cache;

import android.graphics.Bitmap;

import com.jpr.myapplication.request.BitmapRequest;

/**
 * 类描述:
 * 创建日期:2018/2/22 on 16:05
 * 作者:JiaoPeiRong
 */

public interface BitmapCache {

    /**
     * 添加缓存
     * @param request
     * @param bitmap
     */
    void put(BitmapRequest request , Bitmap bitmap);

    /**
     * 获取缓存
     * @param request
     */
    Bitmap get(BitmapRequest request);

    /**
     * 移除缓存
     * @param request
     */
    void remove(BitmapRequest request);
}
