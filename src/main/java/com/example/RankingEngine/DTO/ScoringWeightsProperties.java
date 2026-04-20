package com.example.RankingEngine.DTO;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.example.RankingEngine.DTO.Enum.Reaction;
import com.example.RankingEngine.DTO.Enum.RecentyType;


@ConfigurationProperties(prefix = "scoring.weights")
public record ScoringWeightsProperties(
		Map<Reaction, Double> reaction,
        Map<RecentyType, Double> recency
	) {

}
