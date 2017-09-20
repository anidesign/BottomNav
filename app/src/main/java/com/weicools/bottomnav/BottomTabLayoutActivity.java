package com.weicools.bottomnav;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weicools.bottomnav.data.BottomData;

public class BottomTabLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_layout);

        mFragments = BottomData.getFragments("TabLayout Tab");
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.bottom_tab_layout);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
                for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                    View view = mTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = view.findViewById(R.id.tab_content_image);
                    TextView text = view.findViewById(R.id.tab_content_text);
                    if (i == tab.getPosition()) {
                        icon.setImageResource(BottomData.mTabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));
                    } else {
                        icon.setImageResource(BottomData.mTabRes[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < 4; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(BottomData.getTabView(this, i)));
        }
    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = mFragments[0];
                break;
            case 1:
                fragment = mFragments[1];
                break;

            case 2:
                fragment = mFragments[2];
                break;
            case 3:
                fragment = mFragments[3];
                break;
        }

        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }
}
