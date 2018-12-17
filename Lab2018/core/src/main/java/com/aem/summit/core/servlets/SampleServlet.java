package com.aem.summit.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.summit.core.schedulers.SimpleInterface;

@Component(name="practice servlet",service=Servlet.class,
property={
        
        "sling.servlet.resourceTypes="+ "com.poc.osgiannotation/components/structure/page",
        "sling.servlet.paths="+ "/bin/servlet",
        "sling.servlet.extensions=" + "txt"
})
public class SampleServlet extends SlingAllMethodsServlet{
	
	
	@Reference
	SimpleInterface simpleInterface;

	@Override
	   protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws IOException
	   {
	       response.getWriter().write(simpleInterface.getMessage());
	   }
}
