package com.jpr.myapplication.loader;

import com.jpr.myapplication.request.BitmapRequest;

/**
 * 类描述:
 * 创建日期:2018/2/22 on 16:00
 * 作者:JiaoPeiRong
 */

public interface Loader {
    /**
     * 加载图片
     * @param bitmapRequest
     */
    void loadImage(BitmapRequest bitmapRequest);
}
