public class Quote {

    private String author;
    private String quote;

    public Quote(String author, String quote){
        this.quote = quote;
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public String getQuote() {
        return quote;
    }

    @Override
    public String toString() {
        return quote + " - " + author;
    }
}
