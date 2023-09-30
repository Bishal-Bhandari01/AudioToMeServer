package com.audiotome.audiotomeserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AudiotomeserverApplication {
	public static void main(String[] args) {
		SpringApplication.run(AudiotomeserverApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
=======
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AudiotomeserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(AudiotomeserverApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
>>>>>>> 17faaac ( new server hosting)

}
