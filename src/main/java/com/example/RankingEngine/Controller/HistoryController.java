package com.example.RankingEngine.Controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RankingEngine.DTO.CreateHistoryDTO;
import com.example.RankingEngine.Entity.Movie;
import com.example.RankingEngine.Entity.UserWatchedMovie;
import com.example.RankingEngine.Service.MovieService;
import com.example.RankingEngine.Service.UserWatchedMovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/scoring")
public class HistoryController {
	
	private final UserWatchedMovieService watchedMovieService;
	
	private final MovieService movieService;
	@PostMapping("/addHistory")
	public void createHistory(@RequestBody CreateHistoryDTO dto) {
		Movie movie = movieService.getById( dto.getMovieId() ).orElse( null );
		
		UserWatchedMovie wMovie = UserWatchedMovie.builder()
									.durationSeconds( dto.getDurationSeconds() )
									.movie( movie )
									.react( dto.getReact() )
									.timesWatched( dto.getTimesWatched() )
									.userId( dto.getUserId() )
									.whenWatched( LocalDate.now() )
									.build();
		watchedMovieService.addHistory( wMovie );
	}
	
}
