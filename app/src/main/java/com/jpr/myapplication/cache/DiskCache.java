package com.jpr.myapplication.cache;

import android.graphics.Bitmap;

import com.jpr.myapplication.disk.DiskLruCache;
import com.jpr.myapplication.request.BitmapRequest;

/**
 * 类描述:磁盘缓存
 * 创建日期:2018/2/22 on 16:06
 * 作者:JiaoPeiRong
 */

public class DiskCache implements BitmapCache {

    private DiskLruCache diskLruCache;

    @Override
    public void put(BitmapRequest request, Bitmap bitmap) {

    }

    @Override
    public void get(BitmapRequest request) {

    }

    @Override
    public void remove(BitmapRequest request) {

    }
}
