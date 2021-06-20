package org.europa.together.chapter04;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.europa.together.EmbeddedGrizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@SuppressWarnings("unchecked")
@RunWith(JUnitPlatform.class)
public class RestEmbeddedServerTest {

    private static HttpServer server;
    private static WebTarget target;

    @BeforeAll
    static void setUp() {
        try {
            server = EmbeddedGrizzly.startServer();
            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);
            target = client.target(EmbeddedGrizzly.BASE_URI);

        } catch (Exception ex) {
            System.err.println(ex.getStackTrace());
        }
    }

    @AfterAll
    static void tearDown() {
        server.shutdown();
    }

    @Test
    void testFooRest() {
        String request = target
                .path("/sample").path("/chapter")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertEquals("Lorem ipsum", request);
        System.out.println("Output: " + request);
    }
}
