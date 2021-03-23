package org.lanqiao.test;

import java.util.concurrent.TimeUnit;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.controller
 * @ClassName:test
 * @Description:
 * @Date 2021/3/1 14:19
 */
public class test {

    /**
     * 验证volatile的可见性
     * 1.1 加入int number=0，number变量之前根本没有添加volatile关键字修饰，没有可见性
     * 1.2 添加了volatile，可以解决可见性问题
     */
    public static void volatileTest1(){
        MyData myData = new MyData();
        //启动一个线程操作共享数据
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.changeNum();
                System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();


        while (myData.num == 0) {
            //main线程持有共享数据的拷贝，一直为0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over. main get number value: " + myData.num);
    }

    public static void main(String[] args) throws Exception {

    }
}

class MyData{
    volatile int num = 0;

    public void changeNum(){
        this.num = 10;
    }

}
