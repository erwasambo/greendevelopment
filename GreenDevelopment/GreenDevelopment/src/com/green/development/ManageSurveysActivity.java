package com.green.development;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.green.development.R;


public class ManageSurveysActivity extends SherlockActivity {
	private ResponseReceiver receiver;
	private static final String PROGRESBAR_VISIBLE = "progressbar_visible";
	private ProgressDialog dialog;
	ConnectionDetector cd;
	ResponsesArrayAdapter adapter;
	ListView lvResponses;
	AlertDialogManager alert = new AlertDialogManager();
	UserFunctions funcs = new UserFunctions();
	private DataBaseManager DatabaseHelper;
	private List<Response> responses = new ArrayList<Response>();
	private static String KEY_SUCCESS = "success";
	private static UploadHandler upHandler;
	ArrayList<Response> selectedResponses;

	int respos;
	int currentadppos;
	String id;
	String fullname, address, phone, image_resource, organization;
	String personresp, projarea, ethanol, biogas, purwater, imgFilePath;

	Response mainresponse;
	
	
	static class UploadHandler extends Handler {
		
		private WeakReference<ManageSurveysActivity> activityReference;
		
		public UploadHandler (ManageSurveysActivity activity){
			setActivityRefence(new WeakReference<ManageSurveysActivity>(activity));
			
		}
		
		public void handleMessage (Message message){
			switch(message.arg1){
			case SubmitionsIntentService.FINISHED_OK:
				
				ArrayList<Response> submittedResponses = (ArrayList<Response>) message.obj;
				
				//activityReference.get().responses.removeAll(submittedResponses);
				/*ResponsesArrayAdapter adapter = (ResponsesArrayAdapter) activityReference.get().lvResponses.getAdapter();
				adapter.remove(object)*/
				for (int i=0; i<submittedResponses.size(); i++){
					
					ResponsesArrayAdapter adapter = (ResponsesArrayAdapter) activityReference.get().adapter;
					adapter.remove((Response) submittedResponses.get(i));
					adapter.notifyDataSetChanged();
					activityReference.get().responses.remove((Response) submittedResponses.get(i));
					
					
					
				}
				
				/*ResponsesArrayAdapter adapter = (ResponsesArrayAdapter) activityReference.get().lvResponses.getAdapter();
				adapter.notifyDataSetChanged();*/
				
				activityReference.get().dialog.setTitle("Responses submited");
				activityReference.get().dialog.setMessage("Done");
				Thread Timer = new Thread(){
		        	public void run(){
		        		try{
		        			sleep(2000);	
		        		}
		        		
		        		catch (InterruptedException e){
		        			e.printStackTrace();
		        		}
		        		finally{
		        			
		        		}
		        	}
		        };
		        Timer.start();
				activityReference.get().dialog.dismiss();
				activityReference.get().showToast(
						activityReference.get().getResources()
								.getString(R.string.upload_success));
				
				if (activityReference.get().responses.isEmpty()){
					activityReference.get().setEmpty();

				}
				activityReference.get().goToHome();
				
				break;
			
			case SubmitionsIntentService.FINISHED_ERROR:
				//activityReference.get().dialog.dismiss();
				activityReference.get().showToast("Error occured during upload");
				break;
				
			case SubmitionsIntentService.IN_PROGRESS:
				activityReference.get().dialog.setTitle("Submiting Response(s)");
				activityReference.get().dialog.setMessage("Processing response "+message.obj+ " of "+ message.arg2);
				activityReference.get().dialog.setIndeterminate(true);

				activityReference.get().dialog.setCancelable(true);
				activityReference.get().dialog.show();
				
				
				break;
			
			case SubmitionsIntentService.IN_PROGRESSFINISH:
				/*activityReference.get().dialog.setTitle("Submited Response(s)");
				activityReference.get().dialog.setMessage("Response "+message.arg2+ " recorded in the cloud");
				activityReference.get().dialog.setIndeterminate(true);
				activityReference.get().dialog.setCancelable(true);
				activityReference.get().showToast("Response "+" Recorded in the cloud");
				ResponsesArrayAdapter adapter = (ResponsesArrayAdapter) activityReference.get().lvResponses.getAdapter();
				adapter.remove((Response) message.obj);
				adapter.notifyDataSetChanged();
				
				if (activityReference.get().selectedResponses.isEmpty()){
					activityReference.get().setEmpty();

				}*/
				break;	
			}
		}
		
		public WeakReference<ManageSurveysActivity> getActivityReference(){
			return activityReference;
			
		}
		
		public void setActivityRefence(WeakReference<ManageSurveysActivity> activityReference){
			this.activityReference = activityReference;
		}
		
		
	};
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
		/*outState.putInt(PROGRESBAR_VISIBLE, progressBar.getVisibility());
		outState.putSerializable(IMAGES_ITEMS,
				(Serializable) adapter.getItems());*/
	}
	
	
	
	@SuppressLint("NewApi")
	public void beforeSync() {
		cd = new ConnectionDetector(getApplicationContext());
		if (!cd.isConnectingToInternet()) {
			alert.showAlertDialog(ManageSurveysActivity.this,
					"Internet Connection Error",
					"Please connect to a working Internet connection", false);
			return;
		}
		
		
		int currentapiversion = android.os.Build.VERSION.SDK_INT;

		AsyncTask<String, String, String> task = new MyNewTask();

		if (currentapiversion >=
			android.os.Build.VERSION_CODES.HONEYCOMB) {
				task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
		} else {
			task.execute();
		}

	}

	private static final String PREF_NAME = "SwitchButtonDemo";
	private static final String PREF_THEME = "isDark";

	public void goToHome(){
		startActivity(new Intent(getApplicationContext(), HomeActivity.class));
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String clickedmenu = String.valueOf(item.getTitle());
		respos = responses.size();
		int noofselectedresp = 0;

		for (int i = 0; i < respos; i++) {

			Response resp = responses.get(i);
			if (resp.isSelected()) {
				noofselectedresp++;
			}
		}

		
			if (clickedmenu == "Submit") {				
				if (noofselectedresp == 0) {
					Toast.makeText(getApplicationContext(),
							"Please select at least one record to submit",
							Toast.LENGTH_SHORT).show();
				}else{
					
					selectedResponses = new ArrayList<Response>();
					
					for (int i = 0; i < responses.size(); i++) {
						Response resp = responses.get(i);
						if (resp.isSelected()) {
							selectedResponses.add(resp);							
						}
					}
					ResponseWrapper wrapper = new ResponseWrapper(selectedResponses);
					
					Intent serversubmIntent = new Intent(this, SubmitionsIntentService.class);
					Messenger messenger = new Messenger(upHandler);
					serversubmIntent.putExtra("MESSENGER", messenger);
					serversubmIntent.putExtra("CloudResponse", wrapper);
					//serversubmIntent.putStringArrayListExtra("CloudResponse", stringrespo);
					startService(serversubmIntent);
					
					
					
					
				}
				
				
			}else if (clickedmenu == "Edit") {
				if (noofselectedresp == 1) {
					for (int i = 0; i < responses.size(); i++) {
						Response resp = responses.get(i);
						if (resp.isSelected()) {
							Log.e("Value of responses to be edited", String.valueOf(responses));
							
							//Edit Response
							int editrespposition = 	responses.indexOf(resp)+1;
							String finaleditrespposition = String.valueOf(editrespposition);
							Intent editactivity = new Intent(getApplicationContext(), EditSurveyActivity.class);
							editactivity.putExtra("SurveryID", finaleditrespposition);
							
							Log.e("The index to be passed is:-", String.valueOf(editrespposition));
							finish();
							startActivity(editactivity);
							
						}
					}
				}else if(noofselectedresp > 1){
					Toast.makeText(getApplicationContext(),
							"Kindly edit one record at a time",
							Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(getApplicationContext(),
							"Please select at least one record to edit",
							Toast.LENGTH_SHORT).show();
				}
				
			} else {
				
				if (noofselectedresp == 0) {
					Toast.makeText(getApplicationContext(),
							"Please select at least one record to delete",
							Toast.LENGTH_SHORT).show();
				}else{
						// Preparing views
						LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						View layout = inflater.inflate(R.layout.dialogue,
								(ViewGroup) findViewById(R.id.dialog1));
						
						// Building dialog
						AlertDialog.Builder builder = new AlertDialog.Builder(this);
						builder.setView(layout);
						builder.setTitle("Delete Response(s)?");
						builder.setIcon(R.drawable.delete);
						
						builder.setMessage("Are you sure you want to delete the selected Response(s)?");
						builder.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
		
										for (int i = 0; i < responses.size(); i++) {
											Response resp = responses.get(i);
											if (resp.isSelected()) {
												String myimgFilePath = resp.resourceFilePathId;
												DatabaseHelper.delete("pendingsurveys",
														"Id =" + resp.id);
												File imgFile = new File(myimgFilePath);
												imgFile.delete();
												responses.remove(resp);
		
												ResponsesArrayAdapter adapter = new ResponsesArrayAdapter(
														getApplicationContext(),
														R.layout.managelistview_item,
														responses);
		
												ListView lv = (ListView) findViewById(R.id.listView1);
												lv.setAdapter(adapter);
												lv.setClickable(true);
												lv.setTextFilterEnabled(true);
												lv.setFastScrollEnabled(true);
		
												if (responses.isEmpty()) {
													setContentView(R.layout.emptysurveys);
												}
		
											}
										}
		
										dialog.dismiss();
									}
								});
						builder.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();
									}
								});
						AlertDialog dialog = builder.create();
		
						dialog.show();
		
					}
			}
		return true;
	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		if (upHandler == null){
			upHandler = new UploadHandler(this);
			
		}else{
			upHandler.setActivityRefence(new WeakReference<ManageSurveysActivity>(this));
		}
		
		IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
        
        lvResponses = (ListView) findViewById(R.id.listView1);
        dialog = new ProgressDialog(ManageSurveysActivity.this);
        //adapter = (ResponsesArrayAdapter)lvResponses.getAdapter();
        
		
		
		SharedPreferences preferences = this.getSharedPreferences(PREF_NAME, 0);
		boolean isDark = preferences.getBoolean(PREF_THEME, false);

		if (isDark)
			this.setTheme(R.style.AppThemeDark);
		else
			this.setTheme(R.style.AppThemeLight);
		super.onCreate(savedInstanceState);

		DatabaseHelper = DataBaseManager.instance();

		updateRespondentsList();
		if (responses.isEmpty()) {
			setContentView(R.layout.emptysurveys);
		} else {
			setContentView(R.layout.managesurveys);
			adapter = new ResponsesArrayAdapter(
					getApplicationContext(), R.layout.managelistview_item,
					responses);
			Log.v("Value of responses", String.valueOf(responses));
			ListView lv = (ListView) findViewById(R.id.listView1);
			lv.setAdapter(new ResponsesArrayAdapter(
					getApplicationContext(), R.layout.managelistview_item,
					responses));
			lv.setClickable(true);
			lv.setTextFilterEnabled(true);
			lv.setFastScrollEnabled(true);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		boolean isLight = SampleList.THEME == R.style.Theme_Sherlock_Light;
		
		menu.add("Edit")
		.setIcon(isLight ? R.drawable.edit : R.drawable.edit)
		.setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		
		menu.add("Submit")
				.setIcon(isLight ? R.drawable.cloud : R.drawable.cloud)
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_IF_ROOM
								| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		menu.add("Delete")
				.setIcon(isLight ? R.drawable.delete : R.drawable.delete)
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_IF_ROOM
								| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
	}

	@Override
	protected void onResume() {

		super.onResume();
	}

	private void updateRespondentsList() {
		Cursor cursor = DatabaseHelper.select("SELECT * FROM pendingsurveys");

		if (cursor == null) {
			cursor.close();
		}

		while (cursor.moveToNext()) {
			String respid = cursor.getString(0);
			String respname = cursor.getString(1);
			String respaddress = cursor.getString(2);
			String respphone = cursor.getString(3);
			String respimppath = cursor.getString(4);
			String resporganization = cursor.getString(5);
			String resppersonresp = cursor.getString(6);
			String respprojarea = cursor.getString(7);
			String respethanol = cursor.getString(8);
			String respbiogas = cursor.getString(9);
			String resppurwater = cursor.getString(10);

			// Construct Response object
			Response resp = new Response(respid, respname, respaddress,
					respphone, respimppath, resporganization, resppersonresp,
					respprojarea, respethanol, respbiogas, resppurwater, false);
			responses.add(resp);
		}

		cursor.close();
	}

	public void sendDataToServer(int position) {
		currentadppos = position;
		id = responses.get(position).id;
		fullname = responses.get(position).name;
		address = responses.get(position).address;
		phone = responses.get(position).phone;
		mainresponse = responses.get(position);
		// get the field image and encode it in readiness for sending
		imgFilePath = responses.get(position).resourceFilePathId;
		File imgFile = new File(imgFilePath);
		if (imgFile.exists()) {
			Bitmap myBitmap = BitmapFactory.decodeFile(imgFile
					.getAbsolutePath());
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			myBitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
			byte[] byte_arr = stream.toByteArray();
			image_resource = Base64.encodeBytes(byte_arr);
		}

		organization = responses.get(position).organization;
		personresp = responses.get(position).person;
		projarea = responses.get(position).projarea;
		ethanol = responses.get(position).ethanol;
		biogas = responses.get(position).biogas;
		purwater =  responses.get(position).purwater;

		beforeSync();

	}

	private class MyNewTask extends AsyncTask<String, String, String> {
		String indicator = null;

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(ManageSurveysActivity.this);
			dialog.setIndeterminate(true);
			dialog.setTitle("Submiting Response(s)");
			dialog.setMessage("Processing...");
			dialog.setCancelable(true);
			//dialog.show();
		}

		@Override
		protected String doInBackground(String... params) {

			JSONObject json = funcs.addResponse(fullname, address, phone,
					image_resource, organization, personresp, projarea,
					ethanol, biogas, purwater);

			if (json != null) {
				try {
					indicator = json.getString(KEY_SUCCESS);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				dialog.dismiss();
			}
			return indicator;
		}

		@Override
		protected void onPostExecute(String flag) {
			super.onPostExecute(flag);
			dialog.dismiss();

			try {
				int indicator = Integer.parseInt(flag);
				
				if (indicator == 1) {
					
					DatabaseHelper.delete("pendingsurveys", "Id =" + id);
					File imgFile = new File(imgFilePath);
					imgFile.delete();

					Toast.makeText(getApplicationContext(),
							"Response Recorded in the cloud", Toast.LENGTH_LONG)
							.show();
					
					ListView lv = (ListView) findViewById(R.id.listView1);

					ResponsesArrayAdapter adapter = (ResponsesArrayAdapter)lv.getAdapter();
					adapter.remove(mainresponse);
					adapter.notifyDataSetChanged();
					
					
					if (responses.isEmpty()) {
						setContentView(R.layout.emptysurveys);
					}

					
				} else {
					Toast.makeText(getApplicationContext(),
							"Cannot record response now. Please try later", Toast.LENGTH_LONG).show();
				}
				
			} catch (Exception e) {
				serverError(e);
				Log.e("Server Error", String.valueOf(e));
			}
		}
	}

	public void serverError(Exception e) {
		alert.showAlertDialog(
				ManageSurveysActivity.this,
				"Network Error",
				"Cannot establish a connection to the server, please check the network"+String.valueOf(e),
				false);
		return;
	}
	
	private void showToast(String s) {

		Toast.makeText(ManageSurveysActivity.this, s, Toast.LENGTH_LONG).show();
	}
	
	private void setEmpty(){
		setContentView(R.layout.emptysurveys);
	}

}
