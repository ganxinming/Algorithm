package gan.algorithm.dynamic;

/**
 * @Author Badribbit
 * @create 2019/4/18 22:23
 */

import java.util.Scanner;

/**
 *给定数组arr，arr中的所有值都为正数，且不重复，每个值代表一种面值的货币，每种货币可以使用任意张。
 * 在给定一个target，求组成target的最少货币数。
 */
public class MoneyNumber {
    /**
     * 二维的动态规划数组
     * @param arr
     * @param target
     * @return
     */
    public static int getMoneyMixNumber(int[] arr,int target){
        if (arr.length==0 || arr == null || target < 0){
            return -1;
        }
        int row=arr.length;
        int col=target+1;
        int[][] dp=new int[row][col];
        int max=Integer.MAX_VALUE;
        /**
         * 赋值：将第一行的能换的钱换
         */
        for (int i=1;i<col;i++){
            dp[0][i]=max;
            if (i-arr[0] >= 0 && dp[0][i-arr[0]]!=max){
                dp[0][i]=dp[0][i-arr[0]]+1;
            }

        }
        /**
         * 老方法，动态规划循环。
         */
        for (int j=1;j<row;j++){
            for (int i=1;i<col;i++){
               int  temp=max;
                if (i-arr[j] >= 0 && dp[j][i-arr[j]]!=max){
                    temp=dp[j][i-arr[j]]+1;
                }
                dp[j][i]=Math.min(temp,dp[j-1][i]);
            }

        }

        return  dp[row-1][col-1]!=max ? dp[row-1][col-1] : -1;

    }

    /**
     * 一维动态规划数组
     * @param arr
     * @param target
     * @return
     */
    public static int getMoneyMixNumber1(int[] arr,int target){
        if (arr.length==0 || arr == null || target < 0){
            return -1;
        }
        int row=arr.length;
        int col=target+1;
        int[] dp=new int[col];
        int max=Integer.MAX_VALUE;
        /**
         * 赋值：将第一行的能换的钱换
         */
        for (int i=1;i<col;i++){
            dp[i]=max;
            if (i-arr[0] >= 0 && dp[i-arr[0]]!=max){
                dp[i]=dp[i-arr[0]]+1;
            }

        }
        /**
         * 老方法，动态规划循环。
         */
        for (int j=1;j<row;j++){
            for (int i=1;i<col;i++){
                int  temp=max;
                if (i-arr[j] >= 0 && dp[i-arr[j]]!=max){
                    temp=dp[i-arr[j]]+1;
                }
                dp[i]=Math.min(temp,dp[i]);
            }

        }

        return dp[target] != max ? dp[target] : -1;

    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("输入数组的容量：");
        int length=in.nextInt();
        int[] arr=new int[length];
        for (int i=0;i<length;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("输入总钱数target");
        int target=in.nextInt();
        int mix=getMoneyMixNumber1(arr,target);
        System.out.println("最少的钱方法"+mix);
    }
}
