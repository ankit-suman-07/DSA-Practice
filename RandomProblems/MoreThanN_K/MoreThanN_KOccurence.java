package RandomProblems.MoreThanN_K;

import java.util.HashMap;

/*
Given an array arr of size N and an element k. The task is to find the count of elements in the array that appear more than n/k times.

Example 1:

Input:
N = 8
arr = [3,1,2,2,1,2,3,3]
k = 4
Output:
2
Explanation:
In the given array, 3 and 2 are the only elements that appears more than n/k times.
 */
public class MoreThanN_KOccurence {
    public static void main(String[] args) {
        int[] arr = {3,1,2,2,1,2,3,3};
        System.out.println(countOccurence(arr, arr.length, 4));
    }
    static int countOccurence(int[] arr, int n, int k)
    {
        // your code here,return the answer
        HashMap<Integer, Integer> newArr = new HashMap<>();
        int count = 0;

        // Populate the hashmap with the count of each element
        for (int i = 0; i < n; i++) {
            newArr.put(arr[i], newArr.getOrDefault(arr[i], 0) + 1);
        }

        // Calculate the threshold
        int threshold = n / k;

        // Count elements that appear more than n/k times
        for (Integer value : newArr.values()) {
            if (value > threshold) {
                count++;
            }
        }

        return count;
    }
}
