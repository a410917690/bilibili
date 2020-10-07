package org.lanqiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BilibiliControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilibiliControllerApplication.class, args);
    }

}
