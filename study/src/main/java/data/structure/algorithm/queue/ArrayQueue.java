package data.structure.algorithm.queue;

/**
 * 用数组实现的队列
 * @Author yuezp
 * @Version v1.0
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果 tail == n 表示队列已经满了
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        // 为了让其他语言的同学看的更加明确，把 -- 操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
