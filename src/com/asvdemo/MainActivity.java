package com.asvdemo;

import com.asvdemo.fragments.OptionListFragment;
import com.asvdemo.fragments.OtherFragment;
import com.asvdemo.fragments.PagesFragmentAdapter;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends BaseActivity {

private Fragment mContent;
	
	public MainActivity() {
		super(R.string.app_name);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// set the Behind View
				setBehindContentView(R.layout.menu_frame);
				getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new OptionListFragment()).commit();
				
				// set the Above View
				setContentView(R.layout.content_frame);
				
				try{
					Intent in  = getIntent();
					
					if(in.getStringExtra("des").equals("1")){
						
						mAdapter = new PagesFragmentAdapter(getSupportFragmentManager());
						mPager = (ViewPager) getLayoutInflater().inflate(R.layout.view_pager, null);
						mPager.setAdapter(mAdapter);
				        setContentView(mPager);

				        mPager.setOnPageChangeListener(new OnPageChangeListener() {
				            @Override
				            public void onPageSelected(int id) {                                
				                switch (id) {
				                case 0:             
				                    getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); //on first page, you can get slidingmenu by swipping the entire screen
				                    break;               
				                default:
				                    getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN); //on others page, you can get slidingmenu by swipping the half screen
				                    break;
				                }                

				            }
				            @Override
				            public void onPageScrolled(int arg0, float arg1, int arg2) {

				            }
				            @Override
				            public void onPageScrollStateChanged(int arg0) {

				            }
				        });
				        
					}else if(in.getStringExtra("des").equals("0")){
						
						if (savedInstanceState != null){
							mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
						}
						if (mContent == null){
							mContent = new OtherFragment();
						}
					
				        // set the Above View
						setContentView(R.layout.content_frame);		
						getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();
		                
						getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
						
					}else if(in.getStringExtra("des").equals("2")){
						
						if (savedInstanceState != null){
							mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
						}
						if (mContent == null){
							mContent = new OtherFragment();
						}
					
				        // set the Above View
						setContentView(R.layout.content_frame);		
						getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();
		                
						getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
						
					}else if(in.getStringExtra("des").equals("3")){
						
						if (savedInstanceState != null){
							mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
						}
						if (mContent == null){
							mContent = new OtherFragment();
						}
					
				        // set the Above View
						setContentView(R.layout.content_frame);		
						getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();
		                
						getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
						
					}else{
					
					}
					
				}catch(NullPointerException e){
					startActivity(new Intent(this, MainActivity.class));
				}		
		        getSlidingMenu().setAboveOffset(40);

		
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	//	getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
	
	public void switchContent(Fragment fragment, int type) {
		// set the Above View
	    setContentView(R.layout.content_frame);
				
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		getSlidingMenu().showContent();
	}
		
	@Override
	public void onBackPressed() {
	   super.onBackPressed();
	   switchFragment(new OtherFragment());
	}
	
	private void switchFragment(Fragment fragment) {
		if (this == null)
			return;
		
		if (this instanceof MainActivity) {
			MainActivity fca = MainActivity.this;
			fca.switchContent(fragment);
		} 
    }

}
