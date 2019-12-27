package com.jpr.myapplication.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.jpr.myapplication.request.BitmapRequest;

/**
 * 类描述:内存缓存
 * 创建日期:2018/2/22 on 16:06
 * 作者:JiaoPeiRong
 */

public class MemoryCache implements BitmapCache {

    private LruCache<String , Bitmap> lruCache;

    public MemoryCache() {
        int maxSize = (int) (Runtime.getRuntime().freeMemory() / 1024 / 8);
        lruCache = new LruCache<String, Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //每个图片占用的字节数
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public void put(BitmapRequest request, Bitmap bitmap) {
        lruCache.put(request.getImageUriMd5() , bitmap);
    }

    @Override
    public Bitmap get(BitmapRequest request) {
        return lruCache.get(request.getImageUriMd5());
    }

    @Override
    public void remove(BitmapRequest request) {
        lruCache.remove(request.getImageUriMd5());
    }
}
