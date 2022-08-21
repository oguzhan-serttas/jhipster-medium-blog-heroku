package com.oguzhanserttas.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "medium")
@Getter
@Setter
public class MediumProperties {

    private String baseUrl;
    private String accessToken;
}
