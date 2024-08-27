class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, l, r);
    }

    private int countOnes(int n, long l, long r) {
        // Base case: S(1) = "11011"
        if (n == 1) {
            int[] bit = {1, 1, 0, 1, 1};
            int count = 0;
            for (long i = l; i <= r; i++) {
                if (bit[(int)(i - 1)] == 1) {
                    count++;
                }
            }
            return count;
        }

        // Calculate the length of S(n)
        long len = (long) Math.pow(5, n-1); // length of S(n-1)

        int result = 0;
        
        for (long i = l; i <= r; i++) {
            long pos = (i - 1) / len; // Determine which segment the position falls into
            long offset = (i - 1) % len + 1; // Calculate the position within the segment

            if (pos == 2) {
                // Middle segment, which is all 0s
                continue;
            } else {
                // Recursively count the ones in the respective segment
                result += countOnes(n - 1, offset, offset);
            }
        }

        return result;
    }
}
