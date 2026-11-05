package com.example.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpServer;

public class App {

    private static final String API_KEY =
    "xQ7mP9vL2kR8nT4wY6cB1hJ5sD3fG0aZ";
    static String getHomeMessage(String version) {
        return "Updated after pipeline setup";
    }

    static String getHealthStatus() {
        return "OK";
    }

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "8080")
        );

        String version = System.getenv().getOrDefault(
                "APP_VERSION", "1.0.0"
        );

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", port), 0
        );

        server.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath();
            String response;
            int status = 200;

            if (path.equals("/")) {
                response = getHomeMessage(version);
            } else if (path.equals("/health")) {
                response = getHealthStatus();
            } else {
                response = "Not Found";
                status = 404;
            }

            byte[] body = response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                    "Content-Type", "text/plain; charset=UTF-8"
            );

            exchange.sendResponseHeaders(status, body.length);

            try (var output = exchange.getResponseBody()) {
                output.write(body);
            }
        });

        server.start();
        System.out.println("Application running on port " + port);
    }
}
