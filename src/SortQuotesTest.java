import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class SortQuotesTest {

    private Quote quote1, quote2, quote3, quote4, quote5;
    private ArrayList<Quote> list = new ArrayList<>();
    @Before
    public void setUp(){
        quote1 = new Quote("Author 1", "Quote 1");
        quote2 = new Quote("Author 2", "Quote 2");
        quote3 = new Quote("This is the longest author", "25 characters");
        quote4 = new Quote("Bdu Lao-Gao", "quote");
        quote5 = new Quote("A. A. Author", "quote 5");
        list.add(quote1); list.add(quote2); list.add(quote3); list.add(quote4); list.add(quote5);
    }

    @Test
    public void getLongestAuthor() {
        int actual = SortQuotes.getLongestAuthor(list);
        int expected = quote3.getAuthor().length();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void charSortTestAt0() {
        ArrayList<Quote> actualSortBy0 = SortQuotes.charSort( list, 0);

        ArrayList<Quote> expectedSortBy0 = new ArrayList<>();
        expectedSortBy0.add(quote1); expectedSortBy0.add(quote2); expectedSortBy0.add(quote5); expectedSortBy0.add(quote4); expectedSortBy0.add(quote3);

        Assert.assertEquals(expectedSortBy0, actualSortBy0);
    }

    @Test
    public void charSortTestAt1(){
        ArrayList<Quote> actualSortBy1 = SortQuotes.charSort( list, 1);
        ArrayList<Quote> expectedSortBy1 = new ArrayList<>();

        expectedSortBy1.add(quote5); expectedSortBy1.add(quote4); expectedSortBy1.add(quote3); expectedSortBy1.add(quote1); expectedSortBy1.add(quote2);
        Assert.assertEquals(expectedSortBy1, actualSortBy1);
    }


    @Test
    public void sortTest(){
        ArrayList<Quote> actualSort = SortQuotes.sort(list);
        ArrayList<Quote> expectedSort = new ArrayList<>();

        expectedSort.add(quote5); expectedSort.add(quote1); expectedSort.add(quote2); expectedSort.add(quote4); expectedSort.add(quote3);

        Assert.assertEquals(expectedSort, actualSort);
    }

    @Test
    public void testIsDouble(){
        ArrayList<Quote> one = list;
        ArrayList<Quote> two = list;

        Quote quote6 = new Quote("A. A. Author", "quote 5");
        two.add(quote6);

        SortQuotes.isDouble(two);

        Assert.assertEquals(one, two);
    }
}