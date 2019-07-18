/**
 * @author - Rishik Hombal
 */
public class Quote {

    private String author;
    private String quote;

    /**
     * @param author - Author of the quote
     * @param quote - Text of the quote
     */
    Quote(String author, String quote){
        this.quote = quote.trim();
        this.author = author.trim();
    }

    /**
     * @return author
     */
    String getAuthor(){
        return author;
    }

    /**
     * @return quote
     */
    String getQuote() {
        return quote;
    }

    @Override
    public String toString() {
        return quote + " - " + author;
    }

    /**
     *
     * @param q - other quote to be compared
     * @return - boolean true or false if comparison succeeds or fails
     */
    public boolean equals(Quote q) {
        return quote.equals(q.getQuote()) && author.equals(q.getAuthor());
    }
}
