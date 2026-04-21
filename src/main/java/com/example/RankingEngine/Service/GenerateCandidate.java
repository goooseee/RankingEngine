package com.example.RankingEngine.Service;

import java.util.List;

import com.example.RankingEngine.Entity.Movie;


public interface GenerateCandidate {
	
	public List<Movie> getCandidate(Long userId);
	
}
