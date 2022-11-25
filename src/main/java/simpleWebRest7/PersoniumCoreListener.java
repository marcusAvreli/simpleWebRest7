package simpleWebRest7;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PersoniumCoreListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(PersoniumCoreListener.class);
    public void contextInitialized(ServletContextEvent sce) {
        // Start Application.
    	logger.info("contextInitialized_start");
    
        // Start EventBus.
       // EventBus.start();

        // Start WebSocketService.
      //  WebSocketService.start();
    	
    	try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/testdb");
			DataSourceProvider.getInstance().initDataSource(ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	logger.info("contextInitialized_finish");
    }

    
    public void contextDestroyed(ServletContextEvent sce) {
        // Stop WebSocket service.
        //WebSocketService.stop();
    	logger.info("contextDestroyed_start");
        // Stop EventBus.
        //EventBus.stop();
    	DataSource ds=DataSourceProvider.getInstance().getDataSoruce();
    	try {
			ds.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Stop Application.
      //  PersoniumCoreApplication.stop();
    	logger.info("contextDestroyed_finish");
    }
}