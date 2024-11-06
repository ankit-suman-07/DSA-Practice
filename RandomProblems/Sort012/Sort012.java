package RandomProblems.Sort012;

import java.util.Arrays;

/*
Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.

Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
 */
public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort012(int[] arr) {
        // code here
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int temp = 0;

        while(b <= c) {

            if(arr[b] == 0) {
                temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;

                a++;
                b++;
            }
            else if(arr[b] == 2) {
                temp = arr[c];
                arr[c] = arr[b];
                arr[b] = temp;

                c--;
            } else {
                b++;
            }

        }
    }
}
