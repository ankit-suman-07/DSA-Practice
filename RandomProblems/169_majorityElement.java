/*
169. Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

// Method 1: (Boyer-Moore Voting Algorithm)
public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

// Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate; 
    }

// Method 2: (Bit-Manipulation)
public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = 0;

        for (int bit = 0; bit < 32; bit++) {
            int bitCount = 0; 

            for (int num : nums) {
                if ((num >> bit & 1) == 1) {
                    bitCount++;
                }
            }

            if (bitCount > n / 2) {
                majority |= (1 << bit);
            }
        }

        return majority;
    }

// Method 3:
public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(hmap.containsKey(nums[i])) {
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            } else {
                hmap.put(nums[i],1);
            }
        }

        int max = nums[0];
        int maxCount = 1;

        for(int keys: hmap.keySet()) {
            if(maxCount < hmap.get(keys)) {
                max = keys;
                maxCount = hmap.get(keys);
            }
        }

        return max;
    }
