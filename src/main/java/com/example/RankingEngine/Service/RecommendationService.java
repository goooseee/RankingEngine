package com.example.RankingEngine.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.RankingEngine.DTO.ResponseDTO;
import com.example.RankingEngine.DTO.ScoredMovieDTO;
import com.example.RankingEngine.Entity.Movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class RecommendationService {
	
	private final GenerateCandidate generateCandidate;
	
    private final RankingEngine rankingEngine;
    
    //private final RedisService redisService;
    
	public ResponseDTO getRecommend(Long userId){	
		
		//List<MovieResponseDTO> scoredMovieDTO = redisService.getDataFromRedis( user.getId() );
		
//		if(scoredMovieDTO != null) {
//			log.atInfo().log("[RecomendationService] Cache HIT for user {}", user.getId());
//			return scoredMovieDTO;
//		}
		
		log.atInfo().log("[RecomendationService] Cache MISS for user {}. Calculating recommendations...", userId);
		
		List<Movie> candidates = generateCandidate.getCandidate( userId );
		System.out.println( candidates.toString() );
		List<ScoredMovieDTO> scoredMovie = rankingEngine.calculateWeights( userId, candidates );
		System.out.println( scoredMovie.toString() );
		List<Long> movieId = scoredMovie.stream().map( s -> s.movieId() ) .toList();
		
		ResponseDTO dto = convert( userId, movieId );
		
		//redisService.addDataToRedis( user.getId(), movieResponseDTO );
		
		return dto;
	}
	
	private ResponseDTO convert (Long userId, List<Long> movieId) {
		
		
		return new ResponseDTO( userId, movieId );
	}
}
