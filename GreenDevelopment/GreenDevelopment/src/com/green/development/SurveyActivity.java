package com.green.development;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import android.widget.Toast;


import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;



import android.widget.CompoundButton;

import de.ankri.views.Switch;

@SuppressLint("NewApi")
public class SurveyActivity extends Activity {
        EditText fullname, address, phone, organization, personresp;
        Spinner projarea;
        Switch ethanol, biogas, purwater;
        Button photoButton, signature;
        ProgressDialog dialog;
        ConnectionDetector cd;
		String filename, image_resource, preloadorganization,preloadpersonresp, preloadarea;
        ImageView imageView;
        
        private DataBaseManager DatabaseHelpers;
		private Bitmap bmp = null;
		private byte[] data2=null;
		Cursor cursor;

        GPSTracker gps = new GPSTracker (SurveyActivity.this);
        SQLiteDatabase myDataBase;

        
        private static final int CAMERA_REQUEST = 1888;
        UserFunctions funcs = new UserFunctions();
        ArrayList<String> projectareas = new ArrayList<String>();
        ArrayList<String> preloadeddatadb = new ArrayList<String>();

        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
        final java.util.Random rand = new java.util.Random();
        final Set<String> identifiers = new HashSet<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
            super.onCreate(savedInstanceState);
			setContentView(R.layout.survey);
			DatabaseHelpers = DataBaseManager.instance();
            myDataBase = DatabaseHelpers.getWritableDatabase();
			fullname = (EditText) findViewById(R.id.editTextorga);
            address = (EditText) findViewById(R.id.editTextperson);
            phone = (EditText) findViewById(R.id.editTextphone);
            organization = (EditText) findViewById(R.id.organizationeditText1);
            personresp = (EditText) findViewById(R.id.personrespeditText2);
            projarea = (Spinner) findViewById(R.id.countrySpinner);
            ethanol = (Switch) findViewById(R.id.switchEthanolstv);
            biogas = (Switch) findViewById(R.id.switchBiogasstv);
            purwater = (Switch) findViewById(R.id.switchPurifiedwater);
            photoButton = (Button) this.findViewById(R.id.cap_button);
			signature = (Button) this.findViewById(R.id.btnSave);
			imageView = (ImageView)this.findViewById(R.id.sceneImage);
			
			updateProjectAreas();
			preloadData();
			preloadorganization = preloadeddatadb.get(0);
			preloadpersonresp = preloadeddatadb.get(1);
			preloadarea = preloadeddatadb.get(2);

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, projectareas);
					adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			projarea.setAdapter(adapter);

			organization.setText(preloadorganization);
			personresp.setText(preloadpersonresp);
			projarea.setSelection(projectareas.indexOf(preloadarea));
			
			photoButton.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
					startActivityForResult(cameraIntent, CAMERA_REQUEST);
				}
			});
			
			signature.setOnClickListener(new View.OnClickListener() {
							
					@Override
					public void onClick(View v) {                
						 String dbfullname = fullname.getText().toString();
						 String dbaddress = address.getText().toString();
						 String dbphone = phone.getText().toString();
						 String dborganization = organization.getText().toString();
						 String dbpersonresp = personresp.getText().toString();
						 String dbprojarea = projarea.getSelectedItem().toString();
						 String dbethanol = String.valueOf(ethanol.isChecked());
						 String dbbiogas = String.valueOf(biogas.isChecked());
						 String dbpurwater = String.valueOf(purwater.isChecked());
					 if(dbfullname.isEmpty()|| dbaddress.isEmpty()|| dbphone.isEmpty() || dborganization.isEmpty() || dbpersonresp.isEmpty() || dbprojarea.isEmpty()){
							 Toast.makeText(getApplicationContext(), "Please Fill All Fields Before Proceeding", Toast.LENGTH_SHORT).show();
					 }else{
		 					giveImgDataValue();
		 					saveImgtoSDcard();
		 					ContentValues surveyvalues = new ContentValues();
					 		surveyvalues.put("Name", dbfullname);
							surveyvalues.put("Address", dbaddress);
							surveyvalues.put("PhoneNumber", dbphone);
							surveyvalues.put("SDPicPathName", filename);
							surveyvalues.put("Organization", dborganization);
							surveyvalues.put("PersfillingForm", dbpersonresp);
							surveyvalues.put("CDMProjectArea", dbprojarea);
							surveyvalues.put("EthanolStv", dbethanol);
							surveyvalues.put("BiogasStv", dbbiogas);
							surveyvalues.put("PurifiedWat", dbpurwater);
		 					
							myDataBase.insert("pendingsurveys", null, surveyvalues);
							
							Animation animation = AnimationUtils.loadAnimation( SurveyActivity.this, R.anim.fade_out );
							animation.setAnimationListener( new AnimationListener()        {                                
									@Override
									public void onAnimationStart( Animation animation ) {}
									
									@Override
									public void onAnimationRepeat( Animation animation ) {}
									
									@Override
									public void onAnimationEnd( Animation animation ){
											signature.setVisibility( View.INVISIBLE );
											finish();
											startActivity( new Intent( SurveyActivity.this, SurveySuccessActivity.class ) );
											overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
									}
							} );
							signature.startAnimation(animation);  
							myDataBase.close();
							
					 	}
					}	
			});
    }

    private void updateProjectAreas() {
        Cursor cursor = DatabaseHelpers.select("SELECT CDMProjectArea FROM Area");
		if (cursor == null){
			cursor.close();
		}
		while (cursor.moveToNext()){
				String s = cursor.getString(0);
				projectareas.add(s);
		}
		cursor.close();
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
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    
    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++){
		        builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
		            if(identifiers.contains(builder.toString())){ 
		                builder = new StringBuilder();
		            }
            }
         
	    }
	return builder.toString();    
    }  
	    
    public void giveImgDataValue(){
            ImageView sceneImage = (ImageView) findViewById(R.id.sceneImage);
            BitmapDrawable drawable = (BitmapDrawable) sceneImage.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
            data2 = stream.toByteArray();         
    }
    
    private File getDir() {
        File sdDir = Environment.getExternalStorageDirectory();
        return new File(sdDir, "greendev");
    }
    
	public void saveImgtoSDcard(){
    	File pictureFileDir = getDir();
    	    	
        if (!pictureFileDir.exists() && !pictureFileDir.mkdirs()) {

          Toast.makeText(getApplicationContext(), "Can't create directory to save image.",
              Toast.LENGTH_LONG).show();
          return;
        }
        
        String name = randomIdentifier();
        String ExternalStorageDirectoryPath = Environment.getExternalStorageDirectory()
                .getAbsolutePath();

        String interpretImg = ExternalStorageDirectoryPath + "/greendev/" + name + ".jpg";
        filename = interpretImg;
        File imageFile = new File(interpretImg);

        try {
	        if (data2!=null){
	          FileOutputStream fos = new FileOutputStream(imageFile);
	          fos.write(data2);
	          fos.close();
	        }

        } catch (Exception error) {
          
        }
    }
}