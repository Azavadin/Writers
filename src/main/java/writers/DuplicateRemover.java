package writers;

import java.io.IOException;
import java.util.StringTokenizer;

public class DuplicateRemover implements WriterInterface{
    public String convert(String string)
    {
        return remove(string);
    }

    private WriterInterface writer;

    DuplicateRemover(WriterInterface writerInterface)
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

    public String remove(String string)
    {
        StringTokenizer tokens = new StringTokenizer(string);
        StringBuilder stringBuilder = new StringBuilder();
        String current = "";

        while(tokens.hasMoreElements()){
            String next = tokens.nextToken();
            if(!current.equals(next)){
                stringBuilder.append(next + " ");
                current = next;
            }
        }
        return stringBuilder.toString().trim();
    }
}
