import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportQuotes {

    public static ArrayList<Quote> fillList() throws IOException {
        BufferedReader reader = OpenFile.openFile();
        ArrayList<Quote> list = new ArrayList<>();

        String quoteWithAuthor;
        while ((quoteWithAuthor = reader.readLine()) != null) {
            int separator = quoteWithAuthor.lastIndexOf(" - ");

            if (separator >= 1) {
                String quote = quoteWithAuthor.substring(0, separator);
                String author = quoteWithAuthor.substring(separator + 2);

                quote = quote.trim();
                author = author.trim();

                Quote quote1 = new Quote(author, quote);
                list.add(quote1);
            }
            else {
                String quote = quoteWithAuthor.trim();
                String author = "Unknown";

                Quote quote1 = new Quote(author, quote);
                list.add(quote1);
            }
        }
        return list;
    }
}
