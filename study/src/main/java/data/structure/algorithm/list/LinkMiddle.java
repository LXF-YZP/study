package data.structure.algorithm.list;

/**
 * @Author yuezp
 * @Date 2019/9/26 5:42 下午
 * @Version v1.0
 */
public class LinkMiddle{




    public static void main(String[] args) {
        LinkNode linkNode1 = new LinkNode("1");
        LinkNode linkNode2 = new LinkNode("2");
        LinkNode linkNode3 = new LinkNode("3");
        LinkNode linkNode4 = new LinkNode("4");
        LinkNode linkNode5 = new LinkNode("5");
        LinkNode linkNode6 = new LinkNode("6");
        linkNode1.setNext(linkNode2);
        linkNode2.setNext(linkNode3);
        linkNode3.setNext(linkNode4);
        linkNode4.setNext(linkNode5);
        linkNode5.setNext(linkNode6);
        LinkNode mid =  findMiddleNode(linkNode1);
        System.out.println(mid);

        System.out.println("------------------------");

        LinkNode linkNode = reverseList(linkNode1);
        while (linkNode != null){
            System.out.println(linkNode.getData());
            linkNode = linkNode.next;
        }
    }


    //反转链表
    private static LinkNode reverseList(LinkNode head) {
        LinkNode prev = null; //前指针节点
        LinkNode nextTemp = null; //临时节点，暂存当前节点的下一节点，用于后移
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (head != null) {
            nextTemp = head.next; //①
            head.next = prev; //②将当前节点指向它前面的节点
            prev = head; //③前指针后移
            head = nextTemp; //④当前指针后移
        }

        return prev;
    }

    // 求中间结点
    public static LinkNode findMiddleNode(LinkNode list) {
        if (list == null) return null;

        LinkNode fast = list;
        LinkNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static class LinkNode {

        private String val;

        private LinkNode next;

        public LinkNode(String data){
            this.val  = data;
        }

        public String getData() {
            return val;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "["+val+"]";
        }
    }


}
