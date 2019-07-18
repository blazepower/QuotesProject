import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class SortQuotes {

    public static int getLongestAuthor(ArrayList<Quote> quoteArrayList){
        int longestAuthor = 0;
        for (Quote quote : quoteArrayList){
            int authorLength = quote.getAuthor()
                    .length();
            if (authorLength > longestAuthor)
                longestAuthor = authorLength;
        }
        return longestAuthor;
    }

    public static ArrayList<Quote> charSort(ArrayList<Quote> quoteArrayList, int sortIndex){
        int[] count = new int[58];
        ArrayList<Quote> noAuthor = new ArrayList<>();
        for (int a : count)
            a = 0;
        System.out.println(quoteArrayList.size());
        Quote[] sortedByChar = new Quote[quoteArrayList.size()];

        for(int i = 0; i < quoteArrayList.size(); i++){
            Quote temp = quoteArrayList.get(i);
            int sortAsInt;
            try {
                char sort = temp.getAuthor().charAt(sortIndex);
                //System.out.println(sort);

                if (sort == '.' || sort == '-' || sort == '\'' || sort == ' ') {
                    sortAsInt = 0;
                }
                else {
                    sortAsInt = (int) (sort) - 65;
                }
                //System.out.println(sortAsInt);
                count[sortAsInt]++;
                //System.out.println(temp.toString());
            }
            catch (NullPointerException e){
                noAuthor.add(quoteArrayList.get(i));
                quoteArrayList.remove(i);
            }
            catch (StringIndexOutOfBoundsException e){

            }
        }

        for (int i = 1; i <= 57; i++){
            count[i] += count[i-1];
        }

        for (int i = quoteArrayList.size()-1; i >= 0; i--){
            Quote temp = quoteArrayList.get(i);
            //System.out.println(temp.toString());
            try {
                char sort = temp.getAuthor().charAt(sortIndex);
                if (sort != '.' && sort != '-' && sort != ' ' && sort != '\'') {
                    int sortAsInt = (int) (sort) - 65;
                    //System.out.println(temp.getQuote() + "  " + sortIndex + "    " + sortAsInt + "  ");
                    System.out.println(sort + " " + sortAsInt);
                    sortedByChar[count[sortAsInt] - 1] = temp;
                    System.out.println(sortedByChar[count[sortAsInt] - 1]);
                    count[sortAsInt]--;
                }
            }
            catch (NullPointerException | StringIndexOutOfBoundsException e){

            }
            //System.out.println(temp.toString());
        }
        ArrayList<Quote> sortedQuotes = new ArrayList<>();
        //for (Quote quote : sortedByChar)
            //System.out.println(quote.toString());
            //sortedQuotes.add(quote);

        for (Quote quote : noAuthor)
            sortedQuotes.add(0, quote);

        quoteArrayList = sortedQuotes;
        //System.out.println(sortIndex);
        for (Quote q: sortedQuotes
        ) {
                //System.out.println("    -   " + q.getQuote());
        }
        return quoteArrayList;
    }
   public static ArrayList<Quote> sort(ArrayList<Quote> quoteArrayList)throws IOException {
        int longestAuthor = getLongestAuthor(quoteArrayList);

        for (int i = 0; i < longestAuthor; i++){
            charSort(quoteArrayList, i);
        }
        return quoteArrayList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Quote> quotes;
        BufferedReader reader = OpenFile.openFile();
        ArrayList<Quote> sorted;
        quotes = ImportQuotes.fillList(reader);

        sorted = charSort(quotes, 1);
        //quotes = charSort(quotes, 0);
        //ArrayList<Quote> sorted = charSort(quotes, 0);
        //Quote q = sorted.get(2);
        //if (q == null) {
            //System.out.println("q is null");

        //}
        //System.out.println(q.toString());

        for (int i = 0; i < quotes.size(); i++){
            //Quote q = quotes.get(i);
            //System.out.println(q.toString());
        }
    }
}