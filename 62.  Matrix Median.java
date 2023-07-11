// Coding Ninjas Lnk  :- https://www.codingninjas.com/studio/problems/matrix-median_8230735?challengeSlug=striver-sde-challenge&leftPanelTab=1
import java.util.ArrayList;

public class Solution {
    public static int countSmallerEquals(ArrayList<Integer> row, int mid) {
        int l = 0;
        int h = row.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (row.get(m) <= mid) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int low = 1;
        int high = 1000000009;
        int n = matrix.size();
        int m = matrix.get(0).size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += countSmallerEquals(matrix.get(i), mid);
            }
            if (cnt <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
