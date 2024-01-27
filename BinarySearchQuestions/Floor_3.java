package BinarySearchQuestions;//Floor is greatest number smaller or equal to target
//same as floor just return end instead of start.

public class Floor_3 {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target=15;
        int floor=getFloor(arr,target);
        System.out.println("Floor is :"+floor);
    }

    private static int getFloor(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        if(target<arr[start]){
            return -1;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>arr[mid]){
                start=mid+1;
            }else if(target<arr[mid]){
                end=mid-1;
            }else{
                return arr[mid];
            }
        }

        return arr[end];
    }
}
