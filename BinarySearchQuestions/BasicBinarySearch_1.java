package BinarySearchQuestions;

public class BasicBinarySearch_1 {
    public static void main(String[] args) {
        int[] arr={10,15,18,25,36,45,89};
        int target=45;
        int indexOfTarget= binarySearch(arr,target);
        System.out.println(indexOfTarget);
    }

    private static int binarySearch(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=end-(end-start)/2;
            if(arr[mid]>target){
                end=mid-1;
            }else if(arr[mid]<target){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
