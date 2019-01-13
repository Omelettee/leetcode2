/**
 * LC 804 easy hash table
 *
 * nternational Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 */

import java.util.*;

public class UniqueMorseCode {

    public int uniqueMorseRepresentations(String[] words) {

            String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                    "....","..",".---","-.-",".-..","--","-.",
                    "---",".--.","--.-",".-.","...","-","..-",
                    "...-",".--","-..-","-.--","--.."};

            Set<String> seen = new HashSet<>();
            for (String word : words){
                StringBuilder sb = new StringBuilder();
                for (char c : word.toCharArray()){
                    sb.append(MORSE[c - 'a']);
                }
                seen.add(sb.toString());
            }
            return seen.size();
        }

}
