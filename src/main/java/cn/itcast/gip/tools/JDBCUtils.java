package cn.itcast.gip.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

//获取数据库连接得工具类
public class JDBCUtils {
    private static BasicDataSource dataSource = new BasicDataSource();
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
    }
    public static DataSource getDataSource(){
        return dataSource;
    }

}
