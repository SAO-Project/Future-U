package com.example.future_u.assessment.resume;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Util class for PercentageOfClassification class. Gets HashMap of words to vectors.
 * Example:
 *      // Use HashMap as needed.
 *      // Should only be used once.
 *      HashMap<String, ArrayList<Double>> vectorOfWord =
 *                              PercentageOfClassificationUtil.getAllWordsMap();
 *
 */

public class PercentageOfClassificationUtil {

    /**
     * Reads through 'glove.6b.50d.txt', file contains more than 40,000 words in the english
     * language. With each word mapped to a vector.
     * This method builds a HashMap with the word as the key and its corresponding vector as the
     * value.
     * @return HashMap of String to ArrayList<Double>.
     * Method Has been tested works.
     */
    static HashMap<String, ArrayList<Double>> getAllWordsMap() {
        HashMap<String, ArrayList<Double>> vectorOfWord = new HashMap<>();

        // Fastest way to read through a file.
        BufferedReader reader;

        try {
            reader = new BufferedReader(
                    new FileReader("/Users/greywind/Desktop/Hello/hello/app/src/main/java/com/example/future_u/assessment/resume/glove.6B.50d.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] splitLine = line.split(" ");

                // Will put the word as the key, then call 'getVectorList' which returns an
                // ArrayList of doubles or vectors to 'splitLine[0]'.
                ArrayList<Double> doubles = getVectorList(Arrays.copyOfRange(splitLine, 1, splitLine.length-1));
                vectorOfWord.put(splitLine[0], doubles);

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.toString() + "\n Failed to read words.");
        }

        return vectorOfWord;
    }

    /**
     * Helper method to 'getAllWordsMap()'. Converts Strings to Doubles.
     * @param stringVector Array of vectors.
     * @return ArrayList of doubles, vectors.
     */
    private static ArrayList<Double> getVectorList(String[] stringVector) {
        // This list will be stored in the hashtable.
        ArrayList<Double> vectors = new ArrayList<>();

        // Converts the values to doubles.
        for (String string : stringVector) {
            vectors.add(Double.parseDouble(string));
        }
        return vectors;
    }

    /**
     * Returns the dot product of two vectors. Uses 'vectorOfWord' to retrieve the corresponding
     * vector.
     * Performs the entire operation in constant time. Gets the similarity between two words.
     * Example:
     *      // 'vectorOfWord' should already be initialized.
     *      // 'dotProduct' is ready for use.
     *      Double dotProduct = sim(word1, word2, vectorOfWord);
     * @param word1 First word.
     * @param word2 Second word.
     * @param vectorOfWord HashMap containing the word as a key and the vector as the list.
     * @return the dot product.
     */
    public static Double sim(String word1, String word2,
                             HashMap<String, ArrayList<Double>> vectorOfWord) {

        ArrayList<Double> word1Vectors = vectorOfWord.get(word1);
        ArrayList<Double> word2Vectors = vectorOfWord.get(word2);

        // Crash if something went wrong
        if (word1Vectors == null || word2Vectors == null) {
            NullPointerException exception = new NullPointerException("w1Vectors or w2");
            exception.printStackTrace();
        }

        Double dotProduct = 0.0;
        Double sumOfVector1 = 0.0;
        Double sumOfVector2 = 0.0;

        // Just to be safe.
        assert word1Vectors != null;
        assert word2Vectors != null;
        for (int i = 0; i < word1Vectors.size(); i++) {
            sumOfVector1 += (word1Vectors.get(i) * word1Vectors.get(i));
            sumOfVector2 += (word2Vectors.get(i) * word2Vectors.get(i));
            dotProduct += (word1Vectors.get(i) * word2Vectors.get(i));
        }
        return dotProduct / (Math.sqrt(sumOfVector1) * Math.sqrt(sumOfVector2));
    }
}
