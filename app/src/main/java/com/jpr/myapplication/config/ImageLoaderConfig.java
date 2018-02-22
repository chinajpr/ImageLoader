package com.jpr.myapplication.config;

import android.support.v7.app.AlertDialog;

import com.jpr.myapplication.cache.BitmapCache;
import com.jpr.myapplication.policy.LoaderPolicy;

/**
 * 类描述:配置类
 * 创建日期:2018/2/22 on 15:56
 * 作者:JiaoPeiRong
 */

public class ImageLoaderConfig {
    /**
     * 缓存策略
     */
    private BitmapCache bitmapCache;
    /**
     * 加载策略
     */
    private LoaderPolicy loaderPolicy;
    /**
     * 默认线程数
     */
    private int threadCount = Runtime.getRuntime().availableProcessors();
    /**
     * 默认显示配置
     */
    private DisplayConfig displayConfig;

    /**
     * 私有化构造
     */
    private ImageLoaderConfig() {

    }

    public BitmapCache getBitmapCache() {
        return bitmapCache;
    }

    public LoaderPolicy getLoaderPolicy() {
        return loaderPolicy;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public DisplayConfig getDisplayConfig() {
        return displayConfig;
    }

    /**
     * 构建者模式
     */
    public static class Builder {
        private ImageLoaderConfig config;

        public Builder() {
            config = new ImageLoaderConfig();
        }

        /**
         * 设置缓存策略
         *
         * @param bitmapCache
         * @return
         */
        public Builder setCachePolicy(BitmapCache bitmapCache) {
            config.bitmapCache = bitmapCache;
            return this;
        }

        /**
         * 设置加载策略
         *
         * @param loaderPolicy
         * @return
         */
        public Builder setLoaderPolicy(LoaderPolicy loaderPolicy) {
            config.loaderPolicy = loaderPolicy;
            return this;
        }

        /**
         * 设置线程个数
         *
         * @param count
         * @return
         */
        public Builder setThreadCount(int count) {
            config.threadCount = count;
            return this;
        }

        /**
         * 设置加载过程中的图片
         *
         * @param resID
         * @return
         */
        public Builder setLoadingImage(int resID) {
            config.displayConfig.loadingImage = resID;
            return this;
        }

        /**
         * 设置加载失败的图片
         *
         * @param resID
         * @return
         */
        public Builder setFaildImage(int resID) {
            config.displayConfig.faildImage = resID;
            return this;
        }

        public ImageLoaderConfig build() {
            return config;
        }
    }
}
