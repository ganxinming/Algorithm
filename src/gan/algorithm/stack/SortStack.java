package gan.algorithm.stack;

import java.util.Stack;

/**
 * @Author Badribbit
 * @create 2019/4/11 23:09
 */
public class SortStack {

    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help=new Stack<>();

        while (!stack.isEmpty()){
            int value=stack.pop();
            if (!help.isEmpty() && help.peek() < value){
                stack.push(help.pop());
            }
            help.push(value);

        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(2);
        stack.push(9);
        stack.push(8);
        stack.push(6);
        SortStack.sortStack(stack);
        while (true){
            System.out.println(stack.pop());
        }
    }

}
