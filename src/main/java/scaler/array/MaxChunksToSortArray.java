package scaler.array;

/**
 * Problem Description
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * Output Format
 * Return the maximum number of chunks that we could have made.
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 0]
 * Input 2:
 * A = [2, 0, 1, 3]
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 2
 * <p>
 * Example Explanation
 * Explanation 1:
 * A = [1, 2, 3, 4, 0]
 * To get the 0 in the first index, we have to take all elements in a single chunk.
 * Explanation 2:
 * A = [2, 0, 1, 3]
 * We can divide the array into 2 chunks.
 * First chunk is [2, 0, 1] and second chunk is [3].
 */
public class MaxChunksToSortArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 0};
        System.out.println(solve(A));
        System.out.println(solveEasy(A));

        A = new int[]{2, 0, 1, 3};
        System.out.println(solve(A));
        System.out.println(solveEasy(A));

        A = new int[] {4, 0, 6, 5, 1, 2, 7, 10, 9, 3, 8, 11, 13, 17, 12, 14, 15, 16, 18, 19, 20, 25, 21, 22, 28, 23, 24, 29, 26, 27, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 42, 40, 41, 46, 43, 44, 45, 47, 48, 49, 50, 52, 51, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 82, 80, 81, 83, 84, 85, 86, 87, 89, 88, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 145, 143, 144, 146, 147, 148, 149, 150, 153, 151, 152, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 176, 173, 174, 175, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 228, 225, 226, 227, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 283, 279, 280, 281, 282, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 300, 297, 298, 299, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 326, 322, 323, 324, 325, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417};
        System.out.println(solve(A));
        System.out.println(solveEasy(A));
    }

    private static int solveEasy(int[] A) {
        int count = 0, max = 0, i = 0;

        for (int num: A) {
            max = Math.max(max, num);
            if (max == i) {
                count++;
            }
            i++;
        }
        return count;
    }

    private static int solve(int[] A) {
        int count = 0;
        long chunkSum = 0;
        long previousChunkSum = 0;

        for (int i = 0; i < A.length; i++) {
            chunkSum += A[i];
            //Check the sum
            long sum = (((long) i * ((long)i + 1)) / 2) - previousChunkSum;

            if (sum == chunkSum) {
                count++;
                chunkSum = 0;
                previousChunkSum += sum;
            }
        }

        return count;
    }
}
