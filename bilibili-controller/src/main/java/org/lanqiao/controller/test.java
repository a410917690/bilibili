package org.lanqiao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.controller
 * @ClassName:test
 * @Description:
 * @Date 2021/3/1 14:19
 */
public class test {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sf  =new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        Date beVipTime =sf.parse("2021-02-28");
        long diff = d.getTime() - beVipTime.getTime();//这样得到的差值是毫秒级别
        long days = diff / (1000 * 60 * 60 * 24);
        System.out.println(days);


    }
}
