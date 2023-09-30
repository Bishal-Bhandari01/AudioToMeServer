package com.audiotome.audiotomeserver.audiobook;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfiguration {
<<<<<<< HEAD
    private final String cloudName="dgz0segqe";
    private final String apiKey = "878172427442436";
    private final String apiSecret = "ABMcRsrQIJxuP75FhvT-JqHEn1M";
    @Bean
    public Cloudinary cloudinary(){
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name",cloudName);
        config.put("api_key",apiKey);
        config.put("api_secret",apiSecret);
=======
    private final String cloudName = "dgz0segqe";
    private final String apiKey = "878172427442436";
    private final String apiSecret = "ABMcRsrQIJxuP75FhvT-JqHEn1M";

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
>>>>>>> 17faaac ( new server hosting)
        return new Cloudinary(config);
    }
}
