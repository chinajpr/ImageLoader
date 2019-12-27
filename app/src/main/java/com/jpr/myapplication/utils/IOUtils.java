package com.jpr.myapplication.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * 类描述：
 * 创建日期：2019/7/31.
 * 作者：jiaopeirog
 */
public class IOUtils {
    /**
     * 获取缓存路径
     * @param mCacheDir
     * @param context
     * @return
     */
    public static File getDiskCacheDir(String mCacheDir, Context context) {
        //相对路径
        String cachePath;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            //外部存储
            cachePath = context.getExternalCacheDir().getPath();
        }else{
            //内部存储
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separatorChar + mCacheDir);
    }
}
