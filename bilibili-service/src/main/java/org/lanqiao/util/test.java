package org.lanqiao.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.util
 * @ClassName:test
 * @Description:
 * @Date 2021/2/23 6:48
 */
public class test {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//
//        List list0 = new Vector();
//        List list1 = Collections.synchronizedList(new ArrayList<>());
//        List list2 = new CopyOnWriteArrayList();
//
//        int i = 0;
//        i = i++ + i;
//        System.out.println("I ="+i);

        int h = 0,i = 0, j = 0;
        int m = h+++h;
        int k = i+++i++;
        j = ++j+j++;
        int l = 0;
        l = l+++15+l++;
        System.out.println(h);
        System.out.println(m);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
    }
}
