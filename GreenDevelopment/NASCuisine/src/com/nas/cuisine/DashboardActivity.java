package com.nas.cuisine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class DashboardActivity extends Activity{

	ImageView imgpatients;
	ImageView imgfunction;
	ImageView imgstaff;
	ImageView imgadmin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		
		
		imgpatients = (ImageView)findViewById(R.id.imgpatients);
		imgpatients.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//startActivity(new Intent(DashboardActivity.this, HomeActivity.class));
	        	startActivity(new Intent(DashboardActivity.this, PatientDashActivity.class));
	        }
	    });
		
		imgfunction = (ImageView)findViewById(R.id.imgfunction);
		imgfunction.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//startActivity(new Intent(DashboardActivity.this, HomeActivity.class));
	        	Toast.makeText(getApplicationContext(), "Functionality comming soon", Toast.LENGTH_SHORT).show();
	        }
	    });
		
		imgstaff = (ImageView)findViewById(R.id.imgstaff);
		imgstaff.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//startActivity(new Intent(DashboardActivity.this, HomeActivity.class));
	        	Toast.makeText(getApplicationContext(), "Functionality comming soon", Toast.LENGTH_SHORT).show();
	        }
	    });
		
		imgadmin = (ImageView)findViewById(R.id.imgadmin);
		imgadmin.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	startActivity(new Intent(DashboardActivity.this, AdminActivity.class));
	        }
	    });
		
	}

}