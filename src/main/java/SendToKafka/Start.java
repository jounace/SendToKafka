package SendToKafka;

import SendToKafka.service.SendToKafkaService;
import SendToKafka.service.impl.SendToKafkaServiceImpl;

public class Start {
    public static void main(String args[]) throws InterruptedException {
        SendToKafkaService a = new SendToKafkaServiceImpl();
        while (true){
            a.excutor();
            Thread.sleep(10000);
        }
    }
}
