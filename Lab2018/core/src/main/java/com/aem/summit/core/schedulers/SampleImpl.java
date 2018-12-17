package com.aem.summit.core.schedulers;

import org.osgi.service.component.annotations.Component;

@Component(name="Test Service", service=SimpleInterface.class,immediate=true)
public class SampleImpl implements SimpleInterface{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "hello";
	}

}
