package com.example.RankingEngine.DTO;

import java.util.Map;

import com.example.RankingEngine.DTO.Enum.Type;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRecommendationProfile {
	private long userId; 
	private Map<Type, UserPreferenceDTO> genreWeights;
}
