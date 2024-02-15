package com.kiubit.kiubitWebAPI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class KiubitWebApiApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
            
            
		SpringApplication.run(KiubitWebApiApplication.class, args);
	}
        
	@Bean
	PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
