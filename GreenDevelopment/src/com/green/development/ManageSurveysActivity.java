package com.green.development;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ManageSurveysActivity extends Activity{

	private DataBaseManager DatabaseHelper;
	
	List<String> names = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//Create and open the database so we can use it
		DatabaseHelper = DataBaseManager.instance();
		setContentView(R.layout.managesurveys);
		
		updateNames();
		ListView lv = (ListView)findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.single_item, names);
		lv.setAdapter(adapter);
		
		lv.setClickable(true);
		lv.setTextFilterEnabled(true);
		lv.setFastScrollEnabled(true);
		
		
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				
				ListView lv = (ListView) arg0;
				TextView tv = (TextView) lv.getChildAt(arg2);
				String selectedsurvey = tv.getText().toString();
				
				toString();
				
				Toast.makeText(getBaseContext(), "the position is "+ selectedsurvey, Toast.LENGTH_SHORT).show();
				
			}
			
		});
		
		
		//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.single_item,names));
		
		//ListView myList = getListView();
		
		
	}

	
	
	
	
	@Override
	protected void onResume() {
		
		super.onResume();
	}

	
	private void updateNames() {
		//private DataBaseManager DatabaseHelper2;
		Cursor cursor = DatabaseHelper.select("SELECT Name FROM pendingsurveys");

        if (cursor == null){
            cursor.close();
        }

        while (cursor.moveToNext()){
        	String s = cursor.getString(0);
        	names.add(s);
       }

        cursor.close();
		
	}
	
	
}
