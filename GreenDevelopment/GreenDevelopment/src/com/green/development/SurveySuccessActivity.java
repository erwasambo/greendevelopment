package com.green.development;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


public class SurveySuccessActivity extends Activity {

	private static final String PREF_NAME = "SwitchButtonDemo";
 	private static final String PREF_THEME = "isDark";
 	

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	SharedPreferences preferences = this.getSharedPreferences(PREF_NAME, 0);
    	boolean isDark = preferences.getBoolean(PREF_THEME, false);
    	
    	this.setTheme(R.style.AppThemeLight);
    	
        super.onCreate(savedInstanceState);
         setContentView(R.layout.surveysuccess);      
        Thread Timer = new Thread(){
        	public void run(){
        		try{
        			sleep(3000);
        			
        			startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        			overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
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
