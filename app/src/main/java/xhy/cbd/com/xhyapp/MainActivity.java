package xhy.cbd.com.xhyapp;

import android.content.Intent;
import android.graphics.Region;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AlphaTabsIndicator alphaTabsIndicator;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = {"重点工作", "街道数据", "信息推送"};

    private ViewPager mViewPger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mViewPger = (ViewPager) findViewById(R.id.mViewPager);


        fragments.add(IPWorkFragment.newInstance());
        fragments.add(RegionFragment.newInstance());
        fragments.add(MsgFragment.newInstance());
        //重点工作二级页面


        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), fragments);
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator);
        //设置透明度
        alphaTabsIndicator.getBackground().setAlpha(80);
        alphaTabsIndicator.setViewPager(mViewPger);
        Intent intent =getIntent();
        if(intent!=null){
            int tabId= intent.getIntExtra("tabId",0);
            mViewPger.setCurrentItem(tabId);
        }

        //.showNumber(6);////显示数字角标
//        alphaTabsIndicator.getTabView(0);
//        alphaTabsIndicator.getTabView(1);
//        alphaTabsIndicator.getTabView(2);
    }

    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments;

        public MainAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (0 == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (2 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
