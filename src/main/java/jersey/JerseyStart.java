package jersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

public class JerseyStart {

    private static final String JERSEY_SERVLET_NAME = "jersey-container-servlet";
    private static JerseyStart instance;
    private Server server;

    private JerseyStart() {
    }

    public static JerseyStart getInstance(){
        if (instance == null){
            instance = new JerseyStart();
        }
        return instance;
    }

    public void start() throws Exception {

        if (server !=null && server.isStarted()){
            return;
        }

        String port = "8080";

        server = new Server(Integer.valueOf(port));
        ServletContextHandler context = new ServletContextHandler(server, "/");

        ServletHolder servlet = new ServletHolder(JERSEY_SERVLET_NAME,
                new ServletContainer(new JerseyConfiguration()));
        context.addServlet(servlet, "/*");

        server.start();
    }

    public void stop(){
        if (server !=null && server.isStarted()){
            server.destroy();
        }
    }

    public class JerseyConfiguration extends ResourceConfig {

        public JerseyConfiguration() {
            packages("jersey.resources");
            register(new CORSFilter());
        }
    }

    @Provider
    public class CORSFilter implements ContainerResponseFilter {

        @Override
        public void filter(ContainerRequestContext request,
                           ContainerResponseContext response) throws IOException {
            response.getHeaders().add("Access-Control-Allow-Origin", "*");
            response.getHeaders().add("Access-Control-Allow-Headers",
                    "origin, content-type, accept, authorization");
            response.getHeaders().add("Access-Control-Allow-Credentials", "true");
            response.getHeaders().add("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        }
    }
}
