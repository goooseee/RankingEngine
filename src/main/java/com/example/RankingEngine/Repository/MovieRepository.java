package com.example.RankingEngine.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.RankingEngine.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query("""
			SELECT m from Movie m
			where m.id not in (
			select h.movie.id from UserWatchedMovie h where h.userId=:user_id
			)
			ORDER BY m.rating DESC
			LIMIT 100
			""")
	public List<Movie> getTopCandidte(@Param("user_id") Long userId);
	
}
