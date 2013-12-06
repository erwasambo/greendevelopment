package com.gor.mahia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;


public class SplashscreenActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
							//startActivity( new Intent( SplashscreenActivity.this, HomeActivity.class ) );
							startActivity( new Intent( SplashscreenActivity.this, MainActivity.class ) );
							overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
						}
					} );
					
					//startAnimation( animation );
					//button.startAnimation( animation );
					//startActivity( new Intent( SplashscreenActivity.this, HomeActivity.class ) );
					startActivity( new Intent( SplashscreenActivity.this, MainActivity.class ) );
        			
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
