import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class SortQuotes {

    static void isDouble(ArrayList<Quote> quotes){
        for (int i = 0; i < quotes.size(); i++){
            for (int j = 0; j < quotes.size(); j++){
                if (i != j && quotes.get(i).equals(quotes.get(j))){
                    quotes.remove(quotes.get(j));
                    j--;
                }
            }
        }
    }

    static int getLongestAuthor(ArrayList<Quote> quoteArrayList){
        int longestAuthor = 0;
        for (Quote quote : quoteArrayList){
            int authorLength = quote.getAuthor()
                    .length();
            if (authorLength > longestAuthor)
                longestAuthor = authorLength;
        }
        return longestAuthor;
    }

    static ArrayList<Quote> charSort(ArrayList<Quote> quoteArrayList, int sortIndex){
        int[] count = new int[123];
        for (int a : count)
            a = 0;
        Quote[] sortedByChar = new Quote[quoteArrayList.size()];

        for(int i = 0; i < quoteArrayList.size(); i++){
            Quote temp = quoteArrayList.get(i);
            int sortAsInt;
            if(temp.getAuthor().length() > sortIndex ) {
                char sort = temp.getAuthor().charAt(sortIndex);
                sortAsInt = (int) (sort) ;
                count[sortAsInt]++;
            }
            else {
                sortAsInt = 32;
                count[sortAsInt]++;
            }
        }

        for (int i = 1; i <= 122; i++){
            count[i] += count[i-1];
        }

        for (int i = quoteArrayList.size()-1; i >= 0; i--){
            Quote temp = quoteArrayList.get(i);
            if(temp.getAuthor().length() > sortIndex ) {
                char sort = temp.getAuthor().charAt(sortIndex);
                int sortAsInt = (int) (sort) ;
                sortedByChar[count[sortAsInt] - 1] = temp;
                count[sortAsInt]--;
            }
            else {
                sortedByChar[count[32] - 1] = temp;
                count[32]--;
            }
        }
        ArrayList<Quote> sortedQuotes = new ArrayList<>();
        for (Quote quote : sortedByChar) {
            sortedQuotes.add(quote);
        }

        quoteArrayList = sortedQuotes;
        return quoteArrayList;
    }

   public static ArrayList<Quote> sort(ArrayList<Quote> quoteArrayList) {
        int longestAuthor = getLongestAuthor(quoteArrayList);
        ArrayList<Quote> finalSortedQuoteList = quoteArrayList;

        for (int i = longestAuthor-1; i >= 0; i--){
            finalSortedQuoteList = charSort(finalSortedQuoteList, i);
            System.out.println(i);
        }
        return finalSortedQuoteList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Quote> quotes;
        BufferedReader reader = OpenFile.openFile();
        ArrayList<Quote> sorted;
        quotes = ImportQuotes.fillList(reader);

        sorted = sort(quotes);
        System.out.println(sorted.toString());
    }
}