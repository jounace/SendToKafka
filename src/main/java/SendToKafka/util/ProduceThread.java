package SendToKafka.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProduceThread implements Runnable{
    private KafkaProducer<String,String> producer;
    private ProducerRecord<String,String> record;

    ProduceThread(KafkaProducer<String,String> producer,ProducerRecord<String,String> record){
        this.producer=producer;
        this.record=record;
    }

    public void run() {
        producer.send(record);
    }
}
