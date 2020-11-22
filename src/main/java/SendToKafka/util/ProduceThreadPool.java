package SendToKafka.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProduceThreadPool {

    private static Properties properties = new Properties();
    private static KafkaProducer<String, String> producer;
    private static ThreadPoolExecutor service;
    private static TimeUnit timeUnit = TimeUnit.SECONDS;
    private static BlockingQueue blockingQueue = new LinkedBlockingDeque<Runnable>();
    private static Logger logger = Logger.getLogger(ProduceThreadPool.class);

    static {
        int corePoolSize = GetProperties.getCorepoolsize();
        properties.put("bootstrap.servers", GetProperties.getBroken_list());
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "0");
        properties.put("connection.max.idle.ms", "-1");
        producer = new KafkaProducer<String, String>(properties);
        int maximumPoolSize=GetProperties.getMaximumpoolsize();
        long keepAliveTime=60;
        service=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,timeUnit,blockingQueue);
        System.out.println("init ok");
    }

    public static void sendData(String topic,String msg){
        try {
            ProducerRecord<String,String> record = new ProducerRecord<>(topic,msg);
            service.submit(new ProduceThread(producer,record));
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.toString());
        }
    }
}
