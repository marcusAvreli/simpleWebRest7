package simpleWebRest7.rest.resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import simpleWebRest7.data.model.CustomApplication;
import simpleWebRest7.system.exceptions.application.ApplicationDoesNotExistException;
import simpleWebRest7.system.exceptions.file.MissingFileException;


@Path("/download")
public class JerseyResource
{
  @GET
  @Path("/file/{fileName}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response downloadPdfFile(final @PathParam("fileName") String fileName)
  {
    final String fullFilePath = "C:/temp/" + fileName;
     
    File file = new File(fullFilePath);
     
    if(file.exists() == false){
      throw new MissingFileException();
    }
     
    StreamingOutput fileStream =  new StreamingOutput()
    {
      
      public void write(java.io.OutputStream output) throws IOException
      {
        try
        {
          java.nio.file.Path path = Paths.get(fullFilePath);
          byte[] data = Files.readAllBytes(path);
          output.write(data);
          output.flush();
        } 
        catch (IOException e) 
        {
          throw new IOException("Error while reading file :: '"+fileName+"' !!");
        }
      }
    };
    return Response
              .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
              .header("content-disposition","attachment; filename = '"+fileName)
              .build();
  }
  @GET
  @Path("{streamUid}")
  @Produces(MediaType.APPLICATION_JSON)
  public CustomApplication getStream(@PathParam(value = "streamUid") int streamUid){
	  if(true) {
		  throw new ApplicationDoesNotExistException();
	  }
	    return null;
     
  }
}
