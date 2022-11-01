package scaler.searching;

/**
 * Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
 */
public class SortedInsertPosition {
    public static void main(String[] args) {
        int[] A = new int[]{3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993};
        int B = 902;

        System.out.println(searchInsert(A, B));
    }

    private static int searchInsert(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            ans = mid;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return B > A[ans] ? ans + 1 : ans;
    }
}
