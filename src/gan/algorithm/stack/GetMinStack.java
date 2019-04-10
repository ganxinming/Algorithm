package gan.algorithm.stack;

/**
 * @Author Badribbit
 * @create 2019/4/10 21:27
 */

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 1.pop，push，getMin操作复杂度都是O(1)。
 * 2.设计的栈类型可以使用现成的栈结构。
 */
/**
 * 思路：设计两个栈，stackDate用来存数据，stackMin用来存最小值
 * 入栈：stackDate正常操作stack，stackMin有点特殊，
 *      它的设计思路是：每次插入时值时比较栈顶值，如果小于，说明插入值为新最小值插入，如果大于，则栈顶插入原来栈顶的最小值。
 *出栈：在出栈时，需要两个栈都得出栈。
 * 总结：stackMin存的值虽然有重复的（费空间），但是取值时，省时间。
 */

public class GetMinStack {
    private Stack<Integer> stackDate;
    private Stack<Integer> stackMin;

    public GetMinStack() {
        this.stackDate=new Stack<>();
        this.stackMin=new Stack<>();
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(value);
        }
        else{
            if (this.stackMin.peek()>=value){
                this.stackMin.push(value);
            }
            else{
                this.stackMin.push(this.getMin());
            }
        }
        this.stackDate.push(value);
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (this.stackDate.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        this.stackMin.pop();
        return this.stackDate.pop();

    }

    /**
     * 获得最小值
     * @return
     */
    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack=new GetMinStack();
        stack.push(12);
        stack.push(11);
        stack.push(13);
        stack.push(1);
        stack.push(5);
        stack.push(5);
        stack.push(6);
        stack.push(12);
       while(true){
           System.out.println("栈顶值是"+stack.pop());
           System.out.println("最小值是"+stack.getMin());
       }
    }
}
