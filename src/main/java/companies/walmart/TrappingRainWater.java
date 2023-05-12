package companies.walmart;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
    }

    private static int trap(int[] heights) {
        //Finding right max array
        int[] rightMax = new int[heights.length];
        rightMax[rightMax.length - 1] = heights[heights.length - 1];//Set the right max of last element as the same

        for (int i = heights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
        }

        //Finding left max array
        /*int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];//Set the left max of start element as same

        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Math.max(heights[i], leftMax[i - 1]);
        }

        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += (Math.min(leftMax[i], rightMax[i]) - heights[i]);
        }*/

        //Finding left max on the fly
        int sum = 0;

        int leftMax = heights[0];
        for (int i = 1; i < heights.length; i++) {
            sum += Math.max(Math.min(leftMax, rightMax[i]) - heights[i], 0);
            leftMax = Math.max(leftMax, heights[i]);
        }

        return sum;
    }
}
