package BinarySearchQuestions;//Find the first and last occurrence of a number

public class FirstAndLastPosition_4 {
    public static void main(String[] args) {
        int[] arr={5,7,7,7,7,8,8,10};
        int target=7;
        int[] ans={-1,-1};
        //First find first occurrence if found go for second or else return -1,-1;
        ans[0]=search(arr,target,true);
        if(ans[0]!=-1){
            ans[1]=search(arr,target,false);
        }
        System.out.println("First Occurance and Last Occurance :"+ans[0]+":"+ans[1]);
    }

    private static int search(int[] arr,int target,boolean isFirst){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>arr[mid]){
                start=mid+1;
            }else if(target<arr[mid]){
                end=mid-1;
            }else {
                ans=mid;
                if(isFirst){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }

        return ans;
    }
}
