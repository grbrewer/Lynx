import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class WordAnalyzerTest {

    @Test
    public void testWordCount() {
            WordAnalyzer wordAnalyzer = new WordAnalyzer();
            int wordCount = wordAnalyzer.getWordCount("This is a test run");

            Assertions.assertEquals(5, wordCount);
     }

    @Test
    public void testGetStatistics() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        Hashtable<Integer,Integer> wordDictionary = wordAnalyzer.getStatistics("This is a test run");

        Assertions.assertEquals(2, wordDictionary.get(4));
        Assertions.assertEquals(1, wordDictionary.get(2));
        Assertions.assertEquals(1, wordDictionary.get(3));
    }

    @Test
    public void testGetAverage() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        double average = wordAnalyzer.getAverage("This is a test run");

        Assertions.assertEquals(2.8, average);
    }

    @Test
    public void testGetMostFrequentWordLength() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        int mostFrequentWordLength = wordAnalyzer.getMostFrequentWordLength("Hello world & good morning. The date is 18/05/2016");

        Assertions.assertEquals(2, mostFrequentWordLength);
    }

    @Test
    public void testGetMaximalWordLengths() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        List<Integer> maximalWordLengths = wordAnalyzer.getMaximalWordLengths("Hello world & good morning. The date is 18/05/2016");

        Assertions.assertEquals(4, maximalWordLengths.get(0));
        Assertions.assertEquals(5, maximalWordLengths.get(1));
    }

    @Test
    public void testGetRawData()
    {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        List<Integer> rawData = wordAnalyzer.getRawData("This is a test run");

        Assertions.assertEquals(4, rawData.get(0));
        Assertions.assertEquals(2, rawData.get(1));
        Assertions.assertEquals(1, rawData.get(2));
        Assertions.assertEquals(4, rawData.get(3));
        Assertions.assertEquals(3, rawData.get(4));
    }

    @Test
    public void testGetWordLengths() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
        List<Integer> rawData = wordAnalyzer.getWordLengths();

        //Data obtained from the 1st line grabbed
        Assertions.assertEquals(1, rawData.get(0));
        Assertions.assertEquals(3, rawData.get(1));
        Assertions.assertEquals(2, rawData.get(2));
        Assertions.assertEquals(4, rawData.get(3));
        Assertions.assertEquals(4, rawData.get(4));
        Assertions.assertEquals(5, rawData.get(5));

        //Data obtained from 2nd line grabbed
        Assertions.assertEquals(4, rawData.get(6));
        Assertions.assertEquals(4, rawData.get(7));
        Assertions.assertEquals(2, rawData.get(8));
    }
}
