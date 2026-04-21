package com.example.RankingEngine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RankingEngine.DTO.CreateMovieDTO;
import com.example.RankingEngine.Entity.Movie;
import com.example.RankingEngine.Service.MovieService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/scoring")
public class MovieController {
	
	private final MovieService movieService;
	@PostMapping("/addMovie")
	public void addMovie(@RequestBody CreateMovieDTO dto) {
		Movie movie = Movie.builder()
						.movieId( dto.getMovieId() )
						.rating( dto.getRating() )
						.durationOfMovieSeconds( dto.getDurationOfMovieSeconds() )
						.type( dto.getType() )
						.build();
		movieService.addMovie(movie);
	}
}
