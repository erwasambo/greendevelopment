package com.green.development;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


public class SurveyEditSuccessActivity extends Activity {

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
         setContentView(R.layout.editsurveysuccess);      
        Thread Timer = new Thread(){
        	public void run(){
        		try{
        			sleep(3000);
        			
        			startActivity(new Intent(getApplicationContext(), ManageSurveysActivity.class));
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
