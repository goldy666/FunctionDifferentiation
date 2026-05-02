package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    public void write(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}