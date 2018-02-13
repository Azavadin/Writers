package writers;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StupidRemoverTest {

    static StupidRemover stupidRemover;

    @Before
    public void setup()
    {
        stupidRemover = new StupidRemover();
    }

    @Test
    public void testStupidRemover() throws IOException {
        String string = "This is stupid remover";
        String stringAfterConversion = "This is s***** remover";
        String convertedString = stupidRemover.remove(string);
        assertTrue(convertedString.equals(stringAfterConversion));
    }

    @Test
    public void callStupidRemoverClose() throws IOException{
        StupidRemover stupidRemover = new StupidRemover(new StringWriter());
        stupidRemover.write("stupid");
        stupidRemover.close();
        stupidRemover.write("Revomer");
        assertEquals("s*****", stupidRemover.toString());
    }
  }

