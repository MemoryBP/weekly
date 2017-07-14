package com.example.demo.until;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 陈 on 2017/7/14.
 */
@Component
@ConfigurationProperties(prefix = "QuartzConfig")
public class QuartzProperties {
    private String cronValue;

    public String getCronValue() {
        return cronValue;
    }

    public void setCronValue(String cronValue) {
        this.cronValue = cronValue;
    }
}
