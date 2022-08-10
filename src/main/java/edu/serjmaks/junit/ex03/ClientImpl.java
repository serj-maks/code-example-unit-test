package edu.serjmaks.junit.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ClientImpl implements Client {

    @Override
    public InputStream getPage(String link) throws IOException {
        URI uri = URI.create(link);
        return uri.toURL().openStream();
    }
}
