package com.green.development;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;


public class SplashscreenActivity extends Activity {
	private static final String PREF_NAME = "SwitchButtonDemo";
 	private static final String PREF_THEME = "isDark";
 	

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	SharedPreferences preferences = this.getSharedPreferences(PREF_NAME, 0);
    	boolean isDark = preferences.getBoolean(PREF_THEME, false);

    	if (isDark)
    		this.setTheme(R.style.AppThemeDark);
    	else
    		this.setTheme(R.style.AppThemeLight);
    	
    	
    	
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_splashscreen);      
        Thread Timer = new Thread(){
        	public void run(){
        		try{
        			sleep(3000);
        			
					Animation animation = AnimationUtils.loadAnimation( SplashscreenActivity.this, R.anim.fade_out );
					animation.setAnimationListener( new AnimationListener()	{				
						@Override
						public void onAnimationStart( Animation animation ) {}
						
						@Override
						public void onAnimationRepeat( Animation animation ) {}
						
						@Override
						public void onAnimationEnd( Animation animation ){
							//button.setVisibility( View.INVISIBLE );
							startActivity( new Intent( SplashscreenActivity.this, HomeActivity.class ) );
							overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
						}
					} );

					Intent homeintent = new Intent(getApplicationContext(), HomeActivity.class);
        			startActivity(homeintent);
        			
        			
        		}
        		
        		catch (InterruptedException e){
        			e.printStackTrace();
        		}
        		finally{
        			finish();
        		}
        	}
        };
        Timer.start();
  
	}

	
    
    
}
