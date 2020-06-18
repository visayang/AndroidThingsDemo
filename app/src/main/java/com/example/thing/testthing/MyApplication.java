package com.example.thing.testthing;

import android.app.Application;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by 21737367 on 2018/1/26.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.replaceSystemDefaultFont(this, "fonts/msyh.ttf");

        /**
         * 使用方法：
         * 1. 复制TypefaceUtil类（感谢前辈造的轮子）
         * 2. 新建assets资源文件夹，fonts文件夹（这个看自己喜欢，归类的话就多建立一个），复制ttf字体文件（百度一堆，这里使用的是微软雅黑）
         * 3. styles -> AppTheme（默认主题） -> 增加一条 <item name="android:typeface">monospace</item>
         * 4. Application -> onCreate -> TypefaceUtil.replaceSystemDefaultFont(this, "fonts/msyh.ttf");
         * 5. 完成
         */
    }
}
