package writers;

import java.io.IOException;

public class UpperCaseConverter implements WriterInterface{
    private WriterInterface writer;

    public String convert(String string)
    {
        return string.toUpperCase();
    }

    UpperCaseConverter(WriterInterface writerInterface)
    {
        writer = writerInterface;
    }

    @Override
    public void write(String content) throws IOException {
        writer.write(convert(content));
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
