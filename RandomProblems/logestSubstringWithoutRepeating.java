/*
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

// Method 1:
public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        Set<Character> hset = new HashSet<>();

        for(int end = 0; end <s.length(); end++) {
            while(hset.contains(s.charAt(end))) {
                hset.remove(s.charAt(start));
                start++;
            }
            hset.add(s.charAt(end));
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

// Method 2: 
public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        Set<Character> hset = new HashSet<>();

        for(int end = 0; end <s.length(); end++) {
            if(hset.contains(s.charAt(end))) {
                hset.remove(s.charAt(start));
                start++;
                end--;
                continue;
            }
            
            hset.add(s.charAt(end));
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

// Efficient:
public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        boolean[] hset = new boolean[128];

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            while (hset[currentChar]) {
                hset[s.charAt(start)] = false;
                start++;
            }
            hset[currentChar] = true;
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
