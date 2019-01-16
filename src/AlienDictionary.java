/***
 * 269 hard grapy/topological sort
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 *
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 *
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 *
 * Note:
 *
 *     You may assume all letters are in lowercase.
 *     You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 *     If the order is invalid, return an empty string.
 *     There may be multiple valid order of letters, return any one of them is fine.
 */

import java.util.*;
public class AlienDictionary {


    /**
     * @param  words
     * @return the order of letters in this language.
     *
     * Pipeline :
     * 1. record how many different letter appears in the String[]
     * 2. ArrayList(<Set></>size = 26), store all the other letters behind the selected letter.
     * 3. Compare two consecutive words
     * 4. int[] indegree, record how many letters appears before a selected letter.
     * 5. use the queue to store the append letter in a stringbuilder in lexicographical order
     * 6. check whether all the letters has been attached in the stringbuilder
     */


    public static String alienOrder(String[] words) {

        if (words == null || words.length ==0) return "";
        List<Set<Integer>> record = new ArrayList<>();
        int[] indegree = new int[26];
        for (int i = 0; i < 26; i++){
            record.add(new HashSet<Integer>());
            indegree[i] = -1;
        }

        int letCount = 0;
        for (int i = 0; i < words.length; i++){
            for (char c : words[i].toCharArray()){
                if (indegree[c - 'a'] == -1){
                    indegree[c - 'a']++;
                    letCount++;
                }
            }
        }


        //To compare two words
        for (int i = 0; i < words.length - 1; i++){
            //System.out.println(i);
            char[] chars1 = words[i].toCharArray();
            char[] chars2 = words[i+1].toCharArray();
            int len = Math.min(chars1.length, chars2.length);

            for (int j = 0; j < len; j++){
                if (chars1[j] != chars2[j]){
                    if(!record.get(chars1[j] - 'a').contains(chars2[j] - 'a')) {
                        record.get(chars1[j] - 'a').add(chars2[j] - 'a');
                        indegree[chars2[j] - 'a']++;
                        //System.out.println("chars1: " + chars1[j] + " chars2: " + chars2[j]);
                    }
                    break;

                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++){
            if (indegree[i] == 0){
                q.add(i);
                //System.out.println((char) (i +'a'));
            }
        }


        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()){
            int tmp = q.poll();
            ans.append((char) (tmp + 'a'));
            for (int follower : record.get(tmp)){
                //System.out.println("follower: " + (char) (follower+'a'));
                indegree[follower]--;
                if (indegree[follower] == 0){
                    q.add(follower);
                }
            }
        }

        //System.out.println("letCount: " +letCount);
        //System.out.println(ans.toString());

        return (letCount == ans.toString().length())? ans.toString() : "";
    }

    public static void main(String[] args){
        String[] words = { "za","zb","ca","cb"};
        System.out.println(alienOrder(words));

        /**
        char[] chars1 = new String("wrt").toCharArray();
        char[] chars2 = new String("wrf").toCharArray();
        int len = Math.min(chars1.length, chars2.length);
        for (int j = 0; j < len; j++){
            if (chars1[j] != chars2[j]){
                System.out.println(j);
                break;
            }
        }
         **/
    }
}
