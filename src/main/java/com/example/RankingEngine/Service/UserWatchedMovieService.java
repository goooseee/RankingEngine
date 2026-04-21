package com.example.RankingEngine.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RankingEngine.Entity.UserWatchedMovie;
import com.example.RankingEngine.Repository.UserWatchedMovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserWatchedMovieService {
	
	private final UserWatchedMovieRepository watchedRepository;
	
	public List<UserWatchedMovie> getAllByUser(Long userId){
		return watchedRepository.getByUserId( userId );
	}
	
	public void addHistory(UserWatchedMovie movie) {
		watchedRepository.save( movie );
	}
}
