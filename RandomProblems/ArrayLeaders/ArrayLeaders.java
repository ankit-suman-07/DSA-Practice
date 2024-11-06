package RandomProblems.ArrayLeaders;

import java.util.ArrayList;

/*
You are given an array arr of positive integers. Your task is to find all the leaders in the array.
An element is considered a leader if it is greater than or equal to all elements to its right.
The rightmost element is always a leader.

        Examples:

        Input: arr = [16, 17, 4, 3, 5, 2]
        Output: [17, 5, 2]
        Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.

        Input: arr = [10, 4, 2, 4, 1]
        Output: [10, 4, 4, 1]
        Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
 */
class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr));
    }

    static ArrayList<Integer> leaders(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> output = new ArrayList<Integer>(n);

        int MAX = arr[n - 1];
        output.add(arr[n-1]);

        for(int i = n-2; i>=0; i--) {
            if(arr[i] >= MAX) {
                output.add(0, arr[i]);
                MAX = arr[i];
            }
        }
        return output;
    }
}