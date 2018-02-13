package writers;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter implements WriterInterface {

    java.io.FileWriter fileWriter;
    private boolean closed;
    Path path;

    public FileWriter(String file) throws IOException {
        fileWriter = new java.io.FileWriter(file);
        path = Paths.get(file);
    }

    @Override
    public void write(String string) throws IOException {
        if (closed == false){
            fileWriter.write(string);
            fileWriter.flush();
        }
    }

    public void close()
    {
        closed = true;
    }

}
