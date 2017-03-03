package com.walle.googleplayer.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.walle.googleplayer.utils.UIUtils;

/**
 * Created by walle9 on 2017/3/3.
 */
public class SubjectFragment extends android.support.v4.app.Fragment {

    /**
     * 最有必要重写的方法,返回一个View给Fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLUE);
        textView.setText(this.getClass().getSimpleName());  //HomeFragment
        return textView;
    }

}
