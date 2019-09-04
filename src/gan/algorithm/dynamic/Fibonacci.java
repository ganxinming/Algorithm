package gan.algorithm.dynamic;

/**
 * @Author Badribbit
 * @create 2019/4/17 21:43
 */
public class Fibonacci {
    /**
     * 递归版本：斐波那契
     * @param n
     * @return
     */
    public int f1(int n){

        if (n<1){
            return 0;
        }
        if (n<=2){
            return  1;
        }

        return f1(n-1)+f1(n-2);
    }

    /**
     * 非递归版本：斐波那契
     * @param n
     * @return
     */
    public int f2(int n){
        if (n<1){
            return 0;
        }
        if (n<=2){
            return  1;
        }
        int pre=1;
        int next=1;
        int sum=0;
        for (int i=3;i<=n;i++){
            sum=pre+next;
            pre=next;
            next=sum;
        }
        return sum;
    }
}
