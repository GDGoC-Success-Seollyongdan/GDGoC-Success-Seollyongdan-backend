package com.example.seollyongbackend;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//배치 사용
//@EnableBatchProcessing
@SpringBootApplication
@EnableScheduling
public class SeollyongbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeollyongbackendApplication.class, args);
	}

}
