package com.aem.summit.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/parsing",
        "sling.servlet.extensions=" + "txt"
})
public class FeedingProcess extends SlingAllMethodsServlet
{
	
	/*private static final Logger LOG=LoggerFactory.getLogger(FeedingProcess.class);
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
		doPost(request,response);
		LOG.info("In doget method");
	}
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
		
		FileReader f = new FileReader("D:\\projects\\Building\\Lab2018\\core\\category.json");
		BufferedReader br = new BufferedReader(f);

		JSONArray jsonObjectArray = new JSONArray();
		String currentJSONString  = "";

		// read the file, since I ask for newline separation, it's easier for BufferedReader
		// to separate each String
		while( (currentJSONString = br.readLine()) != null ) {
		    // create new JSONObject
			JSONObject jsonObj = new JSONObject(currentJSONString);
			

		    
		    jsonObjectArray.put(jsonObj);
		}

		for (int i = 0; i < jsonObjectArray.length(); i++) {
		    JSONObject jsonObject = jsonObjectArray.get(i);

		    
		    if(jsonObject.has("Produce")) {
		        System.out.println(jsonObject.getInt("dept_id"));
		        System.out.println(jsonObject.getString("dept_name"));               
		        System.out.println(jsonObject.getString("dept_title") + "\n");    
		    }
		}	
	}
	
*/}
