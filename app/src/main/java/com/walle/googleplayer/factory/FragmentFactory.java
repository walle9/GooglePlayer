package com.walle.googleplayer.factory;

import android.support.v4.app.Fragment;

import com.walle.googleplayer.fragment.AppFragment;
import com.walle.googleplayer.fragment.CategoryFragment;
import com.walle.googleplayer.fragment.GameFragment;
import com.walle.googleplayer.fragment.HomeFragment;
import com.walle.googleplayer.fragment.HotFragment;
import com.walle.googleplayer.fragment.RecommendFragment;
import com.walle.googleplayer.fragment.SubjectFragment;

/**
 * Created by walle9 on 2017/3/3.
 * 封装对Fragment的创建
 */

public class FragmentFactory {

    public static final int FRAGMENT_HOME = 0;//首页
    public static final int FRAGMENT_APP = 1;//应用
    public static final int FRAGMENT_GAME = 2;//游戏
    public static final int FRAGMENT_SUBJECT = 3;//专题
    public static final int FRAGMENT_RECOMMEND = 4;//推荐
    public static final int FRAGMENT_CATEGORY = 5;//分类
    public static final int FRAGMENT_HOT = 6;//排行

    /**
     * 创建Fragment的实例
     * @param position
     * @return
     */
    public static Fragment createFragment(int position) {
        Fragment fragment = null;

        switch (position) {
            case FRAGMENT_HOME://返回 首页 对应的fragment
                fragment = new HomeFragment();
                break;
            case FRAGMENT_APP://返回 应用 对应的fragment
                fragment = new AppFragment();
                break;
            case FRAGMENT_GAME://返回 游戏 对应的fragment
                fragment = new GameFragment();
                break;
            case FRAGMENT_SUBJECT://返回 专题 对应的fragment
                fragment = new SubjectFragment();
                break;
            case FRAGMENT_RECOMMEND://返回 推荐 对应的fragment
                fragment = new RecommendFragment();
                break;
            case FRAGMENT_CATEGORY://返回 分类 对应的fragment
                fragment = new CategoryFragment();
                break;
            case FRAGMENT_HOT://返回 排行 对应的fragment
                fragment = new HotFragment();
                break;
        }
        return fragment;

    }
}
