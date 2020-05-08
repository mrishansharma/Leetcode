/*
* Check If It Is a Straight Line
* You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
* Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
* Output: true 
* Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
* Output: false
* Constraints:
* 2 <= coordinates.length <= 1000
* coordinates[i].length == 2
* -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
* coordinates contains no duplicate point.
*/
class Solution {
    double slope(int x1, int y1, int x2 , int y2)
    {
        return((1.0*y2-y1)/(x2-x1));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        double base_slope = slope(coordinates[0][0],coordinates[0][1],coordinates[1][0],coordinates[1][1]);
        for(int i=2;i<coordinates.length;i++)
        {
            if(base_slope != slope(coordinates[i-1][0],coordinates[i-1][1],coordinates[i][0],coordinates[i][1]))
            {
                return false;
            }
        }
        return true;
    }
}