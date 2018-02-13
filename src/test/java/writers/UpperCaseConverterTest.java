package writers;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

    public class UpperCaseConverterTest {
    @Test
    public void writeOnceAndCheckUpperCaseConverter() throws IOException {
        UpperCaseConverter writer = new UpperCaseConverter(new StringWriter());
        writer.write("Software Design");
        assertEquals("SOFTWARE DESIGN", writer.toString());
    }
    @Test
    public void writeTwiceAndCheckUpperCaseConverter() throws IOException{
        UpperCaseConverter writer = new UpperCaseConverter(new StringWriter());
        writer.write("Software ");
        writer.write("Design");
        assertEquals("SOFTWARE DESIGN", writer.toString());
    }
    @Test
    public void callCloseAndCheckUpperCaseConverter() throws IOException{
        UpperCaseConverter writer = new UpperCaseConverter(new StringWriter());
        writer.write("Software");
        writer.close();
        writer.write("Design");
        assertEquals("SOFTWARE", writer.toString());
    }
}
