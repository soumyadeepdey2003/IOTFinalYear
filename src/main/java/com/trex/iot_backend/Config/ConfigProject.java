package com.trex.iot_backend.Config;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigProject {

    @Bean
    public Cloudinary coudinaryConfig() {

        Map config = new HashMap();
        config.put("cloud_name", "IOTPROJECT");
        config.put("api_key", "976873522311814");
        config.put("api_secret", "vsmrugl6CG33ES5ivVN2uZZNZFQ");
        config.put("secure", true);
        return new Cloudinary(config);

    }
}
