package com.aem.summit.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.jcr.Node;
import javax.servlet.Servlet;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/logintest",
        "sling.servlet.extensions=" + "txt"
})
public class LoginTestServlet extends SlingAllMethodsServlet {
	
		private static final Logger LOG=LoggerFactory.getLogger(LoginTestServlet.class);
		private static final long serialVersionUid = 1L;
	
		@Override
		protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
			doPost(request,response);
		}
		protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
			ResourceResolver resourceResolver=request.getResourceResolver();
			Resource userRes=resourceResolver.getResource("/content/Lab2018/en");
			Iterator<Resource> iterator= userRes.listChildren();
			String username=request.getParameter("username");
			LOG.info("given user name:"+ username);
			String password=request.getParameter("password");
			LOG.info("given user name:"+ password);
			boolean flag=false;
			try {
				while(iterator.hasNext())
				{
						Resource eachRes=iterator.next();
						Node eachNode=eachRes.adaptTo(Node.class);
						if(eachNode.hasProperty("username") && eachNode.hasProperty("password"))
						{
							String userNameFromNode=eachNode.getProperty("username").getString();
							String passwordFromNode=eachNode.getProperty("password").getString();
							if(username.equalsIgnoreCase(userNameFromNode) && password.equalsIgnoreCase(passwordFromNode))
							{
								flag=true;
								break;
							}
						}
				}
				if(flag)
				{
					response.getWriter().write("success");
				}else
				{
					response.getWriter().write("failed");
				}
			}catch(Exception e)
			{
				LOG.error("Exception in reading username and password:",e);
			}
			
		}
}
