package BinarySearchQuestions;

public class BasicBinarySearch_1 {
    public static void main(String[] args) {
        int[] arr={10,15,18,25,36,45,89};
        int[] arr1 = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};

        int target=22;
        int indexOfTarget= binarySearch(arr1,target);
        System.out.println(arr1[indexOfTarget]);
    }


    private static int binarySearch(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(target>arr[mid]){
                start=mid+1;
            }
            else if(target<arr[mid]){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
