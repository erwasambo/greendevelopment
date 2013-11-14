package com.green.development;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends Activity{
	
	private DataBaseManager DatabaseHelpers;
	private String table1 = "general";
	private String table21 = "interpspeed";
	SQLiteDatabase myDataBase;
	ImageView cleardb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		//Create and open the database so we can use it
		DatabaseHelpers = DataBaseManager.instance();
		
		myDataBase = DatabaseHelpers.getWritableDatabase();
		
		//Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.speed, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		//spinner.setAdapter(adapter);
		
		int retspeed =  getSpeed();
		
		//int position = returnPosition();
		
	
		//spinner.setSelection(returnPosition(retspeed));
		
		
		
		Button savesettings  =(Button)findViewById(R.id.btnTakeSurvey);
		savesettings.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	DataBaseManager DatabaseHelpers2 = DataBaseManager.instance();
	        	SQLiteDatabase db = DatabaseHelpers2.getWritableDatabase();
	        	//Spinner spinner2 = (Spinner) findViewById(R.id.spinner1);
	        	//String speed= spinner2.getSelectedItem().toString();
	        	String  speedcolumn = "speed";
	        	ContentValues maelewanovalues = new ContentValues();
	        	//Map<Integer,Integer> speedcharCounter=new HashMap<Integer,Integer>();
	        	int speedin;
	        	 //Log.e("Speed", "****************selected item in spin is**************** is "+speed);
	        	// String currentvalue = speed.replace(" Seconds", "000");
	        	 //Log.e("Speed", "****************selected item in spin is**************** is "+currentvalue);
	        	
	        	
	        	
	        	//maelewanovalues.put(speedcolumn, currentvalue);
	        	db.update(table21, maelewanovalues, null, null);

	        	Toast.makeText(getApplicationContext(), "Settings Saved", Toast.LENGTH_LONG).show();

	        	finish();
	        	
	        }
	    });
	}
	
	public static int returnPosition(int retspeed){
		
		int position = 0;
    	if (retspeed == 12000){
    		position = 0;
    	}else if (retspeed == 15000){
    		position = 1;
    	}else if (retspeed == 18000){
    		position = 2;
    	}else if (retspeed == 21000){
    		position = 3;
    	}else if (retspeed == 30000){
    		position = 4;
    	}
		return position;
	}
	public static int getSpeed(){
		DataBaseManager DatabaseHelpers2 = DataBaseManager.instance();
    	SQLiteDatabase db3 = DatabaseHelpers2.getReadableDatabase();
    	String speedtable = "interpspeed";
    	
    	String Sql = "SELECT speed FROM interpspeed";
    	Cursor cursor = DatabaseHelpers2.select(Sql);
    	int value = 12000;
    	if (cursor == null){
    		cursor.close();
		}
		if (cursor.getCount()==1){
			cursor.moveToFirst();
			 value = cursor.getInt(0);
			 Log.e("Speed", "***********Speed in db********************* is "+value);
		}else{
		while (cursor.moveToNext()){
			value= cursor.getInt(0);
			 Log.e("Speed", "***********Speed in db********************* is "+value);
		}
		}
		cursor.close();
	return value;
	}
}
