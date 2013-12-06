package com.nas.cuisine;


import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.TextView;

import com.slidinglayer.SlidingLayer;
import com.viewpagerindicator.TabPageIndicator;

import com.nas.cuisine.TestFragment;
import com.nas.cuisine.HomeActivity.GoogleMusicAdapter;

import uk.co.senab.actionbarpulltorefresh.extras.actionbarsherlock.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * A sample which show you how to use PullToRefreshLayout with Fragments in a ViewPager.
 */

public class HomeActivity extends SherlockFragmentActivity {
	
	private SlidingLayer mSlidingLayer;
    private ListView swipeList;

    private String mStickContainerToRightLeftOrMiddle;
    private boolean mShowShadow;
    private boolean mShowOffset;
	
    private static final String[] songs = { "Sync Data","My profile", "Settings", "Log out" };
    private static String EXTRA_TITLE = "extra_title";
    private FragmentTabPager mFragmentTabPager;
    private static final String[] CONTENT = new String[] { "19", "20", "21", "22A", "22B", "22C" };
    
    
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        Intent myIntent = getIntent();
		String prevselection = myIntent.getExtras().getString("Selection");
        setTitle(prevselection);
        
        getPrefs();
        bindViews();
        initState();

        
        ViewPager vp = (ViewPager) findViewById(R.id.ptr_viewpager);
        mFragmentTabPager = new FragmentTabPager(this, vp);
        
        // Add 3 tabs which will switch fragments
        ActionBar ab = getSupportActionBar();
        
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Bundle b = new Bundle();
        b.putString(EXTRA_TITLE, "Patients");
        mFragmentTabPager.addTab(ab.newTab().setText("Patients"), PatientsFragment.class, b);

        b = new Bundle();
        b.putString(EXTRA_TITLE, "Summary");
        mFragmentTabPager.addTab(ab.newTab().setText("Summary"), SampleFragment.class, b);
        
        b = new Bundle();
        b.putString(EXTRA_TITLE, "Transfer Voucher");
        mFragmentTabPager.addTab(ab.newTab().setText("Transfer Voucher"), SampleFragment.class, b);

        b = new Bundle();
        b.putString(EXTRA_TITLE, "Day Care");
        mFragmentTabPager.addTab(ab.newTab().setText("Day Care"), SampleFragment.class, b);   
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.actionbarmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_second:
            	//show user dialogue box popup for sign-out
            	if (!mSlidingLayer.isOpened()) {
                    mSlidingLayer.openLayer(true);
                }
				
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
   @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_BACK:
            if (mSlidingLayer.isOpened()) {
                mSlidingLayer.closeLayer(true);
                return true;
            }

        default:
            return super.onKeyDown(keyCode, event);
        }
    }

   //View binding

    private void bindViews() {
        mSlidingLayer = (SlidingLayer) findViewById(R.id.slidingLayer1);
        swipeList = (ListView)findViewById(R.id.listViewmenu);
        
        swipeList.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if(convertView == null) {
					convertView = getLayoutInflater().inflate(R.layout.listitem_menu, null);
				}
				((TextView) convertView).setText(getItem(position));
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				return songs[position].hashCode();
			}

			@Override
			public String getItem(int position) {
				return songs[position];
			}

			@Override
			public int getCount() {
				return songs.length;
			}
		});
        
        
        
        
        swipeList.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				
				Toast.makeText(getApplicationContext(), "Functionality comming soon", Toast.LENGTH_SHORT).show();
				
				
				/*String selecteditem = songs[position];
				
				if (selecteditem == "Log out" ){
					startActivity(new Intent(HomeActivity.this, LoginActivity.class));
					
				}else{
					Toast.makeText(getApplicationContext(), "Functionality comming soon", Toast.LENGTH_SHORT).show();
				}*/
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
        
    }

    
     //Get current value for preferences
     
    private void getPrefs() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        mStickContainerToRightLeftOrMiddle = prefs.getString("layer_location", "left");
        mShowShadow = prefs.getBoolean("layer_has_shadow", true);
        mShowOffset = prefs.getBoolean("layer_has_offset", false);
    }
    //Initializes the origin state of the layer

    private void initState() {
    	mStickContainerToRightLeftOrMiddle.equals("left");
        LayoutParams rlp = (LayoutParams) mSlidingLayer.getLayoutParams();
        int textResource;
        Drawable d;

        if (mStickContainerToRightLeftOrMiddle.equals("right")) {
            textResource = R.string.swipe_right_label;
            rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        } else if (mStickContainerToRightLeftOrMiddle.equals("left")) {
            textResource = R.string.swipe_left_label;
            rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        } else if (mStickContainerToRightLeftOrMiddle.equals("top")) {
            textResource = R.string.swipe_up_label;
            mSlidingLayer.setStickTo(SlidingLayer.STICK_TO_TOP);
            rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            rlp.width = LayoutParams.MATCH_PARENT;
            rlp.height = getResources().getDimensionPixelSize(R.dimen.layer_width);
        } else if (mStickContainerToRightLeftOrMiddle.equals("bottom")) {
            textResource = R.string.swipe_down_label;
            mSlidingLayer.setStickTo(SlidingLayer.STICK_TO_BOTTOM);
            rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            rlp.width = LayoutParams.MATCH_PARENT;
            rlp.height = getResources().getDimensionPixelSize(R.dimen.layer_width);
        } else {
            textResource = R.string.swipe_label;
            rlp.addRule(RelativeLayout.CENTER_IN_PARENT);
            rlp.width = LayoutParams.MATCH_PARENT;
        }
        mSlidingLayer.setLayoutParams(rlp);

        // Sets the shadow of the container
        if (mShowShadow) {
            mSlidingLayer.setShadowWidthRes(R.dimen.shadow_width);
            mSlidingLayer.setShadowDrawable(R.drawable.sidebar_shadow);
        } else {
            mSlidingLayer.setShadowWidth(20);
            mSlidingLayer.setShadowDrawable(null);
        }
        if(mShowOffset) {
            mSlidingLayer.setOffsetWidth(getResources().getDimensionPixelOffset(R.dimen.offset_width));
        } else {
            mSlidingLayer.setOffsetWidth(0);
        }
    }
    
    /**
     * Fragment Class
     */
    public static class SampleFragment extends SherlockFragment implements OnRefreshListener {
        private PullToRefreshLayout mPullToRefreshLayout;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout
            View view = inflater.inflate(R.layout.layout_fragment, container, false);
            // Now give the find the PullToRefreshLayout and set it up
            mPullToRefreshLayout = (PullToRefreshLayout) view.findViewById(R.id.ptr_layout);
            ActionBarPullToRefresh.from(getActivity())
                    .allChildrenArePullable()
                    .listener(this)
                    .setup(mPullToRefreshLayout);
            // Set title in Fragment for display purposes.
            //StaggeredGridView gridView = (StaggeredGridView) view.findViewById(R.id.staggeredGridView1);
            int margin = getResources().getDimensionPixelSize(R.dimen.margin);        
            Bundle b = getArguments();
            if (b != null) {      	
            	//load data into the fragment children e.g. gridview
            }
            return view;
        }

        @Override
        public void onRefreshStarted(View view) {
            //Simulate Refresh with 4 seconds sleep
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                @Override
                protected void onPostExecute(Void result) {
                    super.onPostExecute(result);
                    // Notify PullToRefreshLayout that the refresh has finished
                    mPullToRefreshLayout.setRefreshComplete();
                }
            }.execute();
        }
    }
   
    
    public  class GoogleMusicAdapter extends FragmentPagerAdapter {
        public  GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
          return CONTENT.length;
        }
    }
    
    
    
    
}
