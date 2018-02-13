package writers;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DuplicateRemoverTest {
    static DuplicateRemover duplicateRemover;

    @Before
    public void setup()
    {
        duplicateRemover = new DuplicateRemover(new StringWriter());
    }

    @Test
    public void testDuplicateRemover() throws IOException {
        String string = "This is duplicate duplicate remover";
        String stringAfterConversion = "This is duplicate remover";
        String convertedString = duplicateRemover.remove(string);
        assertTrue(convertedString.equals(stringAfterConversion));
    }

    @Test
    public void callDuplicateRemoverClose() throws IOException{
        DuplicateRemover duplicateRemover = new DuplicateRemover(new StringWriter());
        duplicateRemover.write("This is duplicate remover");
        duplicateRemover.close();
        duplicateRemover.write("remover");
        assertEquals("This is duplicate remover", duplicateRemover.toString());
    }
}
