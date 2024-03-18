package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/
/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.


Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

 */
public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums={4,2,1,1};
        List<Integer> list1=getMajorityElement(nums);
        list1.forEach(System.out::print);
    }

    public static List<Integer> getMajorityElement(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        Integer majority1 = null;
        Integer majority2=null;
        int count1 = 0;
        int count2 = 0;

        for (int i = 1; i < nums.length; i++) {
            if (count1 == 0) {
                majority1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = nums[i];
                count2 = 1;
            } else if(majority1 ==nums[i]){
                count1 = count1 + 1;
            }else if(majority2 ==nums[i]){
                count2= count1 + 1;
            }else{
                count1 = count1 - 1;
                count2 = count1 - 1;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (majority1 != null && nums[i] == majority1) {
                count1 ++;
            }
            if (majority2 != null && nums[i] == majority2) {
                count2 ++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(majority1);
        }
        if (count2 > nums.length / 3) {
            list.add(majority2);
        }
        return list;
    }
}
