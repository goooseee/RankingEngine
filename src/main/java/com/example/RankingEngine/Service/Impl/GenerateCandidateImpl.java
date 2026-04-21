package com.example.RankingEngine.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RankingEngine.Entity.Movie;
import com.example.RankingEngine.Repository.MovieRepository;
import com.example.RankingEngine.Service.GenerateCandidate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class GenerateCandidateImpl implements GenerateCandidate{
	
	private final MovieRepository movieRepository; 
	
	@Override
	public List<Movie> getCandidate(Long userId) {
		log.atInfo().log("[GenerateCandidate] Getting candidate for {}", userId);
		System.out.println( movieRepository.findAll() );
		return movieRepository.findAll();
		//return movieRepository.getTopCandidte(userId);
	}

}
