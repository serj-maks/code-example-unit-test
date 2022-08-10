package edu.serjmaks.junit.ex03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HtmlAction {
    public static final int DEF_BUFFER_SIZE = 8192;

    public static void copyHtmlPageToFile(InputStream inputStream, File file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEF_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, read);
            }
        }
    }
}
