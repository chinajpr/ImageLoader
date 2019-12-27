package com.jpr.myapplication.cache;

import android.graphics.Bitmap;

import com.jpr.myapplication.request.BitmapRequest;

/**
 * 类描述：
 * 创建日期：2019/7/31.
 * 作者：jiaopeirog
 */
public class NoCache implements BitmapCache {

    @Override
    public void put(BitmapRequest request, Bitmap bitmap) {

    }

    @Override
    public Bitmap get(BitmapRequest request) {
        return null;
    }

    @Override
    public void remove(BitmapRequest request) {

    }
}
