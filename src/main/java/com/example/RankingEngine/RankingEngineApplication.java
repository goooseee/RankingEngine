package com.example.RankingEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.RankingEngine.DTO.ScoringWeightsProperties;

@SpringBootApplication
@EnableConfigurationProperties(ScoringWeightsProperties.class)
public class RankingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankingEngineApplication.class, args);
	}

}
