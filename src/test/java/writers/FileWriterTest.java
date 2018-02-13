package writers;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterTest extends WriterTest{

    String filepath = "sample.txt";

    public String readFile() throws IOException {
        return Files.lines(Paths.get(filepath)).collect(joining(""));
    }

    @Override
    protected WriterInterface createWriter() throws IOException {
        return new FileWriter(filepath);
    }

    @Override
    protected String getContent() throws IOException {
        return Files.newBufferedReader(Paths.get(filepath)).readLine();
    }
}