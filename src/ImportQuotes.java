import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author - Rishik Hombal
 */
class ImportQuotes {

    /**
     *
     * @param reader - A BufferedReader with the contents of the quote file
     * @return - ArrayList with the quotes
     * @throws IOException
     */
    static ArrayList<Quote> fillList(BufferedReader reader) throws IOException {
        ArrayList<Quote> list = new ArrayList<>();
        String quoteWithAuthor;
        while ((quoteWithAuthor = reader.readLine()) != null) {
            int separator = quoteWithAuthor.lastIndexOf(" - ");

            if (separator >= 1) {
                String quote = quoteWithAuthor.substring(0, separator)
                        .trim();
                String author = quoteWithAuthor.substring(separator + 2)
                        .trim();

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