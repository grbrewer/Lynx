import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;

/**
 * This class will take a standard text file, process it
 * and return statistics on word lengths and their frequencies.
 * @author Gavin Brewer
 * @version 1.0
 */
public class WordAnalyzer {

    List<Integer> _wordLengths;

    public WordAnalyzer()
    {

    }

    /**
     * Constructor reads a text file, line-by-line and converts it into a list of word lengths.
     * @param path the path of the file under test.
     */
    public WordAnalyzer(String path) {
        try {
            _wordLengths = new ArrayList<Integer>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            String thisLine;

            while ((thisLine = br.readLine()) != null) {
                List<Integer> lineLengths = getRawData(thisLine);
                _wordLengths.addAll(lineLengths);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns a list of Integers representing word lengths.
     * @return the list of word lengths
     */
    public List<Integer> getWordLengths()
    {
        return _wordLengths;
    }

    /**
     * Returns a list of Integers representing word lengths
     * from a given string.
     * @param str the string under test
     * @return the list of word lengths
     */
    public List<Integer> getRawData(String str) {
        str = str.replaceAll("\\.", "");    //FIX: remove all dot characters from input

        String[] stringList = str.split("\\s");
        List<Integer> wordLengths = new ArrayList<Integer>();

        for (String word : stringList)
        {
            wordLengths.add(word.length());
        }

        return wordLengths;
    }

    /**
     * Returns the number of words in a given string.
     * @param str the string under test
     * @return the number of words returned
     */
    public int getWordCount(String str) {
        str = str.replaceAll("\\.", "");    //FIX: remove all dot characters from input

        String[] stringList = str.split("\\s");
        return stringList.length;
    }

    /**
     * Returns the number of words held within a given file
     * being processed by a WordAnalyzer object.
     * @return the number of words returned
     */
    public int getWordCount() {
        return _wordLengths.size();
    }

    /**
     * Generates a HashTable detailing key lengths and their frequencies,
     * for a given string.
     * @param str the string under test
     * @return the hashtable of lengths and frequencies
     */
    public Hashtable<Integer, Integer> getStatistics(String str) {
        str = str.replaceAll("\\.", "");    //FIX: remove all dot characters from input

        String[] stringList = str.split("\\s");
        Hashtable<Integer, Integer> statsDictionary = new Hashtable<Integer, Integer>();
        List<Integer> wordLengths = new ArrayList<Integer>();

        for (String word : stringList)
        {
            wordLengths.add(word.length());
        }

        for (int wordLength : wordLengths)
        {
            if (statsDictionary.containsKey(wordLength))
            {
                int currentFrequency = statsDictionary.get(wordLength);
                statsDictionary.put(wordLength, ++currentFrequency);
            }

            else
            {
                statsDictionary.put(wordLength, 1);
            }
        }


        return statsDictionary;
    }

    /**
     * Generates a HashTable detailing key lengths and their frequencies,
     * for a text file being processed by WordAnalyzer
     * @return the hashtable of lengths and frequencies
     */
    public Hashtable<Integer, Integer> getStatistics() {
        Hashtable<Integer, Integer> statsDictionary = new Hashtable<Integer, Integer>();

        for (int wordLength : _wordLengths)
        {
            if (statsDictionary.containsKey(wordLength))
            {
                int currentFrequency = statsDictionary.get(wordLength);
                statsDictionary.put(wordLength, ++currentFrequency);
            }

            else
            {
                statsDictionary.put(wordLength, 1);
            }
        }


        return statsDictionary;
    }

    /**
     * Finds the average length of words in a given string.
     * @param str the string under test
     * @return the average length of words in the string
     */
    public double getAverage(String str) {
        str = str.replaceAll("\\.", "");    //FIX: remove all dot characters from input

        String[] stringList = str.split("\\s");
        List<Integer> wordLengths = new ArrayList<Integer>();

        for (String word : stringList)
        {
            wordLengths.add(word.length());
        }

        int sum = 0;
        for(int wordLength : wordLengths)
            sum += wordLength;

        return (double) sum / wordLengths.size();
    }

    /**
     * Finds the average length of strings in a given file,
     * currently being processed by a WordAnalyzer object.
     * @return the average length of words in the file
     */
    public double getAverage() {
        int sum = 0;
        for(int wordLength : _wordLengths)
            sum += wordLength;

        return (double) sum / _wordLengths.size();
    }

    /**
     * Finds the most frequent word length from the WordAnalyzer's hashtable,
     * for a given string.
     * @param str the string under test
     * @return the most frequent word length.
     */
    public int getMostFrequentWordLength(String str) {
        Hashtable<Integer, Integer> statistics = getStatistics(str);

        //Find the most frequent word length
        int max = 0;
        for (Integer key : statistics.keySet())
        {
            Integer tmp = statistics.get(key);
            if (tmp.compareTo(max) > 0)
            {
                max = tmp;
            }
        }

        return max;
    }

    /**
     * Finds the most frequent word length from the WordAnalyzer's hashtable,
     * for a given file.
     * @return the most frequent word length.
     */
    public int getMostFrequentWordLength() {
        Hashtable<Integer, Integer> statistics = getStatistics();

        //Find the most frequent word length
        int max = 0;
        for (Integer key : statistics.keySet())
        {
            Integer tmp = statistics.get(key);
            if (tmp.compareTo(max) > 0)
            {
                max = tmp;
            }
        }

        return max;
    }

    /**
     * Finds a list of those word lengths with the highest frequency,
     * for a given string.
     * @param str the string under test
     * @return a list of those word lengths with highest frequency
     */
    public List<Integer> getMaximalWordLengths(String str) {
        Hashtable<Integer, Integer> statistics = getStatistics(str);
        List<Integer> maximalElements = new ArrayList<Integer>();

        Integer max = getMostFrequentWordLength(str);

        //Obtain the lengths of words that have this frequency
        for (HashMap.Entry<Integer, Integer> entry : statistics.entrySet())
        {
            if (entry.getValue().equals(max))
            {
                maximalElements.add(entry.getKey());
            }
        }

        Collections.sort(maximalElements);

        return maximalElements;
    }

    /**
     * Finds a list of those word lengths with the highest frequency,
     * for a given file under WordAnalyzer.
     * @return a list of those word lengths with highest frequency
     */
    public List<Integer> getMaximalWordLengths() {
        Hashtable<Integer, Integer> statistics = getStatistics();
        List<Integer> maximalElements = new ArrayList<Integer>();

        Integer max = getMostFrequentWordLength();

        //Obtain the lengths of words that have this frequency
        for (HashMap.Entry<Integer, Integer> entry : statistics.entrySet())
        {
            if (entry.getValue().equals(max))
            {
                maximalElements.add(entry.getKey());
            }
        }

        Collections.sort(maximalElements);

        return maximalElements;
    }

    /**
     * Pretty print the word count for a given file.
     * @return the word count
     */
    public String printWordCount() {
        return "Word count = " + getWordCount();
    }

    /**
     * Pretty print the word count for a given string.
     * @param str the string under test
     * @return the word count
     */
    public String printWordCount(String str) {
        return "Word count = " + getWordCount(str);
    }

    /**
     * Pretty print the average of word lengths in a given file.
     * @return the average word length
     */
    public String printAverage() {
        return String.format("Average word length = %.3f", getAverage());
    }

    /**
     * Pretty print the average of word lengths in a given string
     * @param str the string under test
     * @return the average word length
     */
    public String printAverage(String str) {
        return String.format("Average word length = %.3f", getAverage(str));
    }

    /**
     * Generate a list of strings to convey frequencies for
     * words of different lengths, for a given string.
     * @param str the string under test
     * @return the list of strings describing lengths and their frequencies
     */
    public List<String> printStatistics(String str) {
        Hashtable<Integer, Integer> statistics = getStatistics(str);
        List<String> statsList = new ArrayList<String>();

        Enumeration<Integer> statsEnum = statistics.keys();

        while(statsEnum.hasMoreElements())
        {
            int key = statsEnum.nextElement();
            int frequency = statistics.get(key);

            String frequencyEntry = String.format("Number of words of length %d is %d", key,  frequency);
            statsList.add(frequencyEntry);
        }

        Collections.reverse(statsList);

        return statsList;
    }

    /**
     * Generate a list of strings to convey frequencies for
     * words of different lengths, for a given file.
     * @return the list of strings describing lengths and their frequencies
     */
    public List<String> printStatistics() {
        Hashtable<Integer, Integer> statistics = getStatistics();
        List<String> statsList = new ArrayList<String>();

        Enumeration<Integer> statsEnum = statistics.keys();

        while(statsEnum.hasMoreElements())
        {
            int key = statsEnum.nextElement();
            int frequency = statistics.get(key);

            String frequencyEntry = String.format("Number of words of length %d is %d", key,  frequency);
            statsList.add(frequencyEntry);
        }

        Collections.reverse(statsList);

        return statsList;
    }

    /**
     * Summarizes the most frequently occurring word lengths,
     * for a given string.
     * @param str the string under test
     * @return the formatted output summarizing word lengths
     */
    public String printMaximumWordLengths(String str) {

        String preamble = String.format("The most frequently occurring word length is %d, for word lengths of ",
                                         getMostFrequentWordLength(str));
        StringBuilder wordLengthListBuilder = new StringBuilder();

        List<Integer> wordLengths = getMaximalWordLengths(str);

        for (int i=0; i < wordLengths.size(); i++)
        {

            if (i == wordLengths.size() - 1)
                wordLengthListBuilder.append(wordLengths.get(i));
            else
                wordLengthListBuilder.append(wordLengths.get(i)).append(" & ");
        }

        String wordLengthList = wordLengthListBuilder.toString();

        return preamble + wordLengthList;
    }

    /**
     * Summarizes the most frequently occurring word lengths,
     * for a given file
     * @return the formatted output summarizing word lengths
     */
    public String printMaximumWordLengths() {
        String preamble = String.format("The most frequently occurring word length is %d, for word lengths of ",
                getMostFrequentWordLength());
        StringBuilder wordLengthListBuilder = new StringBuilder();

        List<Integer> wordLengths = getMaximalWordLengths();

        for (int i=0; i < wordLengths.size(); i++)
        {

            if (i == wordLengths.size() - 1)
                wordLengthListBuilder.append(wordLengths.get(i));
            else
                wordLengthListBuilder.append(wordLengths.get(i)).append(" & ");
        }

        String wordLengthList = wordLengthListBuilder.toString();

        return preamble + wordLengthList;
    }

    /**
     * Pretty print a report summarizing the results of
     * WordAnalyzer's analysis of a given file.
     */
    public void printStatisticsReport()
    {
        System.out.println(printWordCount());
        System.out.println(printAverage());

        List<String> statistics = printStatistics();

        for (String entry : statistics)
        {
            System.out.println(entry);
        }

        System.out.println(printMaximumWordLengths());
    }

    /**
     * Pretty print a report summarizing the results of
     * WordAnalyzer's analysis of a given string.
     * @param str the string under test
     */
    public void printStatisticsReport(String str)
    {
        System.out.println(printWordCount(str));
        System.out.println(printAverage(str));

        List<String> statistics = printStatistics(str);

        for (String entry : statistics)
        {
            System.out.println(entry);
        }

        System.out.println(printMaximumWordLengths(str));
    }
}
