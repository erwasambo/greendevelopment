package com.green.development;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HomeActivity extends Activity {
	ImageView takesurv;
	ImageView sbmtsurveys;
	ImageView userconfig;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		takesurv = (ImageView)findViewById(R.id.imgtakesrvy);
		sbmtsurveys  = (ImageView)findViewById(R.id.imgsubmitsurvy);
		userconfig = (ImageView)findViewById(R.id.imgusrconfig);
		
		takesurv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Animation animation = AnimationUtils.loadAnimation( HomeActivity.this, R.anim.fade_out );
				animation.setAnimationListener( new AnimationListener()	{				
					@Override
					public void onAnimationStart( Animation animation ) {}
					
					@Override
					public void onAnimationRepeat( Animation animation ) {}
					
					@Override
					public void onAnimationEnd( Animation animation )
					{
						takesurv.setVisibility( View.INVISIBLE );
						startActivity( new Intent( HomeActivity.this, SurveyActivity.class ) );
						overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
					}
				} );
				
				//startActivity(new Intent ("com.green.development.survey"));
				takesurv.startAnimation(animation);
			}
		});
		
		sbmtsurveys.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Animation animation = AnimationUtils.loadAnimation( HomeActivity.this, R.anim.fade_out );
				animation.setAnimationListener( new AnimationListener()	{				
					@Override
					public void onAnimationStart( Animation animation ) {}
					
					@Override
					public void onAnimationRepeat( Animation animation ) {}
					
					@Override
					public void onAnimationEnd( Animation animation )
					{
						sbmtsurveys.setVisibility( View.INVISIBLE );
						startActivity( new Intent( HomeActivity.this, ManageSurveysActivity.class ) );
						overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
					}
				} );
				
				//startActivity(new Intent ("com.green.development.survey"));
				sbmtsurveys.startAnimation(animation);
			}
		});
		
		userconfig.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Animation animation = AnimationUtils.loadAnimation( HomeActivity.this, R.anim.fade_out );
				animation.setAnimationListener( new AnimationListener()	{				
					@Override
					public void onAnimationStart( Animation animation ) {}
					
					@Override
					public void onAnimationRepeat( Animation animation ) {}
					
					@Override
					public void onAnimationEnd( Animation animation )
					{
						userconfig.setVisibility( View.INVISIBLE );
						startActivity( new Intent( HomeActivity.this, UserConfigActivity.class ) );
						overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
					}
				} );

				userconfig.startAnimation(animation);
			}
		});
		
	}

	@Override
	protected void onResume() {
		findViewById( R.id.imgtakesrvy ).setVisibility( View.VISIBLE );
		findViewById( R.id.imgsubmitsurvy ).setVisibility( View.VISIBLE );
		findViewById(R.id.imgusrconfig).setVisibility(View.VISIBLE);
		super.onResume();
	}
	
	
}
