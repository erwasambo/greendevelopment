package com.green.development;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class TranspDialogActivity extends Activity {
	ProgressDialog dialog;
	AlertDialogManager alert = new AlertDialogManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	
	public void serverError(Exception e) {
		alert.showAlertDialog(
				TranspDialogActivity.this,
				"Network Error",
				"Cannot establish a connection to the server, please check the network"+String.valueOf(e),
				false);
		return;
	}
	
}
