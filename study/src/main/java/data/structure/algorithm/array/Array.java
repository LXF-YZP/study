package data.structure.algorithm.array;


import java.util.Arrays;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是 int 类型的；
 *
 */
public class Array {

    // 定义整型数据 data 保存数据
    private int[] data;
    // 定义数组长度
    private int n;
    // 定义中实际个数
    private int count;

    // 构造方法，定义数组大小
    private Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count=0;// 一开始一个数都没有存所以为 0
    }

    private boolean change(int index, int value){

        if (index<0 || index>=count) {
            return false;
        }
        data[index] = value;
        return true;
    }

    //末尾追加
    private boolean append(int value){
        if (n == count) {
            return false;
        }

        data[count++] = value;
        return true;
    }

    // 根据索引，找到数据中的元素并返回
    private int find(int index){
        if (index<0 || index>=count) {
            return -1;
        }
        return data[index];
    }

    // 插入元素：头部插入，尾部插入
    private boolean insert(int index, int value){

        // 数组空间已满
        if (count == n) {
            System.out.println(" 没有可插入的位置 ");
            return false;
        }
        // 如果 count 还没满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0||index > count ) {
            System.out.println(" 位置不合法 ");
            return false;
        }
        // 位置合法
        for( int i = count; i > index; --i){
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }
    // 根据索引，删除数组中元素
    public boolean delete(int index){
        if (index<0 || index >=count) {
            return false;
        }
        // 从删除位置开始，将后面的元素向前移动一位
        for (int i=index+1; i<count; ++i){
            data[i-1] = data[i];
        }

        --count;
        return true;
    }
    private void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
        int i = array.find(4);
        System.out.println(i);
        boolean delete = array.delete(2);
        array.printAll();
        array.append(10);
        array.printAll();
        array.change(4, 11);
        array.printAll();

    }




}
