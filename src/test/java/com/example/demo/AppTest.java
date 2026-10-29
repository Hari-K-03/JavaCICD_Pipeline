package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void homeMessageIncludesVersion() {
        assertEquals(
                "Hello from the Java CI/CD Demo! Version: 1.0.0",
                App.getHomeMessage("1.0.0")
        );
    }

    @Test
    void healthStatusIsOk() {
        assertEquals("OK", App.getHealthStatus());
    }

    @Test
    void updatedVersionAppearsInMessage() {
        assertEquals(
                "Hello from the Java CI/CD Demo! Version: 2.0.0",
                App.getHomeMessage("2.0.0")
        );
    }
}
