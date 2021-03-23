package org.lanqiao.config.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaConfig {

//    private static KafkaProducer<String, String> kafkaProducer;

    private static KafkaConsumer<String, String> kafkaConsumer;

//    public static KafkaProducer<String, String> getKafkaProducer() {
//
//        if (null == kafkaProducer) {
//            synchronized (KafkaConfig.class) {
//                if (null == kafkaProducer) {
//                    //1.创建用于连接Kafka的Properties配置
//                    Properties props = new Properties();
//                    props.put("acks", "1");
//                    props.put("bootstrap.servers", "106.12.195.187:9092");
//                    props.put("retries", 0);
//                    props.put("batch.size", 16384);
//
//                    props.put("linger.ms", 1);
//                    props.put("buffer.memory", 33554432);
//                    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//                    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//                    kafkaProducer = new KafkaProducer<>(props);
//                }
//            }
//        }
//        return kafkaProducer;
//    }

    public static KafkaConsumer<String, String> getKafkaConsumer() {
        if (null == kafkaConsumer){
            synchronized (KafkaConfig.class){
                if (null == kafkaConsumer){
                    Properties props = new Properties();
//                    props.put("bootstrap.servers", "127.0.0.1:9092,127.0.0.1:9093");
                    props.put("bootstrap.servers", "106.12.195.187:9092");
                    //每个消费者分配独立的组号
                    props.put("group.id", "test");
                    //如果value合法，则自动提交偏移量
                    props.put("enable.auto.commit", "true");
                    //设置多久一次更新被消费消息的偏移量
                    props.put("auto.commit.interval.ms", "1000");
                    //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
                    props.put("session.timeout.ms", "30000");
                    //自动重置offset
                    props.put("auto.offset.reset","earliest");
                    props.put("key.deserializer",
                            "org.apache.kafka.common.serialization.StringDeserializer");
                    props.put("value.deserializer",
                            "org.apache.kafka.common.serialization.StringDeserializer");
                    kafkaConsumer = new KafkaConsumer<String, String>(props);
                }
            }
        }
        return kafkaConsumer;
    }

}

