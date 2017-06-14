package xhy.cbd.com.xhyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * 作者: lisheng on 2017/6/13.
 * 邮箱:1021337635@qq.com
 */

public class RegionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.region_fragment,container,false);


        return view;
    }


    /**
     * 返回RegionFragment实例
     * @return
     */
    public static RegionFragment newInstance() {
        RegionFragment fragment = new RegionFragment();
        return fragment;
    }
}
