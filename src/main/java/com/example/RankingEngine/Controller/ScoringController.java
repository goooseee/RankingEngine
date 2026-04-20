package com.example.RankingEngine.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RankingEngine.DTO.ScoringRequest;
import com.example.RankingEngine.DTO.UserPreferenceDTO;
import com.example.RankingEngine.DTO.UserRecommendationProfile;
import com.example.RankingEngine.DTO.UserWatchedHistory;
import com.example.RankingEngine.Service.InterestScoringService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/scoring")
@RequiredArgsConstructor
public class ScoringController {
	
	private final InterestScoringService scoringService;
	@PostMapping("/calculate")
	public List<UserPreferenceDTO> scoring(@RequestBody ScoringRequest dto){
		return scoringService.calculateInterest( dto.getProfile(), dto.getHistory() );
	}
	
}
