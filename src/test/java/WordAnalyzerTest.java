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
     public void testWordCountFromFile() {
         WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
         int wordCount = wordAnalyzer.getWordCount();

         Assertions.assertEquals(25, wordCount);
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
    public void testGetStatisticsFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
        Hashtable<Integer,Integer> wordDictionary = wordAnalyzer.getStatistics();

        Assertions.assertEquals(7, wordDictionary.get(4));
        Assertions.assertEquals(6, wordDictionary.get(2));
    }

    @Test
    public void testGetAverage() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        double average = wordAnalyzer.getAverage("This is a test run");

        Assertions.assertEquals(2.8, average);
    }

    @Test
    public void testGetAverageFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
        double average = wordAnalyzer.getAverage();

        Assertions.assertEquals(3.44, average);
    }

    @Test
    public void testGetMostFrequentWordLength() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        int mostFrequentWordLength = wordAnalyzer.getMostFrequentWordLength("Hello world & good morning. The date is 18/05/2016");

        Assertions.assertEquals(2, mostFrequentWordLength);
    }

    @Test
    public void testGetMostFrequentWordLengthFromFile()
    {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
        int mostFrequentWordLength = wordAnalyzer.getMostFrequentWordLength();

        Assertions.assertEquals(7, mostFrequentWordLength);
    }

    @Test
    public void testGetMaximalWordLengths() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        List<Integer> maximalWordLengths = wordAnalyzer.getMaximalWordLengths("Hello world & good morning. The date is 18/05/2016");

        Assertions.assertEquals(4, maximalWordLengths.get(0));
        Assertions.assertEquals(5, maximalWordLengths.get(1));
    }


    @Test
    public void testGetMaximalWordLengthsFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
        List<Integer> maximalWordLengths = wordAnalyzer.getMaximalWordLengths();

        Assertions.assertEquals(4, maximalWordLengths.get(0));
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

    @Test
    public void testPrintWordCount() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");

        String wordCountString = wordAnalyzer.printWordCount();

        Assertions.assertEquals("Word count = 25", wordCountString);
    }

    @Test
    public void testPrintAverage() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");

        String averageString = wordAnalyzer.printAverage();

        Assertions.assertEquals("Average word length = 3.440", averageString);
    }

    @Test
    public void testPrintStatistics() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();

        List<String> statsList = wordAnalyzer.printStatistics("Hello world & good morning. The date is 18/05/2016");

        Assertions.assertEquals("Number of words of length 1 is 1", statsList.get(0));
        Assertions.assertEquals("Number of words of length 2 is 1", statsList.get(1));
        Assertions.assertEquals("Number of words of length 3 is 1", statsList.get(2));
        Assertions.assertEquals("Number of words of length 4 is 2", statsList.get(3));
        Assertions.assertEquals("Number of words of length 5 is 2", statsList.get(4));
        Assertions.assertEquals("Number of words of length 7 is 1", statsList.get(5));
        Assertions.assertEquals("Number of words of length 10 is 1", statsList.get(6));
    }

    @Test
    public void testPrintStatisticsFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");

        List<String> statsList = wordAnalyzer.printStatistics();

        Assertions.assertEquals("Number of words of length 1 is 1", statsList.get(0));
        Assertions.assertEquals("Number of words of length 2 is 6", statsList.get(1));
        Assertions.assertEquals("Number of words of length 3 is 5", statsList.get(2));
        Assertions.assertEquals("Number of words of length 4 is 7", statsList.get(3));
        Assertions.assertEquals("Number of words of length 5 is 6", statsList.get(4));
    }

    @Test
    public void testPrintMaximumWordLengths() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();

        String maxWordLengths = wordAnalyzer.printMaximumWordLengths("Hello world & good morning. The date is 18/05/2016");

        Assertions.assertEquals("The most frequently occurring word length is 2, for word lengths of 4 & 5", maxWordLengths);
    }

    @Test
    public void testPrintMaximumWordLengthsFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");

        String maxWordLengths = wordAnalyzer.printMaximumWordLengths();

        Assertions.assertEquals("The most frequently occurring word length is 7, for word lengths of 4", maxWordLengths);
    }

    //The following tests are visual verification only, no asserts..

    @Test
    public void testPrintStatisticsReportFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\test_data.txt");
        wordAnalyzer.printStatisticsReport();
    }

    @Test
    public void testPrintStatisticsReport() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        wordAnalyzer.printStatisticsReport("Hello world & good morning. The date is 18/05/2016");
    }

    @Test
    public void testBibleFromFile() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("C:\\Users\\gavin\\OneDrive\\Documents\\bible_daily.txt");
        wordAnalyzer.printStatisticsReport();
    }
}
