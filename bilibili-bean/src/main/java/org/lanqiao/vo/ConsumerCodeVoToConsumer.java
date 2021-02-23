package org.lanqiao.vo;

import org.lanqiao.entity.TConsumers;

import java.io.Serializable;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.vo
 * @ClassName:ConsumerCodeVoToConsumer
 * @Description:
 * @Date 2021/2/8 10:23
 */
public class ConsumerCodeVoToConsumer implements Serializable {
    public static TConsumers toConsumer(ConsumerCodeVo consumerCodeVo) {

        //创建一个数据库中存储的对象
        TConsumers tConsumers = new TConsumers();

        //传值
        tConsumers.setName(consumerCodeVo.getName());
        tConsumers.setPassword(consumerCodeVo.getPassword());
        tConsumers.setMail(consumerCodeVo.getMail());

        // 返回包装后的对象
        return tConsumers;
    }
}
