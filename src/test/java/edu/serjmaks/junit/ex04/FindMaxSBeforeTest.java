package edu.serjmaks.junit.ex04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.serjmaks.junit.ex04.FindMaxSBefore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FindMaxSBeforeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(out);
    }

    @Test
    // integration test
    // read output from console
    public void execute_shouldReturnTrue() throws IOException {
        FindMaxSBefore findMaxS = new FindMaxSBefore();
        findMaxS.findMaxS();
        String expected = "files_for_comparing\\dssss.txt\r\n";
        String actual = outContent.toString();
        assertEquals(expected, actual);
    }
}
