package com.bwei.xiangmu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import com.bwei.xiangmu.cart.Frment_cart;
import com.bwei.xiangmu.home.Frment_home;
import com.bwei.xiangmu.mine.Frment_mine;
import com.bwei.xiangmu.sort.Frment_sort;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> list ;
    MyPageAdapter adapter;
    @BindView(R.id.VP)
    ViewPager VP;
    @BindView(R.id.home_btn1)
    RadioButton homeBtn1;
    @BindView(R.id.home_btn2)
    RadioButton homeBtn2;
    @BindView(R.id.home_btn3)
    RadioButton homeBtn3;
    @BindView(R.id.home_btn4)
    RadioButton homeBtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        VP = (ViewPager) findViewById(R.id.VP);
        list = new ArrayList<Fragment>();
        list.add(new Frment_home());
        list.add(new Frment_sort());
        list.add(new Frment_cart());
        list.add(new Frment_mine());
        adapter = new MyPageAdapter(getSupportFragmentManager());

        VP.setAdapter(adapter);
        VP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        //字体颜色
                        homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                        homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        //图片改变
                        homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home_press), null, null);
                        homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class), null, null);
                        homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart), null, null);
                        homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user), null, null);
                        break;
                    case 1:
                        //字体颜色
                        homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                        homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        //图片改变
                        homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home), null, null);
                        homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class_press), null, null);
                        homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart), null, null);
                        homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user), null, null);
                        break;
                    case 2:
                        //字体颜色
                        homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                        homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        //图片改变
                        homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home), null, null);
                        homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class), null, null);
                        homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart_press), null, null);
                        homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user), null, null);
                        break;
                    case 3:
                        //字体颜色
                        homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                        homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                        //图片改变
                        homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home), null, null);
                        homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class), null, null);
                        homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart), null, null);
                        homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user_press), null, null);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @OnClick({R.id.home_btn1, R.id.home_btn2, R.id.home_btn3, R.id.home_btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_btn1:
                VP.setCurrentItem(0);
                homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                //图片改变
                homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home_press), null, null);
                homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class), null, null);
                homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart), null, null);
                homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user), null, null);
                break;
            case R.id.home_btn2:
                VP.setCurrentItem(1);
                homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                //图片改变
                homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home), null, null);
                homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class_press), null, null);
                homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart), null, null);
                homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user), null, null);
                break;
            case R.id.home_btn3:
                VP.setCurrentItem(2);
                homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                //图片改变
                homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home), null, null);
                homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class), null, null);
                homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart_press), null, null);
                homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user), null, null);
                break;
            case R.id.home_btn4:
                VP.setCurrentItem(3);
                homeBtn1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.nav));
                homeBtn4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.main));
                //图片改变
                homeBtn1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_home), null, null);
                homeBtn2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_class), null, null);
                homeBtn3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_cart), null, null);
                homeBtn4.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_nav_user_press), null, null);
                break;
        }
    }
    class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
