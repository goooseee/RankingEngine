package com.example.RankingEngine.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.RankingEngine.Entity.UserWatchedMovie;

public interface UserWatchedMovieRepository extends JpaRepository<UserWatchedMovie, Long>{
	
	public List<UserWatchedMovie> getByUserId(Long userId);
	
}
