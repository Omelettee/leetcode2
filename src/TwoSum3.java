/***
 * LC 170 easy hash table
 */
import java.util.*;

public class TwoSum3 {
    private List<Integer> record = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();




        /** Initialize your data structure here. */
        public TwoSum3() {
            record = new ArrayList<>();
            map = new HashMap<>();
        }



        /** Add the number to an internal data structure.. */
        public void add(int number) {
            //map.put(number, map.getOrDefault(0, map.get(number) + 1));
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
                record.add(number);
            }
        }



        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int i = 0; i < record.size(); i++){
                int num1 = record.get(i), num2 = value - num1;
                if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))){
                    return true;
                }
            }
            return false;
        }


    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

