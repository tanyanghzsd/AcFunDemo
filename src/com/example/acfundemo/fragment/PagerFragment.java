package com.example.acfundemo.fragment;

import com.example.acfundemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerFragment extends Fragment {
	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View pager = inflater.inflate(R.layout.fragment_main, container, false);
		tv = (TextView) pager.findViewById(R.id.tv);
		Bundle bundle = getArguments();
		tv.setText(bundle.getInt("page_num")+"");
		return pager;
	}
}
