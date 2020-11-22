package SendToKafka.util;

import java.io.*;
import java.util.Properties;

public class GetProperties {
    private static String broken_list;
    private static String topic;
    private static int corepoolsize;
    private static int maximumpoolsize;

    public static String getBroken_list() {
        return broken_list;
    }

    public static void setBroken_list(String broken_list) {
        GetProperties.broken_list = broken_list;
    }

    public static String getTopic() {
        return topic;
    }

    public static void setTopic(String topic) {
        GetProperties.topic = topic;
    }

    public static int getCorepoolsize() {
        return corepoolsize;
    }

    public static void setCorepoolsize(int corepoolsize) {
        GetProperties.corepoolsize = corepoolsize;
    }

    public static int getMaximumpoolsize() {
        return maximumpoolsize;
    }

    public static void setMaximumpoolsize(int maximumpoolsize) {
        GetProperties.maximumpoolsize = maximumpoolsize;
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(String.valueOf(GetProperties.class.getClassLoader().getResourceAsStream("app.properties"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        broken_list=properties.getProperty("broken_list");
        topic=properties.getProperty("topic");
        corepoolsize= Integer.parseInt(properties.getProperty("corepoolsize"));
        maximumpoolsize = Integer.parseInt(properties.getProperty("maximumpoolsiez"));
    }
}
