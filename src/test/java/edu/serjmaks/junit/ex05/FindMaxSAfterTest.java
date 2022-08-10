package edu.serjmaks.junit.ex05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.serjmaks.junit.ex05.FindMaxSAfter;

public class FindMaxSAfterTest {

    @Test
    public void findMaxSFilename_shouldReturnTrue() {
        FindMaxSAfter findMaxS = new FindMaxSAfter();
        String actual = findMaxS.findMaxS();
        String expected = "files_for_comparing\\dssss.txt";
        assertEquals(expected, actual);
    }
}
