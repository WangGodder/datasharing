package top.godder.datamodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@MapperScan(basePackages = "top.godder.datamodule.infrastructure.mapper")
public class DataModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataModuleApplication.class, args);
    }

}
