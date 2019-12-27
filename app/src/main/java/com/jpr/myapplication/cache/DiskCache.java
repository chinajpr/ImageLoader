package com.jpr.myapplication.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.jpr.myapplication.disk.DiskLruCache;
import com.jpr.myapplication.disk.IOUtil;
import com.jpr.myapplication.request.BitmapRequest;
import com.jpr.myapplication.utils.AppUtil;
import com.jpr.myapplication.utils.IOUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 类描述:磁盘缓存
 * 创建日期:2018/2/22 on 16:06
 * 作者:JiaoPeiRong
 */

public class DiskCache implements BitmapCache {
    private static volatile DiskCache diskCache;
    /**
     * MB
     */
    private static final int MB = 1024 * 1024;
    /**
     * 磁盘缓存
     */
    private DiskLruCache diskLruCache;
    /**
     * 缓存路径
     */
    private String mCacheDir = "image";

//    private static class Single{
//        private static DiskCache INSTANCE = new DiskCache();
//    }
//
//    /**
//     * 静态内部类形式创建单例
//     * @return
//     */
//    public static DiskCache getInstance(){
//        return Single.INSTANCE;
//    }

    /**
     * 双判空获取单例，因为需要context传参，所以不使用内部类形式
     *
     * @param context
     * @return
     */
    public static DiskCache getInstance(Context context) {
        if (null == diskCache) {
            synchronized (DiskCache.class) {
                if (null == diskCache) {
                    diskCache = new DiskCache(context);
                }
            }
        }
        return diskCache;
    }

    /**
     * 私有化构造
     */
    private DiskCache(Context context) {
        initDiskLruCache(context);
    }

    /**
     * 初始化
     */
    private void initDiskLruCache(Context context) {
        File diskCacheDir = IOUtils.getDiskCacheDir(mCacheDir, context);
        if (!diskCacheDir.exists()) {
            diskCacheDir.mkdirs();
        }

        //初始化
        //1 每次缓存一个图片
        //50 MB 最大值
        try {
            diskLruCache = DiskLruCache.open(diskCacheDir, AppUtil.getAppVersion(context), 1, 50 * MB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCacheDir(String mCacheDir) {
        this.mCacheDir = mCacheDir;
    }

    @Override
    public void put(BitmapRequest request, Bitmap bitmap) {
        DiskLruCache.Editor editor = null;
        OutputStream os = null;
        try {
            //开始编辑
            editor = diskLruCache.edit(request.getImageUriMd5());
            os = editor.newOutputStream(0);
            //成功，或者失败
            if (persistBitmap2Disk(bitmap, os)) {
                editor.commit();
            } else {
                editor.abort();
            }
            diskLruCache.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeQuietly(os);
        }
        Log.d("jason", "put in DiskCache:" + request.getImageUri());
    }

    /**
     * 持久化Bitmap对象到Disk
     *
     * @param bitmap
     * @param os
     * @return
     */
    private boolean persistBitmap2Disk(Bitmap bitmap, OutputStream os) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(os);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            //清空缓存
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            IOUtil.closeQuietly(bos);
        }
        return true;
    }

    @Override
    public Bitmap get(BitmapRequest request) {
        InputStream is = null;
        try {
            //快照
            DiskLruCache.Snapshot snapshot = diskLruCache.get(request.getImageUriMd5());
            is = snapshot.getInputStream(0);

            Log.d("jason", "get from DiskCache:" + request.getImageUri());
            return BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeQuietly(is);
        }
        return null;
    }

    @Override
    public void remove(BitmapRequest request) {
        try {
            diskLruCache.remove(request.getImageUriMd5());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
