package com.aem.summit.core.models;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables=Resource.class)
public class SlingModel {
	
	private static  final Logger LOG= LoggerFactory.getLogger(SlingModel.class);
	
	@Inject
	@Optional
	private String heading;
	
	@Inject
	@Optional
	private String description;
	
	private String createdBy;
	
	private String childResouce;

	public String getChildResouce() {
		return childResouce;
	}


	public String getCreatedBy() {
		return createdBy;
	}

	
	public String getHeading() {
		return heading;
	}


	public String getDescription() {
		return description;
	}
	
	@Self
	Resource currentResource;
	
	@SlingObject
	ResourceResolver resourceResolver;
	
	@PostConstruct
	protected void init()
	{
		try
		{
			LOG.info("This is vishnu reddy" + currentResource.getPath());
			
			heading = heading + "vishnu reddy";
			Node currentNode = currentResource.adaptTo(Node.class);
			createdBy = currentNode.getProperty("jcr:created").getString();
			
			Resource resource = resourceResolver.getResource("/content/Lab2018");
			Iterator<Resource> iterator=resource.listChildren();
			
			while(iterator.hasNext())
			{
				Resource childRes=iterator.next();
				childResouce = childResouce + childRes;
			}
		}catch(Exception e)
		{
			LOG.error("Exception in reding properties vishnu reddy");
		}
	}
}
