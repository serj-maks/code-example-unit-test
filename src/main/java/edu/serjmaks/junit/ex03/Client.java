package edu.serjmaks.junit.ex03;

import java.io.IOException;
import java.io.InputStream;

public interface Client {
    InputStream getPage(String link) throws IOException;
}
