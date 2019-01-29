/**
 * 49 medium
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();

        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> record = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // key in mind, this is the method to convert char[] to String
            //System.out.println(key);
            if (record.containsKey(key)){
                ans.get(record.get(key)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
                record.put(key, ans.size()-1);
            }

        }
        return ans;

    }
}
