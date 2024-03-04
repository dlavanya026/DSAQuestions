package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/permutations/
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
class PermutationArray {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> result = permute1(nums);
        for(List<Integer> li:result){
            System.out.println(Arrays.toString(li.toArray()));
        }
    }


    public static List<List<Integer>> permute1(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getPermutations(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    public static void getPermutations(List<List<Integer>> result, int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            result.add(current);
            return;
        }

        int currentValue = nums[index];
        for(int i = 0; i <= current.size(); i ++) {
            List<Integer> newList = new ArrayList<Integer>(current);
            newList.add(i, currentValue);
            getPermutations(result, nums, index + 1, newList);
        }
    }

}