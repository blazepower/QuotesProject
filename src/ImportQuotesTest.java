import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ImportQuotesTest {

    private BufferedReader reader;
    @Before
    public void setUp() throws Exception {
        File file = new File("C:\\Users\\homba\\Documents\\QuotesProject\\src\\ImportQuotesTest.txt");

        reader = new BufferedReader(new FileReader(file));
    }

    @Test
    public void fillList() throws IOException {
        ArrayList<Quote> actual = ImportQuotes.fillList(reader);
        ArrayList<Quote> expected = new ArrayList<>();

        Quote q1 = new Quote("Test Test", "This is a quote.");
        Quote q2 = new Quote("Author Two", "Quote 2.");
        Quote q3 = new Quote("Unknown", "This quote does not have an author.");
        Quote q4 = new Quote("Author Three-three", "Quote 3.");

        expected.add(q1); expected.add(q2); expected.add(q3); expected.add(q4);

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}