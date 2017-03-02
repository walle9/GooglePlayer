package com.walle.googleplayer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
        initview();
        initActionBarDrawerToggle();

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
}

