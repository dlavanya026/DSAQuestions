package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class FrogJump {
    static int solve(int ind,int[] height,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOneCurr= solve(ind-1, height,dp);
        int currVal=Math.abs(height[ind]-height[ind-1]);
        System.out.println("jumpOneCurr :"+ jumpOneCurr);
        System.out.println("currVal :"+currVal);
        int jumpOne=jumpOneCurr+currVal;
        if(ind>1) {
            int jumpTwoCurr = solve(ind-2, height,dp);
            int currVal2=Math.abs(height[ind] - height[ind - 2]);
            System.out.println("jumpTwoCurr :"+ jumpTwoCurr);
            System.out.println("currVal2 :"+currVal2);
            jumpTwo=jumpTwoCurr+currVal2;
        }
        System.out.println("Jump 1 "+jumpOne+" and jump 2 "+jumpTwo);
        return dp[ind]=Math.min(jumpOne, jumpTwo);
    }


    public static void main(String args[]) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solve(n-1,height,dp));
        System.out.println(Arrays.toString(dp));
    }
}
