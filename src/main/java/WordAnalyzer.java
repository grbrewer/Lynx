import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;

public class WordAnalyzer {

    List<Integer> _wordLengths;

    public WordAnalyzer()
    {

    }

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

    public List<Integer> getWordLengths()
    {
        return _wordLengths;
    }

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

    public int getWordCount(String str) {
        str = str.replaceAll("\\.", "");    //FIX: remove all dot characters from input

        String[] stringList = str.split("\\s");
        return stringList.length;
    }

    public int getWordCount() {
        return _wordLengths.size();
    }

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

    public double getAverage() {
        int sum = 0;
        for(int wordLength : _wordLengths)
            sum += wordLength;

        return (double) sum / _wordLengths.size();
    }

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

    public String printWordCount() {
        return "Word count = " + getWordCount();
    }

    public String printAverage() {
        return String.format("Average word length = %.3f", getAverage());
    }

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
}
