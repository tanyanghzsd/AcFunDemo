package com.example.acfundemo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.acfundemo.R;
import com.example.acfundemo.adapter.MyListAdapter;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class ListRefreshFragment extends Fragment implements OnRefreshListener{
	private SwipeRefreshLayout mRefreshLayout;
	private ListView lv;
	private List<String> lists;
	private MyListAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.fragment_swipe, container, false);
		lv = (ListView)layout.findViewById(R.id.lv);
		
		lists=getData();
		adapter = new MyListAdapter(getActivity() ,lists);
		lv.setAdapter(adapter);
		
		mRefreshLayout = (SwipeRefreshLayout) layout.findViewById(R.id.refresh_layout);
		mRefreshLayout.setColorScheme(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
		
		
		mRefreshLayout.setOnRefreshListener(this);
		
		return layout;
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            data.add(i + "");
        }
        return data;
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		mRefreshLayout.setRefreshing(true);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mRefreshLayout.setRefreshing(false);
				lists.add("刷新后添加的数据");
				adapter.notifyDataSetChanged();
			}
		}, 3000);
	}
}
