package data.structure.algorithm.multithreaded;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuezp
 * @Date 2019/9/27 4:41 下午
 * @Version v1.0
 */

public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {

        People people = new People();

        for (int i = 0; i < 100; i++) {

            new Thread(()->{
                people.get();
            },"t" + i).start();

        }


    }

}
class People{

    Lock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" get");
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" set");
        }finally {
            lock.unlock();
        }
    }

}


