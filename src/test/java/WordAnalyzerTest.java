import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
