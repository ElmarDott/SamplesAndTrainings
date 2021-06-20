package org.europa.together;

import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Start the Grizzly HTTP Server.
 */
public class EmbeddedGrizzly {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8888/";
    public static final String BASE_PACKAGE = "org.europa.together";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     *
     * @param rc as ResourceConfig
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {

        HttpServer server = null;
        try {
            // create a resource config that scans for JAX-RS resources and providers
            // in BASE_PACKAGE
            final ResourceConfig rc = new ResourceConfig().packages(BASE_PACKAGE);

            // create and start a new instance of grizzly http server
            // exposing the Jersey application at BASE_URI
            server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
            server.start();
            System.in.read();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return server;
    }

}
