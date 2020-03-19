package com.paradise.all4me.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Paradise
 */
@Data
@ConfigurationProperties(prefix = "config")
public class Configuration {

    public String testCode = "777777";

}
