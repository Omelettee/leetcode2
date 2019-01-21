/***
 * LC 621 medium greedy
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 *
 * Note:
 *
 *     The number of tasks is in the range [1, 10000].
 *     The integer n is in the range [0, 100].
 */

import java.util.*;
public class TaskScheduler {


    // this is inspired by huahua's vedio and the solution 3 in the leetcode
    public int leastInterval(char[] tasks, int n) {

        if (tasks == null || tasks.length == 0) return 0;

        int sum = tasks.length;
        int[] record = new int[26];
        for (char task : tasks) record[task - 'A']++;
        Arrays.sort(record);
        int p = 0;
        int max = record[25];
        for (int count : record){
            if(count == max) p++;
        }
        int expected = (max - 1) * (n+1) + p;
        return Math.max(expected, sum);
    }
}
