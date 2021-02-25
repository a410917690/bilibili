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
        System.out.println(Runtime.getRuntime().availableProcessors());

        List list0 = new Vector();
        List list1 = Collections.synchronizedList(new ArrayList<>());
        List list2 = new CopyOnWriteArrayList();
    }
}
