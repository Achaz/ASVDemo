package com.asvdemo.fragments;

import com.asvdemo.MainActivity;
import com.asvdemo.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class OptionListFragment extends ListFragment {

	
	public OptionListFragment(){
       
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}
	
	

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		OptionAdapter adapter = new OptionAdapter(getActivity());
		
		adapter.add(new OptionItem("Menu Item 1", R.drawable.ic_launcher));
		adapter.add(new OptionItem("Pages", R.drawable.ic_launcher));
		adapter.add(new OptionItem("Menu Item 2", R.drawable.ic_launcher));
		adapter.add(new OptionItem("Menu Item 3", R.drawable.ic_launcher));
		setListAdapter(adapter);
	
	}

	
	
	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		
		    case 0:
		    	startActivity(new Intent(getActivity(), MainActivity.class).putExtra("des", "0"));
				getActivity().finish();
		    	break;
				
			case 1:
				startActivity(new Intent(getActivity(), MainActivity.class).putExtra("des", "1"));
				getActivity().finish();
				break;
				
			case 2:
				startActivity(new Intent(getActivity(), MainActivity.class).putExtra("des", "2"));
				getActivity().finish();
				break;
			
			case 3:
				startActivity(new Intent(getActivity(), MainActivity.class).putExtra("des", "3"));
				getActivity().finish();
				break;		
							
		}		
	}

	
	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment, int type) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment, type);
		} 
	}
	
	private class OptionItem {
		public String tag;
		public int iconRes;
		public OptionItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class OptionAdapter extends ArrayAdapter<OptionItem> {

		public OptionAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
	
}
