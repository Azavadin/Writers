package writers;

import java.io.IOException;

public class LowerCaseConverter implements WriterInterface {
    private WriterInterface writer;

    LowerCaseConverter(WriterInterface writerInterface){
        writer = writerInterface;
    }

    public String convert(String string){
        return string.toLowerCase();
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
