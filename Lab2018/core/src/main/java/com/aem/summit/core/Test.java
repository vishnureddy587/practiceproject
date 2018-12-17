package com.aem.summit.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.sling.commons.json.JSONObject;

public class Test {
	
	public static void main(String args[])
	{
	
	/*FileReader f = new FileReader("/Projects/StackOverflow/src/so7655570/twitter.json");
	BufferedReader br = new BufferedReader(f);

	ArrayList jsonObjectArray = new ArrayList();
	String currentJSONString  = "";

	// read the file, since I ask for newline separation, it's easier for BufferedReader
	// to separate each String
	while( (currentJSONString = br.readLine()) != null ) {
	    // create new JSONObject
	    JSONObject currentObject = new JSONObject(currentJSONString);

	    // there are more than one way to do this, right now  what I am doing is adding
	    // each JSONObject to an ArrayList
	    jsonObjectArray.add(currentObject);
	}

	for (int i = 0; i < jsonObjectArray.size(); i++) {
	    JSONObject jsonObject = jsonObjectArray.get(i);

	    // check if it has valid ID as delete won't have one
	    // sample of JSON for delete : 
	    // {"delete":{"status":{"user_id_str":"50269460","id_str":"121202089660661760","id":121202089660661760,"user_id":50269460}}}

	    if(jsonObject.has("id")) {
	        System.out.println(jsonObject.getInt("id"));
	        System.out.println(jsonObject.getString("text"));               
	        System.out.println(jsonObject.getString("created_at") + "\n");    
	    }
	}
*/	}
}
