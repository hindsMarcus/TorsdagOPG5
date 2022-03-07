import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                       // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();            // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");           // Creates and array of strings, where each element is a single word from the file.
        System.out.println(text.length);

       /* printWordsStartingWith("Ø");

        printWordsOfLength(3);*/

        //test dine metoder ved at kalde dem her:

        /*printLongestWord();

        printFirstHalfOfEachWord();*/

        printMostFrequentLetter();

    }

    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (String s : text) {
            if (s.length() == l) {
                if (s.contains(",") || s.contains(".")) {
                    wordisvalid = false;
                }

                if (wordisvalid) {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern) {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    //skriv dine metoder herunder:

    public static String printLongestWord() throws FileNotFoundException {
        String longestWord = "";
        String current;
        Scanner scan = new Scanner(new File("data.txt"));


        while (scan.hasNext()) {
            current = scan.next();
            if (current.length() > longestWord.length()) {
                longestWord = current;
            }

        }
        System.out.println("\n" + longestWord + "\n");
        return longestWord;
    }

    public static void printFirstHalfOfEachWord() {

        for (String s : text) {
            System.out.println(s.substring(0, s.length() / 2));
        }
    }

    public static void printMostFrequentLetter() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("data.txt"));

        int[] count = new int[26];

        while (scan.hasNextLine()) {
            String letter = scan.nextLine();
            letter = letter.toLowerCase();
            char[] myChars = letter.toCharArray();

            for (int i = 0; i< myChars.length ; i++) {
                if((myChars[i] >= 'a') && (myChars[i]<= 'z')) {
                    count[myChars[i] -'a' ]++;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.println((char) (i + 'a'));
            System.out.println(": " + count[i]);
        }
    }
    public static void printLeastFrequentLetter() {

    }
}


