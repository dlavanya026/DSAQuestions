package Backtracking;
//https://leetcode.com/problems/next-permutation/description/
/*
Algorithm / Intuition
The steps are the following:

Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
So, in this case, we will reverse the whole array and will return it as our answer.
If a break-point exists:
Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.

 */
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int index=-1;
        int arraySize=nums.length;
        int revEndIndex=arraySize-1;
        int  revStartIndex=0;
        //get the index of drop
        for(int n= arraySize-2;n>=0;n--){
            if(nums[n]<nums[n+1]){
                index=n;
                break;
            }

        }

        //I want to find out the least max value which is greater than index value
        if(index!=-1){
            for(int i=arraySize-1;i>index;i--){
                if(nums[i]>nums[index]){
                    int temp=nums[index];
                    nums[index]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }

            revStartIndex=index+1;

        }

        //if index is not found then the permuatation is at its greatest level so just reverse it.
        getArrayReverse(nums,revStartIndex,nums.length-1);

    }

    private static void getArrayReverse(int[] nums, int start, int end) {
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;

        }
    }
}
