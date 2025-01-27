/**274. H-Index
Hint
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:
Input: citations = [1,3,1]
Output: 1
 

Constraints:
n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
**/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = citations.length;
        if(citations.length==1){
            if(citations[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        for(int i=0;i<citations.length;i++){
            if(citations[i]<hIndex){
                hIndex--;
            }
        }

        return hIndex;
    }
}

// Another approach but with higher run time
class Solution {
    public int hIndex(int[] citations) {
        int hIndex= 0;
        int[] nums = new int[citations.length];
        for(int i=0;i<citations.length;i++){
            int max = citations[i]>citations.length ? citations.length : citations[i];
            for(int j= 0;j<max;j++){
                nums[j] +=1;
            }
        }

        for(int i= nums.length-1;i>=0;i--){
            if(nums[i]==i+1 || nums[i]>i+1){
                return i+1;
            }
        }
        
        return hIndex;
    }
}

