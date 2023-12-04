package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        String[] args = {""};
        Main.main(args);
        assertEquals(Main.viewManagerModel.getActiveView(), "home page");
    }
}