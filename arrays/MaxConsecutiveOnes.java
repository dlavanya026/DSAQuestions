package arrays;
//https://leetcode.com/problems/max-consecutive-ones/description/
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int maxCount=findMaxConsecutiveOnes(nums);
        System.out.println(maxCount);

    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count=0;
        int maxCount=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                count=0;
            }
            maxCount=Math.max(count,maxCount);
        }

        return maxCount;

    }

}
