package writers;

import org.junit.Before;

import java.io.IOException;

public class StringWriterTest extends WriterTest{
    private StringWriter stringWriter;

    @Before
    public void setUp(){
        stringWriter = new StringWriter();
    }

    @Override
    protected WriterInterface createWriter() throws IOException {
        return new StringWriter();
    }

    @Override
    protected String getContent() {
        return getWriter().toString();
    }
}