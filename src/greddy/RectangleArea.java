package greddy;
/**
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 * Example:
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * Output: 16
 * https://leetcode.com/problems/rectangle-area/
 * Solution: Compute the area for both rectangles minus overlap area.
 * */
public class RectangleArea {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //calculate area for both rectangles
        int areaA = area(ax1, ax2, ay1, ay2);
        int areaB = area(bx1, bx2, by1, by2);

        //calculate overlap in x
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int overlapX = right -left;

        //calculate overlap in y
        int top= Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int overlapY = top - bottom;

        int areaOverlap = 0;
        //if the rectangles overlap each other, then calculate the area of the overlap
        if(overlapX>0 && overlapY> 0){
            areaOverlap = overlapX*overlapY;
        }
        return areaA + areaB - areaOverlap;
    }

    private static int area(int x1, int x2, int y1, int y2) {
        return (y2 - y1) * (x2 - x1);
    }

    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
/**
 * Complexity
 * Time: O(1)
 * Space: O(1)
 * */
