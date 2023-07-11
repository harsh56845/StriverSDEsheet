// Coding Ninjas Lnk :- https://www.codingninjas.com/studio/problems/find-nth-root-of-m_8230799?challengeSlug=striver-sde-challenge&leftPanelTab=0


public class Solution {
    public static int NthRoot(int n, int m) {
        if(n == 1 || m == 1) return m;

        int low = 1, high = m;

        while(low <= high){
            int mid = (low + high) >> 1;

            long mult = (long)Math.pow(mid, n); 
            // power(mid, n);

            if(mult == m) return mid;
            if(mult < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
