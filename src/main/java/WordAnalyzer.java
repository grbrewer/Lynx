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
}
