package com.green.development;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
 
public class UserFunctions {
	
    private JSONParser jsonParser;
    private static String universalURL = "http://greendevelopment.no/addresponse";
     
    private static String add_response = "add_response";
 
    
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
    
    //Report record response
    public JSONObject addResponse(String fullname, String address, String phone, String image_resource, String organization,
	String personresp,String projarea,String ethanol,String biogas,String purwater){
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("tag", add_response));
    	params.add(new BasicNameValuePair("fullname", fullname));
    	params.add(new BasicNameValuePair("address", address));
    	params.add(new BasicNameValuePair("phone", phone));
    	params.add(new BasicNameValuePair("image", image_resource));
		params.add(new BasicNameValuePair("organization", organization));
    	params.add(new BasicNameValuePair("personresp", personresp));
    	params.add(new BasicNameValuePair("projarea", projarea));
    	params.add(new BasicNameValuePair("ethanol", ethanol));
    	params.add(new BasicNameValuePair("biogas", biogas));
    	params.add(new BasicNameValuePair("purwater", purwater));
    	JSONObject json = jsonParser.getJSONFromUrl(universalURL, params);
    	if(json != null){
        	return json;
        }
        else {
        	return null;
        }
    }  
}