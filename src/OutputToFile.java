import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class OutputToFile {

    static void outputToFile() throws IOException{
        ArrayList<Quote> quotes, sorted;
        BufferedReader reader = OpenFile.openFile();
        quotes = ImportQuotes.fillList(reader);

        sorted = SortQuotes.sort(quotes);

        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("SortedQuotes.txt"), StandardCharsets.US_ASCII));
        for (Quote q : sorted) {
            writer.write(q.toString() + "\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        outputToFile();
    }
}
