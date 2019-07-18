import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class QuoteTest {

    private Quote quote1, quote2;
    @Before
    public void setUp()  {
        quote1 = new Quote("Author 1", "Quote 1");
        quote2 = new Quote("Author 2", "Quote 2");
    }

    @Test
    public void getAuthor() {
        Assert.assertEquals("Author 1", quote1.getAuthor());
    }

    @Test
    public void getQuote() {
        Assert.assertEquals("Quote 1", quote1.getQuote());
    }

    @Test
    public void toString1() {
        Assert.assertEquals("Quote 1 - Author 1", quote1.toString());
    }

    @Test
    public void equals1() {
        Assert.assertNotEquals(quote1,quote2);
    }
}