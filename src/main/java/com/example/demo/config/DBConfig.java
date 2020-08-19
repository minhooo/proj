package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// Configuration은 설정파일임을 명시하는 부분이다.
// 몇몇 특정 지정된 키워드들을 제외한 사용자 커스텀 클래스의 경우엔
// 설정 파일임을 명시해줄 필요성이 있다.

@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false"
        );
        dataSource.setUsername("bitai");
        dataSource.setPassword("456123");
        return dataSource;
    }
}
