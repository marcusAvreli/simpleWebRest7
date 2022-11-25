package simpleWebRest7.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleWebRest7.repositories.CustomApplicationRepository;
import simpleWebRest7.rest.filter.CORSFilter;
import simpleWebRest7.rest.resources.CustomApplicationResource;
import simpleWebRest7.rest.resources.JerseyResource;
import simpleWebRest7.service.CustomApplicationService;
import simpleWebRest7.service.impl.CustomApplicationServiceImpl;





//The Java class will be hosted at the URI path "/helloworld"
//https://github.com/632691987/coffee
public class CoreApplication extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(CoreApplication.class);
    /** Maximum timeout seconds. */
    private static final long TIMEOUT_SECONDS = 50;

    /**
     * Start Application.
     */
    public CoreApplication() {
    	   registerResources();

           // Now you can expect validation errors to be sent to the
           // client.
       //    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
   
    public void registerResources() {
        register(CORSFilter.class);
        register(JerseyResource.class);
    
        register(CustomApplicationResource.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(CustomApplicationServiceImpl.class).to(CustomApplicationService.class);
                bind(CustomApplicationRepository.class).to(CustomApplicationRepository.class);
            }
        });
    }
 

}