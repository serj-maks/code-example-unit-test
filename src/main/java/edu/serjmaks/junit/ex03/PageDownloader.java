package edu.serjmaks.junit.ex03;

import static edu.serjmaks.junit.ex03.HtmlAction.copyHtmlPageToFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;;

public class PageDownloader {

    private final Client client;

    public PageDownloader(Client client) {
        this.client = client;
    }

    public void download() throws IOException {
        try (InputStream inputStream =  client.getPage("http://example.com")) {
            File file = new File("example.html");
            copyHtmlPageToFile(inputStream, file);
        }
    }
}
