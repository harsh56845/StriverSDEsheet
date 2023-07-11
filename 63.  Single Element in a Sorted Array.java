// Leetcode Link :- https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/992020970/
class Solution {
    public int singleNonDuplicate(int[] nums) {
     int start=0,end=nums.length-1;
     while(start<end){
         int mid=(start+end)/2;
if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2==1 && nums[mid]==nums[mid-1]))
           start=mid+1;
         else end=mid;
     }
        return nums[start];
    }
}

// Coding Ninas :- https://www.codingninjas.com/studio/problems/single-element-in-a-sorted-array_8230826?challengeSlug=striver-sde-challenge&leftPanelTab=0
import java.util.ArrayList;

public class Solution {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size();
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Update low and high
            if (mid % 2 == 1) {
                int a = arr.get(mid);
                int b = arr.get(mid - 1);

                if (a == b) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else if (mid % 2 == 0) {
                int a = arr.get(mid);
                int b = arr.get(mid + 1);

                if (a == b) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return arr.get(low);
    }
}
