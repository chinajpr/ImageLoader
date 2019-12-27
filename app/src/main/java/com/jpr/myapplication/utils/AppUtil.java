package com.jpr.myapplication.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * 类描述：
 * 创建日期：2019/7/31.
 * 作者：jiaopeirog
 */
public class AppUtil {
    /**
     * 获取应用的版本号
     * @param context
     * @return
     */
    public static int getAppVersion(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            return pm.getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
