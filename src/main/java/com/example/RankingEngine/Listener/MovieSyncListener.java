package com.example.RankingEngine.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.RankingEngine.Configuration.RabbitMQConfig;
import com.example.RankingEngine.DTO.CreateMovieDTO;
import com.example.RankingEngine.Entity.Movie;
import com.example.RankingEngine.Service.MovieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieSyncListener {
	
	private final MovieService movieService;
	
	@RabbitListener(queues = RabbitMQConfig.MOVIE_QUEUE)
	public void handleMovieSync(CreateMovieDTO dto) {
		Movie movie = Movie.builder()
				.movieId( dto.getMovieId() )
				.rating( dto.getRating() )
				.durationOfMovieSeconds( dto.getDurationOfMovieSeconds() )
				.type( dto.getType() )
				.build();
		movieService.addMovie(movie);
	}
	
}
