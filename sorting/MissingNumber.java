package sorting;


class MissingNumber {
    public static void main(String[] args) {
        int[] nums={9,6,4,2,3,5,7,0,1};
        int missingNum=missingNumber(nums);
        System.out.println(missingNum);
    }
    public static int missingNumber(int[] nums) {
        int start=0;
        while(start<nums.length){
            int correct=nums[start];
            if(nums[start]<nums.length && nums[start]!=nums[correct]){
                swap(nums,start,correct);
            }else{
                start++;
            }
        }

        //search for missing number
        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index){
                return index;
            }
        }
        return nums.length;
    }

    static void swap(int[] nums,int first,int last){
        int temp=nums[first];
        nums[first]=nums[last];
        nums[last]=temp;

    }
}