package writers;
import java.io.IOException;

public interface WriterInterface{
    public  void write(String content) throws IOException;
    public void close() throws IOException;
}

