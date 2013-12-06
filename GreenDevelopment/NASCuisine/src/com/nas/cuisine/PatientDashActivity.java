package com.nas.cuisine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class PatientDashActivity extends Activity{

	ImageView imgjoseph;
	ImageView imgmary;
	ImageView imganne;
	ImageView imgolc;
	ImageView imglourdel;
	ImageView imgmccauley;
	ImageView imgrenal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientdash);
		
		
		imgjoseph = (ImageView)findViewById(R.id.imgjoseph);
		imgjoseph.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "St. Joseph's");
			    startActivity(intent);	
	        }
	    });
		
		imgmary = (ImageView)findViewById(R.id.imgmary);
		imgmary.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "St. Mary's");
			    startActivity(intent);	
	        }
	    });
		
		imganne = (ImageView)findViewById(R.id.imganne);
		imganne.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "St. Anne's");
			    startActivity(intent);	
	        }
	    });
		
		imgolc = (ImageView)findViewById(R.id.imgolc);
		imgolc.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "OLC");
			    startActivity(intent);
	        }
	    });
		
		imglourdel = (ImageView)findViewById(R.id.imglourdel);
		imglourdel.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "Lourdel");
			    startActivity(intent);	
	        }
	    });
		
		imgmccauley = (ImageView)findViewById(R.id.imgmccauley);
		imgmccauley.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "McCauley");
			    startActivity(intent);	
	        }
	    });
		
		imgrenal = (ImageView)findViewById(R.id.imgrenal);
		imgrenal.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				intent.putExtra("Selection", "Renal Unit");
			    startActivity(intent);
	        }
	    });
	}

}