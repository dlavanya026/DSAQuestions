package sorting;
//https://leetcode.com/problems/find-the-duplicate-number/
class FindDupicate {
    public static void main(String[] args) {

    }
    public int findDuplicate(int[] nums) {
        int start=0;
        while(start<nums.length){
            int correct=nums[start]-1;
            if(nums[start]!=nums[correct]){
                swap(nums,start,correct);
            }else{
                start++;
            }
        }

        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1){
                return nums[index];
            }
        }
        return -1;
    }

    static void swap(int[] nums,int first,int last){
        int temp=nums[first];
        nums[first]=nums[last];
        nums[last]=temp;
    }
}