package writers;

import java.io.IOException;

public class StupidRemover implements WriterInterface{

    private  WriterInterface writer;
    StupidRemover(){};

    StupidRemover(WriterInterface writerInterface)
    {
        writer = writerInterface;
    }

    public String remove(String string) {
        return string.replaceAll("stupid", "s*****");
    }

    @Override
    public void write(String content) throws IOException {
        writer.write(remove(content));
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    @Override
    public String toString(){
        return writer.toString();
    }
}