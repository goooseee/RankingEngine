package com.example.RankingEngine.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RankingEngine.DTO.ResponseDTO;
import com.example.RankingEngine.Service.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/scoring")
@RequiredArgsConstructor
public class RecommendationController {
	
	private final RecommendationService recommendationService;
	@GetMapping("/getRecommend/{userId}")
	public ResponseDTO getRecommendation(@PathVariable("userId") long userId) {
		return recommendationService.getRecommend( userId );
	}
	
}
