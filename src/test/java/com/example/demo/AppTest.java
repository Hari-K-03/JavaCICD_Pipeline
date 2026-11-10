package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void homeMessageReturnsUpdatedMessage() {
        assertEquals(
                "Incorrect Application version deployed!",
                App.getHomeMessage("1.0.0")
        );
    }

    @Test
    void healthStatusIsOk() {
        assertEquals("OK", App.getHealthStatus());
    }
}
