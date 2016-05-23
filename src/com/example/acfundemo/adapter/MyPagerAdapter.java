package com.example.acfundemo.adapter;

import com.example.acfundemo.fragment.ListRefreshFragment;
import com.example.acfundemo.fragment.PagerFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
	private final String[] TITLES={"关注","推荐","番剧","娱乐","文章","频道"};
	private final int NUM_OF_PAGERS=6;
	
	public MyPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return NUM_OF_PAGERS;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return TITLES[position];
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		if(position==2){
			return new ListRefreshFragment();
		}else{
			Bundle bundle = new Bundle();
			Fragment pagerFragment = new PagerFragment();
			bundle.putInt("page_num", position);
			pagerFragment.setArguments(bundle);
			return pagerFragment;
		}
	}

}
