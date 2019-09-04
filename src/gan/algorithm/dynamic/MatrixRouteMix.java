package gan.algorithm.dynamic;

/**
 * @Author Badribbit
 * @create 2019/4/17 21:50
 */

import sun.security.util.Length;

import java.util.Scanner;

/**
 * 求矩阵最小路径和。
 * 题目：矩阵只能从右走，或者从下走。输入一个矩阵，各个值表示了路径的值，求从左上方，走到右下最小路径和。
 * 核心思想：动态规划，因为第一行和第一列的值都已知，那么其他点的最小值都可以根据他们推导出来
 */
public class MatrixRouteMix {
    public static int getMixRoute(int[][] m){
        /**
         * 判断二维数组为空的方法
         */
        if (m == null || m.length == 0 || m[0]==null || m[0].length==0){
            return 0;
        }
        int row=m.length;
        int col=m[0].length;
        int [][] dp=new int[row][col];
        dp[0][0]=m[0][0];
        /**
         * 将第一行和一列的值相加到dp[][]中。
         * dp中存的是最小路径和
         * 为什么要把这两列加起来，因为只有这两行列的值是可以确定的，并且可以通过这两列推导出其他列的最小值
         */
        for (int i=1;i<col;i++){
            dp[0][i]=dp[0][i-1]+m[0][i];
        }
        for (int j=1;j<row;j++){
            dp[j][0]=dp[j-1][0]+m[j][0];
        }
        /**
         * 动态规划老套路两个for循环
         * dp[j][i]的值可以根据，dp[j-1][i]和dp[j][i-1]推导，选取最小的，然后加上原来的m[j][i]值
         * 最后就是最小值.
         */
        for (int j=1;j<row;j++){
            for (int i=1;i<col;i++){
                dp[j][i]=Math.min(dp[j-1][i],dp[j][i-1])+m[j][i];
            }
        }

        return  dp[row-1][col-1];
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("输入数组的行数和列数,用空格分开");
        int row=in.nextInt();
        int col=in.nextInt();
        int[][] m=new int[row][col];
        System.out.println("开始输入值");
        /**
         * java中换行可以无视，就是说如果一行数据输完了，可以直接换行
         * 不需要考虑因为换了行，而对输入有什么影响。
         */
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                m[i][j]=in.nextInt();
            }
        }
        int mix=getMixRoute(m);
        System.out.println("最小值为："+mix);
    }

}
