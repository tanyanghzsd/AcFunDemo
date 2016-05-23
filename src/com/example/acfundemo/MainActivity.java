package com.example.acfundemo;

import com.astuetz.PagerSlidingTabStrip;
import com.example.acfundemo.adapter.MyPagerAdapter;
import com.example.acfundemo.listener.MyOnPageChangeListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Window;

public class MainActivity extends FragmentActivity {

	private ViewPager pager;
	private PagerSlidingTabStrip tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		pager = (ViewPager) findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
		pager.setOffscreenPageLimit(3);
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources()
				.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);

		tabs.setOnPageChangeListener(new MyOnPageChangeListener());
	}

}
