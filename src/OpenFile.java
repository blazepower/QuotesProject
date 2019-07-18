import java.io.*;

/**
 * @author - Rishik Hombal
 * Class to open the file containing quotes
 */
public class OpenFile {

    /**
     * Constructor
     */
    public OpenFile(){}

    /**
     *
     * @return BufferedReader reader
     * @throws IOException exception
     */
    static BufferedReader openFile() throws IOException{
        File quotesFile = new File("C:\\Users\\homba\\Documents\\QuotesProject\\quotes.txt");

        return new BufferedReader(new FileReader(quotesFile));
    }
}