package com.aem.summit.core.models;
 
import javax.annotation.PostConstruct;
import javax.inject.Inject;
 
import com.aem.summit.core.HeroTextBean; 
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@Model(adaptables = Resource.class)
public class HeroSlingModel {
     
    private final Logger LOG = LoggerFactory.getLogger(getClass());
     
    //Get all dialog fields by using the inject annotation
    @Inject @Optional
    public String heading;
  
    @Inject @Optional
    public String description;
     
    @Inject @Optional
    public String path;
     
    @Inject @Optional
    public String startdate;
     
    @Inject @Optional
    public String show;
     
    @Inject @Optional
    public String size;
     
    /** The hero text bean. */
    private HeroTextBean heroTextBean = null;
     
    @PostConstruct
    protected void init() {
        LOG.info("In the  **** INIT *** method");
         
        heroTextBean = new HeroTextBean();
         
        //Set the Bean with all the dialgo values
        heroTextBean.setHeadingText(heading);
        heroTextBean.setDescription(description); 
        heroTextBean.setPath(path); 
        heroTextBean.setDate(startdate); 
         
  //If checkbox is unchecked
  if (show == null)
            heroTextBean.setShow("off");
        else
               heroTextBean.setShow(show);
        heroTextBean.setType(size);
      
    }
    public HeroTextBean getHeroTextBean() {
        return this.heroTextBean;
    }
}