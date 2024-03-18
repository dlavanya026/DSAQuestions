package sorting;
//https://leetcode.com/problems/first-missing-positive/
class MissingPositive {
    public int firstMissingPositive(int[] nums) {
        int start=0;
        while(start<nums.length){
            int correct=nums[start]-1;
            if(nums[start]>0 && nums[start] <=nums.length && nums[correct]!=nums[start]){
                swap(nums,start,correct);
            }else{
                start++;
            }
        }

        for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1){
                    return i+1;
                }
            
        }

        return nums.length+1;
    }

    static void swap(int[] nums,int first,int last){
        int temp=nums[first];
        nums[first]=nums[last];
        nums[last]=temp;
    }
}