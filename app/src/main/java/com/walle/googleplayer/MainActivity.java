package com.walle.googleplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.astuetz.PagerSlidingTabStripExtends;
import com.walle.googleplayer.factory.FragmentFactory;
import com.walle.googleplayer.utils.UIUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.main_tabs)
    PagerSlidingTabStripExtends mainTabs;
    @InjectView(R.id.main_viewpager)
    ViewPager mainViewpager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private String[] mMainTitles;
    private MainPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initActionBar();
        initview();
        initActionBarDrawerToggle();
        initData();
    }


    private void initview() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
    }


    /**
     * 初始化ActionBar
     */
    private void initActionBar() {
        //得到ActionBar的实例
        //getActionBar(); //android sdk actionbar
        ActionBar supportActionBar = getSupportActionBar(); //V7包中
        //supportActionBar.hide();    //隐藏ActionBar

        //设置标题
        supportActionBar.setTitle("GooglePlayer");
        //supportActionBar.setSubtitle("副标题");
        //设置图标
        supportActionBar.setIcon(R.drawable.ic_launcher);
        supportActionBar.setLogo(R.mipmap.ic_action_star);
        //显示logo/icon
        supportActionBar.setDisplayShowHomeEnabled(false);   //默认false 隐藏图标
        //修改显示icon和logo的优先级
        supportActionBar.setDisplayUseLogoEnabled(false);    //默认是false 默认没用logo,用icon
        //显示回退
        supportActionBar.setDisplayHomeAsUpEnabled(true);   //默认是false 默认隐藏了回退部分
    }

    /**
     * 初始化ActionBarDrawerToggle
     */
    private void initActionBarDrawerToggle() {
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        //同步状态的方法-->替换回退部分的UI效果
        mToggle.syncState();
        //设置drawerlayout的监听-->DrawerLayout拖动的时候,toggle可以跟着改变ui
        mDrawerLayout.setDrawerListener(mToggle);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Toast.makeText(getApplicationContext(),"点击了回退部分",Toast.LENGTH_SHORT).show();

                //点击Toggle可以控制drawerlayout的打开和关闭
                mToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 给ViewPager设置adapter
     * 绑定SlidingTab和ViewPager
     */
    private void initData() {
        //模拟数据集
        mMainTitles = UIUtils.getStrings(R.array.main_titles);
        //给ViewPager设置adapter
        mAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewpager.setAdapter(mAdapter);
        // 绑定SlidingTab和ViewPager
        mainTabs.setViewPager(mainViewpager);

    }

    /**
     * 主页面ViewPager的Adapter
     * PagerAdapter-->View
     * FragmentStatePagerAdapter-->Fragment
     * FragmentPagerAdapter-->Fragment
     */
    class MainPagerAdapter extends FragmentPagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * //指定Position所对应的页面的Fragment内容
         *
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        /**
         * //决定Vipage页数的总和
         *
         * @return
         */
        @Override
        public int getCount() {
            if (mMainTitles != null) {
                return mMainTitles.length;
            }
            return 0;
        }

        /**
         * ViewPager和PagerSlidingTabStrip进行绑定,必须复写Adapter中的这个方法,因为这个
         * 方法默认返回的是null
         *
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mMainTitles[position];
        }
    }
}

