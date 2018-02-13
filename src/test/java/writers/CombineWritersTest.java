package writers;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CombineWritersTest {



    @Test
    public void DuplicateRemoverOnStupidRemoverLowerCase() throws IOException {
        StringWriter stringWriter = new StringWriter();
        LowerCaseConverter lowerCaseConverter = new LowerCaseConverter(stringWriter);
        StupidRemover stupidRemover = new StupidRemover(lowerCaseConverter);
        WriterInterface combinedWriter = new DuplicateRemover(stupidRemover);
        combinedWriter.write("HELLO STUPID STUPID WORLD");
        assertEquals("hello stupid world", combinedWriter.toString());
    }

    @Test
    public void DuplicateRemoverOnStupidRemoverUpperCase() throws IOException {
        StringWriter stringWriter = new StringWriter();
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(stringWriter);
        StupidRemover stupidRemover = new StupidRemover(upperCaseConverter);
        WriterInterface combinedWriter = new DuplicateRemover(stupidRemover);
        combinedWriter.write("hello stupid stupid world");
        assertEquals("HELLO S***** WORLD", combinedWriter.toString());
    }

    @Test
    public void stupidRemoverOnUpperCase() throws IOException {
        StringWriter stringWriter = new StringWriter();
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(stringWriter);
        StupidRemover combinedWriter = new StupidRemover(upperCaseConverter);
        combinedWriter.write("HELLO stupid world");
        assertEquals("HELLO S***** WORLD", combinedWriter.toString());
    }

    @Test
    public void stupidRemoverOnLowerWithFileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("sample.txt");
        LowerCaseConverter lowerCaseConverter = new LowerCaseConverter(fileWriter);
        StupidRemover stupidRemover = new StupidRemover(lowerCaseConverter);
        WriterInterface combinedWriter = new DuplicateRemover(stupidRemover);
        combinedWriter.write("hello stupid stupid world");
        assertEquals("hello s***** world", new FileWriterTest().readFile());
    }

    @Test
    public void stupidRemoverOnUpper() throws IOException {
        StringWriter stringWriter = new StringWriter();
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(stringWriter);
        StupidRemover stupidRemover = new StupidRemover(upperCaseConverter);
        WriterInterface combinedWriter = new DuplicateRemover(stupidRemover);
        combinedWriter.write("hello stupid stupid world");
        assertEquals("HELLO S***** WORLD", combinedWriter.toString());
    }

    @Test
    public void duplicateRemoverOnLowerCase() throws IOException {
        StringWriter stringWriter = new StringWriter();
        LowerCaseConverter lowerCaseConverter = new LowerCaseConverter(stringWriter);
        DuplicateRemover combinedWriter = new DuplicateRemover(lowerCaseConverter);
        combinedWriter.write("HELLO STUPID STUPID WORLD");
        assertEquals("hello stupid world", combinedWriter.toString());
    }

    @Test
    public void duplicateRemoverOnStupidRemover() throws IOException {
        StringWriter stringWriter = new StringWriter();
        StupidRemover stupidRemover = new StupidRemover(stringWriter);
        DuplicateRemover combinedWriter = new DuplicateRemover(stupidRemover);
        combinedWriter.write("Hello stupid world world");
        assertEquals("Hello s***** world", combinedWriter.toString());
    }

    @Test
    public void duplicateRemoverOnUpperCase() throws IOException {
        StringWriter stringWriter = new StringWriter();
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(stringWriter);
        DuplicateRemover combinedWriter = new DuplicateRemover(upperCaseConverter);
        combinedWriter.write("hello stupid stupid world");
        assertEquals("HELLO STUPID WORLD", combinedWriter.toString());
    }

}
