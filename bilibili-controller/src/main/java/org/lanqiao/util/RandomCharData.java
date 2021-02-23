package org.lanqiao.util;

import java.util.Random;

/**
 * @author Sonnie
 */
public class RandomCharData {
    /**
     * 根据指定长度生成字母和数字的随机数
     */
    public static String createRandomCharData(int length)
    {
        StringBuilder sb=new StringBuilder();
        Random rand=new Random();
        Random randData=new Random();
        int data=0;
        for(int i=0;i<length;i++)
        {
//            index=0||1||2
            int index=rand.nextInt(3);
            //目的是随机选择生成数字，大小写字母
            switch(index)
            {
                //仅仅会生成0~9
                case 0:
                    data=randData.nextInt(10);
                    sb.append(data);
                    break;
                //保证只会产生65~90之间的整数
                case 1:
                    data=randData.nextInt(26)+65;
                    sb.append((char)data);
                    break;
                //保证只会产生97~122之间的整数
                case 2:
                    data=randData.nextInt(26)+97;
                    sb.append((char)data);
                    break;
            }
        }
        String result=sb.toString();
        return result;
    }
}
