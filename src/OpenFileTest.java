import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class OpenFileTest {

    @Test
    public void openFile() {
        File quotesFile = new File("C:\\Users\\homba\\Documents\\QuotesProject\\quotes.txt");
        Assert.assertNotNull(quotesFile);
    }
}
