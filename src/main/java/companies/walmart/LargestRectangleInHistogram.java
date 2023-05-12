package companies.walmart;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));

        heights = new int[]{2, 4};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * Approach is to find the left next smallest and right next smallest element's indices.
     * Because a cell can expand both in left and right side till the element which is smallest to them.
     * Then the area can be found out by rightSmallestElementIndex - leftSmallestElementIndex - 1;
     * Ans = (rightSmallestElementIndex - leftSmallestElementIndex - 1) * cell value;
     */
    private static int largestRectangleArea(int[] heights) {
        final int[] leftSmallestIndices = new int[heights.length];
        final int[] rightSmallestIndices = new int[heights.length];

        Arrays.fill(leftSmallestIndices, -1);//first(0) element has no left  smallest
        Arrays.fill(rightSmallestIndices, heights.length);//last(n-1) element has no right smallest

        final Stack<Integer> leftStack = new Stack<>();
        final Stack<Integer> rightStack = new Stack<>();

        for (int i = 0, j = heights.length - 1; i < heights.length; i++, j--) {
            while (!leftStack.isEmpty() && heights[i] <= heights[leftStack.peek()]) {
                leftStack.pop();
            }

            if (!leftStack.isEmpty()) {
                leftSmallestIndices[i] = leftStack.peek();
            }

            leftStack.push(i);

            while (!rightStack.isEmpty() && heights[j] <= heights[rightStack.peek()]) {
                rightStack.pop();
            }

            if (!rightStack.isEmpty()) {
                rightSmallestIndices[j] = rightStack.peek();
            }

            rightStack.push(j);
        }

        //Finding the area
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rightSmallestIndices[i] - leftSmallestIndices[i] - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
