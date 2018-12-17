package com.aem.summit.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.jcr.PropertyIterator;
import javax.servlet.Servlet;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.vault.util.Tree.Node;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/listOfpages",
        "sling.servlet.extensions=" + "txt"
})
public class RetrievePageNames extends SlingAllMethodsServlet {
	
	private static final long serialVersionUid = 1L;
	
		private static final Logger LOG=LoggerFactory.getLogger(RetrievePageNames.class);
		
		@Override
		protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
			doPost(request,response);
		}
		protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
			ResourceResolver resourceResolver = request.getResourceResolver();
			Resource rootRes = resourceResolver.getResource("/content/we-retail");
			Page rootPage = rootRes.adaptTo(Page.class);
			Iterator<Page> iterator=rootPage.listChildren(new PageFilter(),true);			
			JSONArray jsonArray=new JSONArray();
			try
			{
				while(iterator.hasNext()) {
					JSONObject jsonObj = new JSONObject();
					Page eachPage = iterator.next();
					jsonObj.put("pageName", eachPage.getName());
					jsonObj.put("pagePath", eachPage.getPath());
					
					
					//getting page properties
					//Node eachNode = eachPage.adaptTo(Node.class);
					//Node jcrNode = eachNode.getNode("jcr:content");
					//PropertyIterator pi= jcrNode.getProperties();
					
					jsonArray.put(jsonObj);
				}
				response.getWriter().write(jsonArray.toString());
			}catch(Exception e)
			{
				LOG.error("Exception in reading  username and password",e);
			}
		}
}
