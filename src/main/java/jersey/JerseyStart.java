package jersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

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

    public void start(int port) throws Exception {

        if (server !=null && server.isStarted()){
            return;
        }

        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(JERSEY_SERVLET_NAME, "/*");

        server.start();
    }

    public void stop(){
        if (server !=null && server.isStarted()){
            server.destroy();
        }
    }

}
