package Recurssion;

public class SumOfDigits{
    public static void main(String[] args) {
           int sum= getSum(1345);
           System.out.println(sum);
    }

    public static int getSum(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+getSum(n/10);
    }
}
