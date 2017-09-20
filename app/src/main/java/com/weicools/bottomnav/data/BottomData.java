package com.weicools.bottomnav.data;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weicools.bottomnav.R;
import com.weicools.bottomnav.fragment.AccountFragment;
import com.weicools.bottomnav.fragment.AndroidDevFragment;
import com.weicools.bottomnav.fragment.HomeFragment;

/**
 * Author: weicools
 * Time: 2017/9/20 下午12:32
 */

public class BottomData {
    public static final int[] mTabRes = new int[]{
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_android_black_24dp,
            R.drawable.ic_account_circle_black_24dp
    };
    public static final int[] mTabResPressed = new int[]{
            R.drawable.ic_home_purple_200_24dp,
            R.drawable.ic_android_purple_200_24dp,
            R.drawable.ic_account_circle_purple_200_24dp
    };
    private static final String[] mTabTitle = new String[]{"首页", "开发", "个人"};

    public static Fragment[] getFragments(String from) {
        Fragment fragments[] = new Fragment[3];
        fragments[0] = HomeFragment.newInstance(from);
        fragments[1] = AndroidDevFragment.newInstance(from);
        fragments[2] = AccountFragment.newInstance(from);
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     *
     * @param context   上下文
     * @param position  位置
     * @return  view
     */
    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_tab_content, null);
        ImageView tabIcon = view.findViewById(R.id.tab_content_image);
        TextView tabText = view.findViewById(R.id.tab_content_text);

        tabIcon.setImageResource(BottomData.mTabRes[position]);
        tabText.setText(mTabTitle[position]);

        return view;
    }
}
