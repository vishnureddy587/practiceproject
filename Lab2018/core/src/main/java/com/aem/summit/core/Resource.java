package com.aem.summit.core;

import javax.annotation.PostConstruct;
import javax.jcr.Node;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;


@Model(adaptables=Resource.class)
public class Resource {
	
	@Self
	Resource currentResource;
	
	@PostConstruct
	protected void init()
	{
		//Node currentNode = currentResource.adaptTo(Node.class);
	}
}
