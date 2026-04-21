package com.example.RankingEngine.DTO;

import java.util.Map;

import com.example.RankingEngine.Entity.Movie;


public record ScoredMovieDTO(
		Long movieId,
		
		Map<String, Double> weights,
		
		double total
	){}