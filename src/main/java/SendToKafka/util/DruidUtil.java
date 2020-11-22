package SendToKafka.util;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {
    private DruidUtil(){

    }

    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(DruidUtil.class.getClassLoader().getResourceAsStream("app.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Connection getConnection(){
        try {
            return dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail connect database");
        }
        throw new RuntimeException("fail connect database");
    }
}
