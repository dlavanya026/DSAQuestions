package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {

    public static int getMajorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if(majority ==nums[i]){
                count = count + 1;
            }else{
                count = count - 1;
            }
        }

        return majority;

    }


    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = getMajorityElement(arr);
        System.out.println("The majority element is: " + ans);
        Arrays.asList(arr);
    }

}
