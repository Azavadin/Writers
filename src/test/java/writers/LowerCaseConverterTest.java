package writers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class LowerCaseConverterTest {
    @Test
    public void writeOnceAndCheckLowerCaseConverter() throws IOException {
        LowerCaseConverter writer = new LowerCaseConverter(new StringWriter());
        writer.write("Software Design");
        assertEquals("software design", writer.toString());
    }
    @Test
    public void writeTwiceAndCheckLowerCaseConverter() throws IOException{
        LowerCaseConverter writer = new LowerCaseConverter(new StringWriter());
        writer.write("Software");
        writer.write("Design");
        assertEquals("softwaredesign", writer.toString());
    }
    @Test
    public void callCloseAndCheckLowerCaseConverter() throws IOException{
        LowerCaseConverter writer = new LowerCaseConverter(new StringWriter());
        writer.write("Software");
        writer.close();
        writer.write("Design");
        assertEquals("software", writer.toString());
    }

    @Test
    public void callStupidRemoverCloseAndCheckLowerCaseConverter() throws IOException{
        LowerCaseConverter writer = new LowerCaseConverter(new StringWriter());
        writer.write("Software");
        writer.close();
        writer.write("Design");
        assertEquals("software", writer.toString());
    }

}
