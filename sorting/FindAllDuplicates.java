package sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        int start=0;
        while(start<nums.length){
            int correct=nums[start]-1;
            if(nums[correct]!=nums[start]){
                swap(nums,start,correct);
            }else{
                start++;
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1){
                list.add(nums[index]);
            }
        }

        return list;
    }

    static void swap(int[] nums,int first,int last){
        int temp=nums[first];
        nums[first]=nums[last];
        nums[last]=temp;
    }

}
