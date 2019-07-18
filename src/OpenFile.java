import java.io.*;

public class OpenFile {

    public OpenFile(){}

    public static void main(String[] args) throws IOException {
       BufferedReader br = openFile();

        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

    public static BufferedReader openFile() throws IOException{
        File quotesFile = new File("C:\\Users\\homba\\Documents\\Rainmeter\\Skins\\MyQuotes\\quotes.txt");

        if (quotesFile == null){
            throw new FileNotFoundException("Cannot find quotes file");
        }

        BufferedReader reader = new BufferedReader(new FileReader(quotesFile));

        return reader;
    }
}
