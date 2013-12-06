package com.green.development;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SurveySuccessActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.surveysuccess);      
        Thread Timer = new Thread(){
        	public void run(){
        		try{
        			sleep(3000);
        			
        			startActivity(new Intent("com.green.development.home"));
        			overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
        			//takesurveybtn.startAnimation(animation);
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
