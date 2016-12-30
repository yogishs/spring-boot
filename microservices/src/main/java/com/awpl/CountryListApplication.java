package com.awpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CountryListApplication
{
	public static void main(String[] args) throws Exception 
    {
        SpringApplication.run(CountryListApplication.class, args);
    }
}
