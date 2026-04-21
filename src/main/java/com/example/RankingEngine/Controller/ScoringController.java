package com.example.RankingEngine.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RankingEngine.DTO.ResponseDTO;
import com.example.RankingEngine.DTO.ScoringRequest;
import com.example.RankingEngine.Entity.UserPreference;
import com.example.RankingEngine.Entity.UserWatchedMovie;
import com.example.RankingEngine.Service.InterestScoringService;
import com.example.RankingEngine.Service.UserPreferenceService;
import com.example.RankingEngine.Service.UserWatchedMovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/scoring")
@RequiredArgsConstructor
public class ScoringController {
	
	private final InterestScoringService scoringService;
	
	private final UserPreferenceService preferenceService;
	
	private final UserWatchedMovieService watchedMovieService;
	
	@PostMapping("/calculate")
	public void scoring(@RequestBody Long userId){
		
		List<UserPreference> preferences = preferenceService.getByUserId( userId );
		List<UserWatchedMovie> watchedMovies = watchedMovieService.getAllByUser( userId );
		preferenceService.saveAll(scoringService.calculateInterest( preferences, userId, watchedMovies ));
	}
	
}
