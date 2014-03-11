package com.green.development;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class SubmitionsIntentService extends IntentService{

	public static final String PARAM_IN_MSG = "CloudResponse";
	public static final String PARAM_OUT_MSG = "omsg";
	private DataBaseManager DatabaseHelper;
	String imgFilePath = null;
	
	private static String KEY_SUCCESS = "success";
	
	public static final int IN_PROGRESS = 1;
	public static final int FINISHED_OK = 2;
	public static final int IN_PROGRESSFINISH = 3;
	public static final int FINISHED_ERROR = 4;
	
	int noOfSelectedResp = 0;
	 
	UserFunctions funcs = new UserFunctions();
	
	public SubmitionsIntentService() {
		super("SubmitionsIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		DatabaseHelper = DataBaseManager.instance();
		String indicator = null;
		
		Bundle extras = intent.getExtras();
		Messenger messenger = (Messenger) extras.get("MESSENGER");
		
		ResponseWrapper wrap = (ResponseWrapper) intent.getSerializableExtra(PARAM_IN_MSG);
		
		ArrayList<Response> selectedResponse = wrap.getResponses();
		noOfSelectedResp = selectedResponse.size();
		
		for (int i=0; i<noOfSelectedResp; i++){
			Response currentRep = selectedResponse.get(i);
			String id = currentRep.id;
			String fullname = currentRep.name;
			String address = currentRep.address;
			String phone = currentRep.phone;
			String image_resource = currentRep.resourceFilePathId;
			String organization = currentRep.organization;
			String personresp = currentRep.person;
			String projarea = currentRep.projarea;
			String ethanol = currentRep.ethanol;
			String biogas = currentRep.biogas;
			String purwater = currentRep.purwater;
			
			String mImgFilePath = image_resource;
			String mImageResource = null;
			File imgFile = new File(mImgFilePath);
			if (imgFile.exists()) {
				Bitmap myBitmap = BitmapFactory.decodeFile(imgFile
						.getAbsolutePath());
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				myBitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
				byte[] byte_arr = stream.toByteArray();
				mImageResource = Base64.encodeBytes(byte_arr);
			}
			
			try {
				Message msg = Message.obtain();
				msg.arg1 = IN_PROGRESS;
				msg.arg2 = noOfSelectedResp;
				msg.obj = i+1;
				
				messenger.send(msg);
			} catch (RemoteException e1) {
				e1.printStackTrace();
				
			}
			
			JSONObject json = funcs.addResponse(fullname, address, phone,
					mImageResource, organization, personresp, projarea,
					ethanol, biogas, purwater);
			
			if (json != null) {
				try {
					indicator = null;
					indicator = json.getString(KEY_SUCCESS);
										
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				//dialog.dismiss();
			}
			
			try {
				if ( Integer.parseInt(indicator) == 1) {
					
					DatabaseHelper.delete("pendingsurveys", "Id =" + id);
					File mImgFile = new File(imgFilePath);
					mImgFile.delete();
					Log.v("Response", "The response has been recorded in the cloud");
					

					
					/*Message msg = Message.obtain();
					msg.arg1 = IN_PROGRESSFINISH;
					msg.arg2 = i+1;
					msg.obj = currentRep;
					try {
						messenger.send(msg);
					} catch (android.os.RemoteException e1) {
						Log.w(getClass().getName(), "Exception sending message", e1);
					}*/
					

					
				} else {
					Message msg = Message.obtain();
					msg.arg1 = FINISHED_ERROR;
					msg.arg2 = i+1;
					msg.obj = "Cannot record response now. Please try later";
					try {
						messenger.send(msg);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Log.v("Response","Cannot record response now. Please try later");
				}
				
			} catch (Exception e) {
				
				/*Message msg = Message.obtain();
				msg.arg1 = FINISHED_ERROR;
				msg.obj = "Server Error! Please check your internet Connection";
				try {
					messenger.send(msg);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
*/
				//serverError(e);
				Log.e("Server Error", String.valueOf(e));
			}
			
			
			
		}
		
		Message msg = Message.obtain();
		msg.arg1 = FINISHED_OK;
		msg.obj = selectedResponse;
		try {
			messenger.send(msg);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		/*Intent broadcastIntent = new Intent();
		broadcastIntent.setAction(ResponseReceiver.ACTION_RESP);
		broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
		broadcastIntent.putExtra(PARAM_OUT_MSG, indicator);
		sendBroadcast(broadcastIntent);*/

	}


		
		
		
	

}
