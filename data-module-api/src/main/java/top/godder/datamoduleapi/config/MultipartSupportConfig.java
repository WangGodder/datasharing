package top.godder.datamoduleapi.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;

/**
 * @author: godder
 * @date: 2019/5/21
 */
public class MultipartSupportConfig {
    @Bean
    public SpringFormEncoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
