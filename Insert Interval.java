/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Solution: find a place we start to insert. merge if necessary.
          merge condition: in.start<= newInterval.end && in.end >=newInterval.start
          
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<Interval>();
    if(newInterval == null ) return intervals;
    if (intervals == null || intervals.size() ==0 ){
        res.add(newInterval);
        return res;
    }
    //search start point
int index = 0;
    for (int i = 0; i< intervals.size(); i++){
        Interval in = intervals.get(i);
        if (in.end >= newInterval.start){
            index = i;
            break;
        }
        res.add(in);
        index++;
    }
    
    //merge
    for(; index < intervals.size() && intervals.get(index).start <= newInterval.end; index++){
        newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(index).end);
    }
    res.add(newInterval);
    
    //copy
    while (index < intervals.size()){
        res.add(intervals.get(index));
        index++;
    }
    
    return res;
    
 }
 
 public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        //Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null ||intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        boolean inserted = false;
        
        for(Interval in: intervals){
            if(inserted|| in.end < newInterval.start){
                res.add(in);
            }else if(in.start > newInterval.end){
                res.add(newInterval);
                res.add(in);
                inserted = true;
            }else{
                newInterval.start = Math.min(in.start, newInterval.start);
                newInterval.end = Math.max(in.end, newInterval.end);
            }
        }
        if(!inserted){
            res.add(newInterval);
        }
        
        return res;
        
        
    }
