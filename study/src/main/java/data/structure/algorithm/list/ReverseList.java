package data.structure.algorithm.list;

/**
 * @author luxiaofeng
 */
public class ReverseList {

    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        node.setNext(node1);
        Node node2 = new Node(3);
        node1.setNext(node2);
        Node node3 = new Node(4);
        node2.setNext(node3);
        Node node4 = new Node(5);
        node3.setNext(node4);
        node4.setNext(null);

        System.out.println("反转之前输出");
        Node temp = node;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }

        System.out.println("反转之后输出");
        Node node5 = reverseListNode(node);

        while (node5 != null){
            System.out.println(node5.data);
            node5 = node5.next;
        }

    }

    private static Node reverseListNode(Node head){
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.getNext() == null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null){

            //nextNode 指向下一个节点
            nextNode = curNode.getNext();
            //将当前节点next域指向前一个节点
            curNode.setNext(preNode);
            //preNode 指针向后移动
            preNode = curNode;
            //curNode指针向后移动
            curNode = nextNode;
        }

        return preNode;
    }


    static class Node{

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
