
/*Calculate square of a number without using *, / and pow()
Difficulty Level : Medium
Last Updated : 23 Feb, 2021
Given an integer n, calculate the square of a number without using *, / and pow(). 

Examples : 

Input: n = 5
Output: 25

Input: 7
Output: 49

Input: n = 12
Output: 144*/
public class SquareOfNum {
    public static  void main(String[] args)
    {
        int n=10;
       int res= square(n);
       System.out.println(res);

       int res1=approach2(n);
       System.out.println(res1);

       int res2=approach3(n);
    }

    private static int approach3(int n) {
        return 0;
    }

    private static int approach2(int n) {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=n;
        }
        return sum;  //some how right but O(n) solution
    }

    private static int  square(int n) {
        int k = 2;
        int rtn = helperM(n, k);
        return rtn;
    }

    private static int helperM(int n, int k) {
        if(k==0) return 1;
        return  n*helperM(n,k-1);// here i have used * not allowed
    }
}
