package com.walle.googleplayer.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by walle9 on 2017/3/1.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static Handler mMainThreadHandler;
    private static int mMMainThreadId;      //static变量不被GC所管理

    /**
     * 得到上下文
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 得到主线程里面的创建的一个hanlder
     * @return
     */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    /**
     * 得到主线程的线程id
     * @return
     */
    public static int getMMainThreadId() {
        return mMMainThreadId;
    }

    @Override
    public void onCreate() {
        //上下文
        mContext = getApplicationContext();
        //主线程的Handler
        mMainThreadHandler = new Handler();
        /**
         * 获取主线程的线程id
         * myTid:Thread
         * myPid:Process
         * myUid:User
         */
        mMMainThreadId = Process.myTid();
        super.onCreate();
    }
}
