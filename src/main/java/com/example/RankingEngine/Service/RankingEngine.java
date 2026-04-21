package com.example.RankingEngine.Service;

import java.util.List;

import com.example.RankingEngine.DTO.ScoredMovieDTO;
import com.example.RankingEngine.Entity.Movie;


public interface RankingEngine {
	
	public List<ScoredMovieDTO> calculateWeights(Long userId, List<Movie> candidates);
	
}
