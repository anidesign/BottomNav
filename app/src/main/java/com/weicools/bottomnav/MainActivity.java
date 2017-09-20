package com.weicools.bottomnav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.by_tab_Layout).setOnClickListener(this);
        findViewById(R.id.by_bottom_navigation_view).setOnClickListener(this);
        findViewById(R.id.by_fragment_tab_host).setOnClickListener(this);
        findViewById(R.id.by_radio_group).setOnClickListener(this);
        findViewById(R.id.by_custom_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.by_tab_Layout:
                intent = new Intent(this,BottomTabLayoutActivity.class);
                break;
            case R.id.by_bottom_navigation_view:
                intent = new Intent(this,BottomNavigationViewActivity.class);
                break;
            case R.id.by_fragment_tab_host:

                break;
            case R.id.by_radio_group:

                break;
            case R.id.by_custom_view:

                break;
        }

        if(intent!=null){
            startActivity(intent);
        }
    }
}
