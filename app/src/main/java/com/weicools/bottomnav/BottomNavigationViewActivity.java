package com.weicools.bottomnav;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.weicools.bottomnav.manager.BottomManager;

public class BottomNavigationViewActivity extends AppCompatActivity {
    private Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        mFragments = BottomManager.getFragments("BottomNavigationView Tab");
        initView();
    }

    private void initView() {
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onBottomNavItemSelected(item.getItemId());
                return true;
            }
        });

        // 由于第一次进来没有回调onNavigationItemSelected，因此需要手动调用一下切换状态的方法
        onBottomNavItemSelected(R.id.nav_menu_home);
    }

    private void onBottomNavItemSelected(int position) {
        Fragment fragment = null;
        switch (position){
            case R.id.nav_menu_home:
                fragment = mFragments[0];
                break;
            case R.id.nav_menu_dev:
                fragment = mFragments[1];
                break;

            case R.id.nav_menu_account:
                fragment = mFragments[2];
                break;
        }

        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }
}
