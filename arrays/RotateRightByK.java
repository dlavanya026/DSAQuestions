package arrays;
//https://leetcode.com/problems/rotate-array/description/
import java.util.Arrays;

public class RotateRightByK {

    public static void main(String[] args) {
        int[] nums={1,2};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        if(nums.length==0||nums.length==1){
            return;
        }
        int arrSize=nums.length;
        k=(k%arrSize);
        if(k<0){
            return;
        }
        reverse(nums,0,arrSize-1);
        reverse(nums,0,k-1);
        reverse(nums,k,arrSize-1);
    }

    static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

}
