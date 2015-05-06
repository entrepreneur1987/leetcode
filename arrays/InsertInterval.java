/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        boolean merged = false;
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(merged){
                ret.add(curr);
            }
            else{
                if(newInterval.end < curr.start){
                    ret.add(newInterval);
                    ret.add(curr);
                    merged = true;
                }
                else if(newInterval.start > curr.end){
                    ret.add(curr);
                }
                else{
                    newInterval.end = Math.max(newInterval.end, curr.end);
                    newInterval.start = Math.min(newInterval.start, curr.start);
                }
            }
        }
        if(!merged){
            ret.add(newInterval);
        }
        return ret;
    }
}
