/**
 * LC 253 medium Heap/Greed/Sort
 */

import java.util.*;
import Util.Interval;
public class MeetingRooms2 {

    /***
     *
     * @param intervals
     * @return the minimum number needed in for the living room
     *
     * Pipeline :  Scan the starting and ending time
     * 1. Store the sorted starting time
     * 2. Store the sorted ending time
     * 3. if (ending time > starting) # needed room ++
     *
     * Time : O(NlogN)
     * Space : O(N)
     */

    public int minMeetingRooms(Interval[] intervals){
        if (intervals == null || intervals.length == 0 ) return 0;

        int[] starts = new int[intervals.length];
        int[] ends  = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        //Do not forget to sort
        Arrays.sort(starts);
        Arrays.sort(ends);

        int ans = 0, iEnd = 0;
        for (int i = 0; i < intervals.length; i++){
            if (starts[i] < ends[iEnd]) ans++;
            else iEnd++;
        }

        return ans;
    }


    /**
     *
     * @param intervals
     * @return
     *
     * Pipeline:
     * This method is use priority Queue
     * 1. Sort intervals according to start time
     * 2. Add the end time of first meeting to the pq
     * 3. if (starting time < QP.peek()) add new end time to the priority queue
     *    else qp.poll() and then add new endig time
     * */

    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        //This kind of Arrays.sort() needs to be remembered.
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b){
               return a.start - b.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length,(a,b)-> a - b);
        queue.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start >= queue.peek()){
                int tmp = queue.poll();
                //System.out.println(tmp);
            }
            queue.add(intervals[i].end);
        }
        return queue.size();
    }

    public static void main(String[] args){
        int[][] test = new int[][]{{7,10},{2,4}};
        Interval[] intervals = new Interval[test.length];
        for (int i = 0; i < test.length; i++){
            intervals[i] = new Interval(test[i][0], test[i][1]);
        }

        MeetingRooms2 example = new MeetingRooms2();
        System.out.println(example.minMeetingRooms2(intervals));
    }

}
