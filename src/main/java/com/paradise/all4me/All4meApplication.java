package com.paradise.all4me;

import com.paradise.all4me.config.Configuration;
import com.paradise.all4me.config.JwtConfiguration;
import com.paradise.all4me.config.RegexpConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Paradise
 */
@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties({JwtConfiguration.class, RegexpConfiguration.class, Configuration.class})
public class All4meApplication {

    public static void main(String[] args) {
        SpringApplication.run(All4meApplication.class, args);
    }

}
