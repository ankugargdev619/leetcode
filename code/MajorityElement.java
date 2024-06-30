class Solution {
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