package com.asvdemo.fragments;

import com.asvdemo.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class Page extends ListFragment{
	
	String json = "", URL, tag;
	private DisplayMetrics metrics;  
	
	public Page(String tag) {
		this.tag = tag;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pager_list_content, null);
	}	

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getActivity().setTitle("Events");
		
		metrics = new DisplayMetrics();
	    getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

			new PagesFetcher().execute();
	
	}
		
	private class PageItem {
		public String title, details, url;
		
		public PageItem(String title, String details, String url) {
			this.title = title; 
			this.details = details; 
			this.url = url;
		}
	}

	public class PagesAdapter extends ArrayAdapter<PageItem> {

		  private Context context;
		  private LayoutInflater mInflater;
		  private DisplayMetrics metrics_;
		  
		public PagesAdapter(Context context, DisplayMetrics metrics) {
			super(context, 0);
			this.context = context;
			this.mInflater = (LayoutInflater) this.context
				     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);			
			this.metrics_ = metrics;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Animation animation = null;
			
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.plc_row, null);
			}
			
			animation = AnimationUtils.loadAnimation(context, R.anim.slide_top_to_bottom);
			
			TextView title = (TextView) convertView.findViewById(R.id.PG_TITLE);
			title.setText(getItem(position).title);
			
			TextView details = (TextView) convertView.findViewById(R.id.PG_DETAILS);
			details.setText(getItem(position).details);
			
			ImageView image = (ImageView) convertView.findViewById(R.id.PG_IMAGE);
			image.setImageResource(R.drawable.ic_launcher);
			
			   animation.setDuration(500);
			   convertView.startAnimation(animation);
			   animation = null;
			return convertView;
		}

	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
						   
		Toast.makeText(getActivity(), "Clicked item at index: "+position, Toast.LENGTH_SHORT).show();
		
	}
	
	private class PagesFetcher extends AsyncTask<String, String, String> {
	    	
	    	ProgressDialog dialog;
	    	
	    	@Override
	    	protected void onPreExecute(){
	    	     dialog = ProgressDialog.show(getActivity(), "Loading","Wait...", true);
	    	        //do initialization of required objects objects here                
	    	};
	         
			@Override
			protected String doInBackground(String... params) {
			
				String response = "";						
				
				return response;
			}
			
			@Override
	        protected void onPostExecute(String res) {			
				dialog.dismiss();
				
				PagesAdapter adapter = new PagesAdapter(getActivity(), metrics);
				
				for(int i = 0; i < 10; i++){
					adapter.add(new PageItem("Demo Page Title", "This is a place where men come and share life together, "
	   		                 + "and expose themselves to topics that grow them "
	   		                + "individually make sure you dont miss it tis time round", ""));
				}
				
				setListAdapter(adapter);
			}
			
	}
	
	
}
