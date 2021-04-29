package org.lanqiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import org.springframework.util.unit.DataSize;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;


@EnableSwagger2
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BilibiliControllerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BilibiliControllerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BilibiliControllerApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
//允许上传的文件最大值
        factory.setMaxFileSize(DataSize.parse("100MB")); //KB,MB
/// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("100MB"));
        return factory.createMultipartConfig();
    }


}
