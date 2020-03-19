package com.paradise.all4me.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Paradise
 */
@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtConfiguration {

    private String tokenHeader;
    private String secret;
    private String expiration;
    private String tokenHead;

}
