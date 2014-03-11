package com.green.development;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Response> responses;
	
	public ResponseWrapper(ArrayList<Response> response){
		this.responses = response;
		
	}
	
	public ArrayList<Response> getResponses(){
		return responses;
	}
	
}
