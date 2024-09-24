package TwoPointer;

import java.util.Arrays;

/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum is equal to the target,
 that is, nums[i] + nums[j] + nums[k] == target.
 Return TRUE if three such integers exist in the array. Otherwise, return FALSE.


 */
public class ThreeSumEqualsK {
    public static void main(String[] args) {
        int[] arr={3,7,1,2,8,4,5};
        boolean ans = findSumOfThree(arr,20);
        System.out.println(ans);

    }
    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(findSum(target-nums[i],nums,i+1))
                return true;
        }
        // Replace this placeholder return statement with your code
        return false;
    }

    public static boolean findSum(int target,int[] nums,int index){
        int left = index;
        int right = nums.length - 1;
        int sum=0;
        while (left < right){
            sum=nums[left]+nums[right];
            if(target==sum){
                return true;
            }else if(sum>target){
                right = right -1;
            }
            else{
                left = left + 1;
            }
        }
        return false;
    }
}
