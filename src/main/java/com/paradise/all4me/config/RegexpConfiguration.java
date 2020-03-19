package com.paradise.all4me.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Paradise
 */
@ConfigurationProperties(prefix = "regexp")
public class RegexpConfiguration {

    public static final String UID = "U\\d{6}[A-Z]{2}";
    public static final String TELEPHONE = "";

}
