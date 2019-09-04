package gan.algorithm.stack;

import java.util.Stack;

/**
 * @Author Badribbit
 * @create 2019/4/11 18:52
 */

/**
 * 题目：如何仅用递归函数和栈操作逆序一个栈
 * 例如：放入12345，逆序后，栈中变为54321
 *
 */

/**
 * 思路：两个递归函数
 * 1.一个实现将栈底元素取出来
 * 2.将取出来的栈底元素，递归压入
 * 比如：通过递归函数1，取得栈底元素1，但是1要压入栈顶，就必须递归压入（让其他元素先压入）。
 */
public class RecursiveStack {
    /**
     * 取出栈底元素
     * @param stack
     * @return
     */
    public int getEndValue(Stack<Integer> stack){
        int value=stack.pop();
        if (stack.isEmpty()){
            return value;
        }
        else{
            int valueEnd=getEndValue(stack);
            stack.push(value);
            return  valueEnd;
        }
    }

    /**
     * 将取出的栈底元素压入
     * @param stack
     */
    public void reserve(Stack<Integer> stack){

        if (stack.isEmpty()){
            return;
        }
        int value=getEndValue(stack);
        reserve(stack);
        stack.push(value);
    }

    public static void main(String[] args) {
        RecursiveStack recursiveStack=new RecursiveStack();
        Stack<Integer> intStack=new Stack();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        recursiveStack.reserve(intStack);

        while(true){
            System.out.println(intStack.pop());
        }
    }
}
