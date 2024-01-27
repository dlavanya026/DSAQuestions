package BinarySearchQuestions;

//Ceiling --> Find smallest element in array that is greater or equal to target.
//At the end of the
public class Ceiling_2 {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target=15;
        int ceiling=getCeiling(arr,target);
        System.out.println("Ceiling is : "+ceiling);
    }

    private static int getCeiling(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        if(target>arr[end])
            return -1;
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
        return arr[start];
    }
}
