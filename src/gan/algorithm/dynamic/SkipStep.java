package gan.algorithm.dynamic;

/**
 * @Author Badribbit
 * @create 2019/4/17 22:34
 */

/**
 * 题目1：跳台阶，一次跳1阶，或者一次跳2阶（n为台阶数）
 * 题目2：跳台阶，一次跳1阶，或者跳2阶，或者n阶（n为台阶数）
 */

/**
 * 核心思想：递归，1.当为n阶台阶时，跳到n阶前有两种方式，在n-1时跳一下，在n-2时跳两下。所以f(n)=f(n-1)+f(n-2);
 * 2.相同思想：但是此时变了因为有n种跳法，f(n)=f(n-1)+f(n-2)+...+f(2)+f(1).如果是这个式子就没法算了，又不能递归
 * 那么f(n-1)=f(n-2)+...+f(2)+f(1)，我们发现f(n)=2*f(n-1);
 */
public class SkipStep {

    public static int Skip1(int n){
        if (n<=0){
            return  0;
        }
        if (n <= 2){
            return n;
        }

        return  Skip1(n-1)+Skip1(n-2);
    }

    public static int Skip2(int n){
        if (n<=0){
            return  0;
        }
        if (n <= 2){
            return n;
        }

        return  2*Skip2(n-1);
    }
}
