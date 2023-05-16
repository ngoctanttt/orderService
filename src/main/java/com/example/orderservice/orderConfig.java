package com.example.orderservice;


import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class orderConfig {

    @Bean(name = "orderProperties")
    public DataSource dataSource() {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();

        mysqlXADataSource.setUrl("jdbc:mysql://localhost:3306/start");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword("assignlnt002");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("xads1");
//        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//        // Configure data source properties, such as URL, username, and password
//        dataSource.setUniqueResourceName("myDataSource");
//        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
//        dataSource.setXaProperties(xaProperties());
//        dataSource.setPoolSize(10);
        return xaDataSource;
    }
    private Properties xaProperties() {
        Properties properties = new Properties();
        properties.setProperty("URL", "jdbc:mysql://localhost:3306/start");
        properties.setProperty("user", "root");
        properties.setProperty("password", "assignlnt002");
        return properties;
    }
}
