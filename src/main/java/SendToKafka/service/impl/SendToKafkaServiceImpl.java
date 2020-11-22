package SendToKafka.service.impl;

import SendToKafka.service.SendToKafkaService;
import SendToKafka.util.GetProperties;
import SendToKafka.util.ProduceThreadPool;
import org.apache.log4j.Logger;

public class SendToKafkaServiceImpl implements SendToKafkaService {
    private Logger logger = Logger.getLogger(SendToKafkaServiceImpl.class);
    private String topic = GetProperties.getTopic();

    @Override
    public void excutor() {
        new Thread(()->{
            ProduceThreadPool.sendData(topic,"");
        }).start();
    }
}
