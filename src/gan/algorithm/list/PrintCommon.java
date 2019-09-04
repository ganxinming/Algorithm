package gan.algorithm.list;
/**
 * @Author Badribbit
 * @create 2019/4/15 22:09
 */

/**
 * 打印两个(有序)链表相同的值
 */
public class PrintCommon {

    public static void printCommonNode(Node node1,Node node2){
        /**
         * 不断向下循环，如果
         * 1.node1.value<node2.value，则node1=node1.next;因为它是有序的
         * 2.如果相等，则赋给下个一个
         */
        while (node1 != null && node2 != null){
            if (node1.value<node2.value){
                node1=node1.next;
            }
            if (node1.value >node2.value){
                node2=node2.next;
            }
            if (node1.value == node2.value){
                System.out.println(node1.value);
                node1=node1.next;
                node2=node2.next;
            }

        }
    }

    public static void main(String[] args) {
        Node node1=new Node(5);
        node1.next=new Node(6);
        node1.next.next=new Node(7);

        Node node2=new Node(4);
        node2.next=new Node(6);
        node2.next.next=new Node(7);
        PrintCommon.printCommonNode(node1,node2);
    }


}
