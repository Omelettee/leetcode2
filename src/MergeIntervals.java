/***
 * LC 56 medium Array Sort
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import Util.*;
import java.util.*;

public class MergeIntervals {


    /**
     * This method is from CSpiration, which is called 扫描线做法
     * @param intervals
     * @return
     *
     * Time : O(nlogn) Space: O(n)
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        List<Interval> ans = new ArrayList<>();
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        int start = intervals.get(0).start, end = intervals.get(0).end;

        for (Interval interval : intervals){
            if (interval.start <= end){ // needs to be merged
                end = Math.max(end, interval.end);
            } else { // No need to be merged
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }

}
