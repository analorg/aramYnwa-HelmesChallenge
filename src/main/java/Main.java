import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String path = args[0];
        String wordToSearch = args[1];

        // Two words are anagrams if we sort them by same principe we will get the same word
        String sortedWord = sortString(wordToSearch);
        ArrayList<String> anagramsFound = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                if (sortString(line).equals(sortedWord))
                   anagramsFound.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long stop = System.currentTimeMillis() - startTime;

        System.out.print(stop);
        for (String s : anagramsFound) {
            System.out.printf(", %s", s);
        }

    }

    private static String sortString(String tmp) {
        char[] tmpArray = tmp.toCharArray();
        Arrays.sort(tmpArray);
        return new String(tmpArray);
    }
}
