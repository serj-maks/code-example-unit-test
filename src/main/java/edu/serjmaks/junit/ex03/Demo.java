package edu.serjmaks.junit.ex03;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        PageDownloader pageDownloader = new PageDownloader(new ClientImpl());
        pageDownloader.download();
    }
}
