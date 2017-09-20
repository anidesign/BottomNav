package com.weicools.bottomnav;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.weicools.bottomnav.manager.BottomManager;

import static com.weicools.bottomnav.manager.BottomManager.mTabRes;
import static com.weicools.bottomnav.manager.BottomManager.mTabTitle;

public class FragmentTabHostActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    private Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_host);

        mFragments = BottomManager.getFragments("FragmentTabHost Tab");
        initView();
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        // 关联TabHost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.home_container);
        // 监听必须设置在添加Tab之前
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                updateTabState();
            }
        });

        // 添加Tab
        for (int i = 0; i < 3; i++) {
            //生成TabSpec
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTabTitle[i]).setIndicator(BottomManager.getTabView(this, i));
            // 添加Tab 到TabHost，并绑定Fragment
            Bundle bundle = new Bundle();
            bundle.putString("from", "FragmentTabHost Tab");
            mTabHost.addTab(tabSpec, mFragments[i].getClass(), bundle);
        }

        // 去掉Tab 之间的分割线
        mTabHost.getTabWidget().setDividerDrawable(null);
        mTabHost.setCurrentTab(0);
    }

    private void updateTabState() {
        TabWidget tabWidget = mTabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getTabCount(); i++) {
            View view = tabWidget.getChildTabViewAt(i);
            ImageView tabIcon = view.findViewById(R.id.tab_content_image);
            TextView tabText = view.findViewById(R.id.tab_content_text);

            if (i == mTabHost.getCurrentTab()) {
                tabIcon.setImageResource(BottomManager.mTabResPressed[i]);
                tabText.setTextColor(getResources().getColor(R.color.高端黑_black));
            } else {
                tabIcon.setImageResource(mTabRes[i]);
                tabText.setTextColor(getResources().getColor(R.color.低调灰_hoki));
            }
        }
    }
}
