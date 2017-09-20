package com.weicools.bottomnav.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weicools.bottomnav.R;

/**
 * Author: weicools
 * Time: 2017/9/20 下午14:24
 */

public class AccountFragment extends Fragment {
    private String mFrom;

    public static AccountFragment newInstance(String from) {
        AccountFragment fragment = new AccountFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFrom = getArguments().getString("from");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, null);
        TextView textView = view.findViewById(R.id.title_from);
        TextView content = view.findViewById(R.id.fragment_content);
        textView.setText(mFrom);
        content.setText(getString(R.string.account_fragment));
        return view;
    }
}
