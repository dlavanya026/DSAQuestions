package BinarySearchQuestions;

/*
Mountain arr is increasing and decresing max num is peak
arr = 0 1 0 O/P = 1
arr= 0 2 1 0 O/p =2
arr=1 2 3 4 5 6 4 3 2 O/P=6
We are trying ti move end to the largest number and start to the largest number by using if conditions thats y they
both meet at one point [Peek element]
 */
public class PeakIndexInMountainArray_5 {
    public static void main(String[] args) {
        int[] arr={1,2,3,5,6,4,3,2};
        int peek=findPeek(arr);
        System.out.println("Peek is :"+peek);
    }

    private static int findPeek(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                    end=mid;
            }else if(arr[mid]<arr[mid+1]){
                    start=mid+1;
            }
        }
        return start;
    }
}
