package br.edu.unipam.apptodo;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
@ApplicationPath("api/v1")  //domínio/contextPath/api/v1/....  localhost:8080/
public class JAXRSConfiguration extends Application {

} 