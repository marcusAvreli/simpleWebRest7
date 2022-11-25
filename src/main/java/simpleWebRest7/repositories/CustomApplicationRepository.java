package simpleWebRest7.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleWebRest7.DataSourceProvider;
import simpleWebRest7.data.model.CustomApplication;


public class CustomApplicationRepository {
	private static final Logger logger = LoggerFactory.getLogger(CustomApplicationRepository.class);
    Connection conn;
    public CustomApplicationRepository() {
    	try {
			conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @SuppressWarnings("unchecked")
    public List<CustomApplication> findAll() {
    
    	String sql = "select * from test_custom_application";
    	List<CustomApplication> customApplications = null;
    	try {
    		
    		
        	Statement statement = conn.createStatement();
			conn.setAutoCommit(false);		
			ResultSet result2 = statement.executeQuery(sql);
			
			while(result2.next()) {
				if(null == customApplications) {
					customApplications = new ArrayList<CustomApplication>();
				}
			    String name = ((ResultSet) result2).getString("name");
			    String displayName  = result2.getString("display_Name");
			    String description = result2.getString("description");
			    									
			    int id = result2.getInt("id");
			    CustomApplication customApplication = new CustomApplication(id,name,displayName,description);
			    
			    customApplications.add(customApplication);
			   
			    logger.info("iteratre over result set");
			}
			 result2.close();
				statement.close();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
        return customApplications;
    }
    public Optional<CustomApplication> findById(int inId) {
    	String sql = "select * from test_custom_application where id="+inId;
    	List<CustomApplication> customApplications = null;
    	
    		
    		
try {
    		
    		
        	Statement statement = conn.createStatement();
			conn.setAutoCommit(false);		
			ResultSet result2 = statement.executeQuery(sql);
			
			while(result2.next()) {
				if(null == customApplications) {
					customApplications = new ArrayList<CustomApplication>();
				}
			    String name = ((ResultSet) result2).getString("name");
			    String displayName  = result2.getString("display_Name");
			    String description = result2.getString("description");
			    									
			    int id = result2.getInt("id");
			    CustomApplication customApplication = new CustomApplication(id,name,displayName,description);
			    
			    customApplications.add(customApplication);
			   
			    logger.info("iteratre over result set");
			}
			 result2.close();
				statement.close();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CustomApplication customApplication = null;
		if(null != customApplications) {
			customApplication = customApplications.get(0);
		}
		
        return  customApplication != null ? Optional.of(customApplication) : Optional.empty();
    }

}