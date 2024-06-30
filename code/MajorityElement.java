/**
169. Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2 

Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 
Follow-up: Could you solve the problem in linear time and in O(1) space?
**/

class Solution1 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : nums){
            if(!count.containsKey(num)){
                count.put(num,0);
            }
            count.put(num,count.get(num)+1);
            if(count.get(num)>nums.length/2){
                majority = num;
                break;
            }
        }
        return majority;
    }
}

// Solution 2 : This is based on the intuition that the sorted array will have the majority element occupy the n/2 position
class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// Solution 3 : Moore voting method
class Solution3 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int vote = 0;
        for(int num:nums){
            if(num != majority){
                vote--;
                if(vote<1){
                    majority = num;
                    vote++;
                }
            } else{
                vote++;
            }
        }
        return majority;
    }
}