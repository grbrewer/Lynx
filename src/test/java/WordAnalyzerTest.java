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

}
