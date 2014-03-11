package com.green.development;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ResponseReceiver extends BroadcastReceiver {
	
	public static final String ACTION_RESP =    
		      "com.green.development.intent.action.MESSAGE_PROCESSED";
		    
	

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Log.v("BroadCast Receiver", "The receiver request has been recorded");
		
		
		/* TextView result = (TextView) findViewById(R.id.txt_result);
	       String text = intent.getStringExtra(SimpleIntentService.PARAM_OUT_MSG);
	       result.setText(text);*/
		
	}

}
