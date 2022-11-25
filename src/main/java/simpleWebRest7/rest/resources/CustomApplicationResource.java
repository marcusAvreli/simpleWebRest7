package simpleWebRest7.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import simpleWebRest7.PersoniumCoreListener;
import simpleWebRest7.data.model.CustomApplication;
import simpleWebRest7.service.CustomApplicationService;
import simpleWebRest7.system.exceptions.application.ApplicationDoesNotExistException;



@Path("customApp")  
public class CustomApplicationResource {
	//  private TStreamService streamService;
	private static final Logger logger = LoggerFactory.getLogger(CustomApplicationResource.class);
	private CustomApplicationService customApplicationService;
	  /**
     * @param streamService
     */
    @Inject
    public CustomApplicationResource(CustomApplicationService customApplicationService) {
        this.customApplicationService = customApplicationService;
    }

	 @GET
	    @Path("{streamUid}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CustomApplication getStream(@PathParam(value = "streamUid") int streamUid) {  
		 logger.info("getStream started");
		 if(null == customApplicationService) {
			 logger.info("service is null");
		 }
			CustomApplication tStream = customApplicationService.findById(streamUid).orElseThrow(ApplicationDoesNotExistException.newMenuCategoryCreateException2());
		    return tStream;
	       
	    }
}
