package com.baizhi.conf;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = JdbcProp.class)
public class JavaConf {
  /*@Value("${jdbc.url}")
    String url;
    @Value("${jdbc.password}")
    String password;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.driver}")
    String driver;*/

   @Autowired
   JdbcProp jdbcProp;

    @Bean
//    /@ConfigurationProperties(prefix = "jdbc")
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(jdbcProp.url);
        druidDataSource.setPassword(jdbcProp.password);
        druidDataSource.setUsername(jdbcProp.username);
        druidDataSource.setDriverClassName(jdbcProp.driver);
        return druidDataSource;
    }
}
