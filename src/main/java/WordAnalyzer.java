import java.util.*;

public class WordAnalyzer {

    public int getWordCount(String str) {
        String[] stringList = str.split("\\s");
        return stringList.length;
    }

    public Hashtable<Integer, Integer> getStatistics(String str) {
        String[] stringList = str.split("\\s");
        Hashtable<Integer, Integer> statsDictionary = new Hashtable<Integer, Integer>();
        List<Integer> wordLengths = new ArrayList<Integer>();

        for (String word : stringList)
        {
            wordLengths.add(word.length());
        }

        statsDictionary.put(0, 0);

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

    public double getAverage(String str) {
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
}
