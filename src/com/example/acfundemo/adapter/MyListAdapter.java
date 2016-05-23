package com.example.acfundemo.adapter;

import java.util.List;

import com.example.acfundemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter{
	private List<String> lists;
	private LayoutInflater inflater;
	
	public MyListAdapter(Context context,List<String> lists) {
		// TODO Auto-generated constructor stub
		this.lists=lists;
		this.inflater=LayoutInflater.from(context);
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	class ViewHolder{
		private TextView tv;
	}
	@Override
	public View getView(int arg0, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.listview_item, null);
			viewHolder=new ViewHolder();
			viewHolder.tv=(TextView)convertView.findViewById(R.id.lv_tv);
			
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.tv.setText(lists.get(arg0));
		return convertView;
	}
	
}
