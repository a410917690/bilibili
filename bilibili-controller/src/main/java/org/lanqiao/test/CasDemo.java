package org.lanqiao.test;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.test
 * @ClassName:CasDemo
 * @Description:
 * @Date 2021/3/10 17:24
 */
public class CasDemo {

    public static void main(String[] args) {
        try {
            casDemo();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void casDemo() throws Exception{
        Num num = new Num();
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(num.n,1);

        /*如果自定义那么初始值为0*/
        AtomicInteger atomicInteger = new AtomicInteger(atomicStampedReference.getStamp());
//
//        new Thread(() -> {
//            atomicInteger.getAndIncrement();
//        }, "A").start();
//
//        new Thread(() -> {
//            atomicInteger.getAndIncrement();
//        }, "B").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
//            atomicInteger.compareAndSet(12, 13);
            boolean b = atomicStampedReference.compareAndSet(10, 11, stamp, stamp + 1);
            System.out.println("isUpdate:" + b);
            System.out.println(Thread.currentThread().getName() + "-atomicStampedReference:" + atomicStampedReference.getReference()+" stamp:"+atomicStampedReference.getStamp());

        }, "C").start();

        new Thread(() -> {
//            atomicInteger.compareAndSet(13,14);
//            atomicInteger.compareAndSet(14,12);
            int stamp1 = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(10, 11, stamp1, stamp1+1);
            int stamp2 = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(11, 10, stamp2, stamp2+1);
        }, "D").start();

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "-atomicStampedReference:" + atomicStampedReference.getReference()+" stamp:"+atomicStampedReference.getStamp());
        }

    }
}


@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Num implements Serializable {
    volatile int n = 10;
}
