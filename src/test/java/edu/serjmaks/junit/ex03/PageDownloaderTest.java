package edu.serjmaks.junit.ex03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PageDownloaderTest {

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("example.html"));
    }

    @Test
    void download() throws IOException {
        PageDownloader pd = new PageDownloader(new ClientMock());
        pd.download();
        byte[] result = Files.readAllBytes(Path.of("example.html"));
        String actual = new String(result);
        String expected = "str";
        assertEquals(expected, actual);
    }
}
