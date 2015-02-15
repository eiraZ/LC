/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Solution: same straight line: same slope
        corner case: (1)same position.
                    (2) points[j].x == points[i].x : 0.0, -0.0 different number

*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
  
  public int maxPoints(Point[] points) {
    if (points.length <= 2) return points.length;
    int res = 0;
    
    for (int i = 0; i<points.length; i++){
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int curMax = 1;
        int samePoint = 0;
        for (int j = i+1; j<points.length; j++){
            double slope = Double.MAX_VALUE;
            if (points[j].x != points[i].x){
                slope = ((points[j].y - points[i].y)) * 1.0 /((points[j].x - points[i].x) * 1.0);
                if(slope == -0.0){
                    slope = 0.0;
                }
            }else if(points[j].y == points[i].y){
                samePoint++;
                continue;
            }
            if (map.containsKey(slope)){
                map.put(slope, map.get(slope)+1);
            }else{
                map.put(slope, 2);
            }
            curMax = Math.max(curMax, map.get(slope));

        }
        res = Math.max(res, curMax + samePoint);
        
    }
    return res;
  }
