package companies.microsoft;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));

        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));

        System.out.println(computeArea(-2, -2, 2, 2, 3, 3, 4, 4));

        System.out.println(computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
    }

    private static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        long areaA = (long) Math.abs(ax1 - ax2) * (long) Math.abs(ay1 - ay2);
        long areaB = (long) Math.abs(bx1 - bx2) * (long) Math.abs(by1 - by2);

        int ix1 = Math.min(ax2, bx2);
        int iy1 = Math.min(ay2, by2);

        int ix2 = Math.max(ax1, bx1);
        int iy2 = Math.max(ay1, by1);

        long areaIntersection = (long) Math.max(ix1 - ix2, 0) * (long) Math.max(iy1 - iy2, 0);

        return (int) ((areaA + areaB) - areaIntersection);
    }
}
