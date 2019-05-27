package top.godder.datamodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScans({@ComponentScan(value = "top.godder.datamodule"), @ComponentScan("top.godder.infrastructurecommon.util")})
@EnableFeignClients(basePackages = "top.godder.usermoduleapi.service")
@EnableSwagger2
@MapperScan(basePackages = "top.godder.datamodule.infrastructure.mapper")
public class DataModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataModuleApplication.class, args);
    }

}
