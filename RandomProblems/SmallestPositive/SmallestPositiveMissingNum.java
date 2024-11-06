package RandomProblems.SmallestPositive;

/*
You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.

Examples:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.
 */
public class SmallestPositiveMissingNum {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 5, 1};
        System.out.println(missingNumber(arr));
    }
    static int missingNumber(int[] arr) {
        // Your code here
        int n = arr.length;
        int[] out = new int[n+1];
        for(int i=0; i<=n; i++) {
            out[i] = 0;
        }

        for(int i=0; i<n; i++) {
            if(arr[i] > 0 && arr[i] <= n) {
                out[arr[i]] = -1;
            }
        }

        for(int i=1; i<=n; i++) {
            if(out[i] == 0) {
                return i;
            }
        }
        return n+1;
    }
}
