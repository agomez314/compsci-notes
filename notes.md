### 76. Minimum Window Substring
This looks like a sliding window problem. It is asking for a minimum "window," which gives the problem type away. It is asking for an O(n) time complexity so no brute force can be done, or backtracking. 

What I think I can do is to do the usual sliding window template. the condition to fulfill is to have all characters in string T to be used up, and take the length of that new string (or distance between indices).

I wonder if string T will have no duplicate characters. If so, I can easily use a Set. Otherwwise I need another way to check the character. I'll assume there are no duplicates.

---
I did not solve this problem on time. I got stuck on the condition that the problem needs to fulfill to grow/shrink the window.


### 392. Is Subsequence
My first thought was to use a hashmap to count the number of characters in the string that it is going to be checking against. However, I realized that the order in which they appear is also important. So I thought of using a list/queue to keep track of the string. 
Finally, when looking at the solution, I realized I didn't need an outside data structure, instead using a **two-pointer** approach.

This had the added benefit of keeping the running time O(n) while space being constant.
```
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int s_index = 0;
        for (int t_index = 0; t_index < t.length(); t_index++) {
            if (s.charAt(s_index) == t.charAt(t_index))
                s_index++;
            if (s_index == s.length())
                return true;
        }
        return false;
    }
}
```

### 459. Repeated Substring Pattern
~~Strategy is to iterte over the string. Take the first charcater and see if it repeats,  if not, expand window to two characters, then three, until the length of the substring is half the length of the string. If it reaches past that then it is not a substring.~~

Start with half of the string. If the substring from 0 to i (which starts at half) is divisible by 2, then proceed. Take a substring from 0 to i and append it n (length of string / i) number of times. If the resulting string is the same as the original string, then it is a substring.


### 581. Shortest Unsorted Continuous Subarray
For this one I am going with a two pointer approach with sorting. I will take the subarray between i and j, sort it, then append it to the rest of the array. Then I will compare this array sorted to the original array sorted. If its the same then output true.

Another, simpler approach, is to make a copy cpy_nums, and sort it. Then iterate over the nums. If nums[i] != cpy_nums[i], then mark that. the minimum number is where the array is not sorted, the maximum number where it's not is where the unsorted array ends. Subtract the indexes to get the length of the unsorted array. Time: O(nlogn). Space: O(n)
```
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        int[] nums_sorted = nums.clone();
        Arrays.sort(nums_sorted);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums_sorted[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right > left ? right - left + 1 : 0;
    }
}
```

### 567. Permutation in String
To solve this, I would create all the permutations of S1. then I would iterate over S2 s1.length! times until I can find the substring. The running time is O(n!) To