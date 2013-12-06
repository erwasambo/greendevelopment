package com.green.development;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class UserConfigActivity extends Activity{
	Button saveconfig;
	EditText organisation;
	EditText person;
	Spinner country;
	Spinner area;
	SQLiteDatabase myDataBase;
	SQLiteDatabase mywritableDataBase;
	
	private DataBaseManager DatabaseHelpers;
	private ArrayList<String> countries = new ArrayList<String>();
	private ArrayList<String> projectareas = new ArrayList<String>();
	private ArrayList<String> preloadeddatadb = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usercofig);
		
		DatabaseHelpers = DataBaseManager.instance();
		
		myDataBase = DatabaseHelpers.getReadableDatabase();
		mywritableDataBase = DatabaseHelpers.getWritableDatabase();
		
		organisation  = (EditText) findViewById(R.id.editTextorga);
		person = (EditText) findViewById (R.id.editTextperson);
		country = (Spinner) findViewById(R.id.countrySpinner);
		area = (Spinner) findViewById(R.id.areaSpinner);
		saveconfig = (Button)findViewById(R.id.btnSave);
		
		updateCountries();
		updateAreas();
		preloadData();
		
		ArrayAdapter<String> ctyadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries);
		ctyadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		country.setAdapter(ctyadapter);

		organisation.setText(preloadeddatadb.get(0));
		person.setText(preloadeddatadb.get(1));
		area.setSelection(projectareas.indexOf(preloadeddatadb.get(2)));

		saveconfig.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				String dborganisation = organisation.getText().toString();
				String dbperson = person.getText().toString();
				String dbcountry = country.getSelectedItem().toString();
				String dbarea = area.getSelectedItem().toString();
				
				
				ContentValues userdatavalues = new ContentValues();
				
				userdatavalues.put("Organization" ,dborganisation);
				userdatavalues.put("Name" ,dbperson);
				userdatavalues.put("Country" ,dbcountry);
				userdatavalues.put("Area" ,dbarea);

	        	mywritableDataBase.update("userdata", userdatavalues, "Id = '1'", null);
	        	goBack();
			}
			
		});
		
		
		
		
		country.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				Object item = arg0.getSelectedItem();
				String selection = item.toString();
				
				if (item!=null) {

					if (selection=="All Countries"){
						
						giveAllAreas();
						
						Log.e("No of items Readied index is", "the count is" +preloadeddatadb.size());
						area.setSelection(projectareas.indexOf(preloadeddatadb.get(2)));
						
					}else{
						giveSpecificAreas(selection);
						area.setSelection(0);
						
					}

                }
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}

			
		});
		

		
	}
	
	
	private void goBack(){
		finish();
		overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
	}

	@Override
	public boolean onKeyUp( int keyCode, KeyEvent event ){
		if( keyCode == KeyEvent.KEYCODE_BACK )
		{
			goBack();
			return true;
		}
		return super.onKeyUp( keyCode, event );
	}
	
	
	private void updateCountries() {
		Cursor cursor = DatabaseHelpers.select("SELECT Country FROM Area");

		countries.add("All Countries");
		
        if (cursor == null){
            cursor.close();
        }

        while (cursor.moveToNext()){
        	String s = cursor.getString(0);
        	if (countries.contains(s)){
        		//Do nothing
        	}else{
        		countries.add(s);
        	}
       }

        cursor.close();
		
	}
	

	private void updateAreas() {
		Cursor cursor = DatabaseHelpers.select("SELECT CDMProjectArea FROM Area");
		
		projectareas.add("All Areas");
        
		if (cursor == null){
            cursor.close();
        }

        while (cursor.moveToNext()){
        	String s = cursor.getString(0);
        	projectareas.add(s);
       }

        cursor.close();
		
	}
	
	private ArrayList<String> giveAreasArray() {
		
		ArrayList<String> newareas = new ArrayList<String>();
		
		
		Cursor cursor = DatabaseHelpers.select("SELECT CDMProjectArea FROM Area");
		
		newareas.add("All Areas");
        
		if (cursor == null){
            cursor.close();
        }

        while (cursor.moveToNext()){
        	String s = cursor.getString(0);
        	newareas.add(s);
       }

        cursor.close();
        
       
		return newareas;
		
	}
	
	private void giveAllAreas() {
		ArrayList<String> newareas = giveAreasArray();
		ArrayAdapter<String> areaadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, newareas);
		areaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		area.setAdapter(areaadapter);

	}

	private ArrayList<String> giveAreasofaCountry(String country) {
		
		ArrayList<String> newareas = new ArrayList<String>();
		
		String sqlquery = "SELECT CDMProjectArea FROM Area WHERE Country = '"+country+"'";
		Cursor cursor = myDataBase.rawQuery(sqlquery, null);
		
		if (cursor == null){
            cursor.close();
        }

        while (cursor.moveToNext()){
        	String s = cursor.getString(0);
        	newareas.add(s);
       }

        cursor.close();
        
       
		return newareas;
		
	}
	
	private void giveSpecificAreas(String country) {
		
		ArrayList<String> newareas = giveAreasofaCountry(country);
		ArrayAdapter<String> areaadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, newareas);
		areaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		area.setAdapter(areaadapter);

	}
	
	private void preloadData() {
		Cursor cursor = DatabaseHelpers.select("SELECT Organization, Name, Area FROM userdata");
		if (cursor == null){
			cursor.close();
		}
		while (cursor.moveToNext()){
				String organisation = cursor.getString(0);
				String name = cursor.getString(1);
				String area = cursor.getString(2);
				preloadeddatadb.add(organisation);
				preloadeddatadb.add(name);
				preloadeddatadb.add(area);
		}
		cursor.close();
	}

}
